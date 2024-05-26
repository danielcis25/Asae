package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.gateway;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.CuestionarioDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.DocenteDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.PreguntaDTORespuesta;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.GestionarRespuestaGatewayIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Pregunta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Respuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.RespuestaDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.RespuestaDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.PreguntaEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.RespuestaEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios.CuestionarioRepository;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios.DocenteRepository;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios.PreguntasRepository;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios.RespuestasRepository;

@Service
public class GestionarRespuestaGatewayImpAdapter implements GestionarRespuestaGatewayIntPort {
    private final ModelMapper DocenteModelMapper;
    private final DocenteRepository objDocenteRepository;
    private final CuestionarioRepository objCuestionarioRepository;
    private final PreguntasRepository objPreguntasRepository;
    private final RespuestasRepository objRespuestasRepository;
    public GestionarRespuestaGatewayImpAdapter(DocenteRepository objDocenteRepository,CuestionarioRepository objCuestionarioRepository,
    PreguntasRepository objPreguntasRepository,RespuestasRepository objRespuestasRepository,ModelMapper DocenteModelMapper){
        this.DocenteModelMapper = DocenteModelMapper;
        this.objCuestionarioRepository = objCuestionarioRepository;
        this.objDocenteRepository = objDocenteRepository;
        this.objPreguntasRepository = objPreguntasRepository;
        this.objRespuestasRepository = objRespuestasRepository;
    }
    @Override
    public void registrarRespuesta(Docente objDocente, Cuestionario objCuestionario,List<Pregunta> objPreguntas) {
        //validacion existencia docente 
        DocenteEntity docente = objDocenteRepository.findById(objDocente.getIdpersona()).
        orElseThrow(() -> new IllegalArgumentException("Docente no encontrado"));

        //validacion existencia cuestionario
        CuestionarioEntity cuestionario = objCuestionarioRepository.findById(objCuestionario.getIdcuestionario())
        .orElseThrow(() -> new IllegalArgumentException("Cuestionario no encontrado"));

        for(Pregunta preguntaDTO: objPreguntas){
            //validacion existenia de pregunta asocaida a la respuesta
            PreguntaEntity pregunta = objPreguntasRepository.findById(preguntaDTO.getIdpregunta())
            .orElseThrow(() -> new IllegalArgumentException("Pregunta no encontrada"));

            for(Respuesta respuestaDTO: preguntaDTO.getListaRespuestas()){
                Pregunta objPreguntaRespuesta = DocenteModelMapper.map(pregunta, Pregunta.class);
                Docente objDocenteEncontrado = DocenteModelMapper.map(docente,Docente.class);
                // Cuestionario objCuestionarioEncontrado = DocenteModelMapper.map(cuestionario,Cuestionario.class);
                Respuesta respuesta = new Respuesta();
                //respuesta.setDescripcion(preguntaDTO.getListaRespuestas().get(0).toString());
                respuesta.setDescripcion(respuestaDTO.getDescripcion());
                respuesta.setObjPregunta(objPreguntaRespuesta);
                respuesta.setObjDocente(objDocenteEncontrado);
                
                RespuestaEntity objRespuestaEntity = DocenteModelMapper.map(respuesta, RespuestaEntity.class);
                objRespuestasRepository.save(objRespuestaEntity);
            }
                


        }

    }


    @Override
    public void consultarRespuesta(DocenteDTORespuesta docente, CuestionarioDTORespuesta cuestionario, List<PreguntaDTORespuesta> preguntas) {
        System.out.println("ENTRO A CONSULTAR RESPUESTA");
        System.out.println("ENTRO A CONSULTAR RESPUESTA"+docente.getIdPersona());
        DocenteEntity docenteEntity = objDocenteRepository.findById(docente.getIdPersona())
                .orElseThrow(() -> new IllegalArgumentException("Docente no encontrado"));

        CuestionarioEntity cuestionarioEntity = objCuestionarioRepository.findById(cuestionario.getIdcuestionario())
                .orElseThrow(() -> new IllegalArgumentException("Cuestionario no encontrado"));

        for (PreguntaDTORespuesta preguntaDTO : preguntas) {
            PreguntaEntity preguntaEntity = objPreguntasRepository.findById(preguntaDTO.getIdpregunta())
                    .orElseThrow(() -> new IllegalArgumentException("Pregunta no encontrada"));

            List<RespuestaEntity> respuestasEntity = objRespuestasRepository.findByPregunta(preguntaEntity.getIdpregunta());
            List<Respuesta> respuestas = respuestasEntity.stream()
                    .map(respuestaEntity -> DocenteModelMapper.map(respuestaEntity, Respuesta.class))
                    .collect(Collectors.toList());

            List<RespuestaDTORespuesta> listaRespuestas = respuestas.stream()
                    .map(respuesta -> {
                        RespuestaDTORespuesta respuestaEnt = DocenteModelMapper.map(respuesta, RespuestaDTORespuesta.class);
                        return respuestaEnt;
                    })
                    .collect(Collectors.toList());
            preguntaDTO.setListaRespuestas(listaRespuestas);
        }
    }


}
