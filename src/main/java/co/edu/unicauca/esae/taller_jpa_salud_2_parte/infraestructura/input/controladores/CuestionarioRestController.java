package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.controladores;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.PreguntaDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.RespuestaDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.EstructuraExcepciones.CodigoError;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.EstructuraExcepciones.Error;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.EstructuraExcepciones.ErrorUtils;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.ExcepcionesPropias.DocenteYaRespondioException;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.PreguntaEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.input.GestionarCuestionarioCUIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.GestionarRespuestaGatewayIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Pregunta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Respuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.DocenteDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.PreguntaDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.RespuestaDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.CuestionarioDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.DocenteDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.mappers.CuestionarioMapperInfraestructuraDominio;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.gateway.GestionarRespuestaGatewayImpAdapter;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class CuestionarioRestController {

    private final GestionarCuestionarioCUIntPort objGestionarCuestionarioCUInt;
    private final GestionarDocenteCUIntPort objGestionarDocenteCUInt;
    private final GestionarRespuestaGatewayIntPort objRespuestaGatewayAdapter;
    private final ModelMapper modelMapper;
    private final CuestionarioMapperInfraestructuraDominio objMapeador;


    @PostMapping("/cuestionarios")
    public ResponseEntity<CuestionarioDTORespuesta> create(@Valid @RequestBody CuestionarioDTOPeticion objCuestionario) {
        Cuestionario objCuestionarioCrear = modelMapper.map(objCuestionario,Cuestionario.class);
        Cuestionario objCuestionarioCreado = objGestionarCuestionarioCUInt.crearCuestionario(modelMapper.map(objCuestionarioCrear, Cuestionario.class));
        ResponseEntity<CuestionarioDTORespuesta> objRespuesta = new ResponseEntity<CuestionarioDTORespuesta>(
                modelMapper.map(objCuestionarioCreado, CuestionarioDTORespuesta.class),
                HttpStatus.CREATED);
        return objRespuesta;
    }


    @GetMapping("/cuestionarios")
    public ResponseEntity<List<CuestionarioDTORespuesta>> listar() {
        Iterable<Cuestionario> cuestionarios = this.objGestionarCuestionarioCUInt.listarCuestionarios();
        List<CuestionarioDTORespuesta> listCuestionarios = this.modelMapper.map(cuestionarios,
                new TypeToken<List<CuestionarioDTORespuesta>>() {
                }.getType());
        ResponseEntity<List<CuestionarioDTORespuesta>> objRespuesta = new ResponseEntity<List<CuestionarioDTORespuesta>>
                (listCuestionarios,
                        HttpStatus.OK
                );
        return objRespuesta;
    }

    @GetMapping("/cuestionarios/patron-titulo")
    public ResponseEntity<List<CuestionarioDTORespuesta>> findAllPatron(@RequestParam String patronTitulo ) {
        List<CuestionarioDTORespuesta> cuestionarios = this.objGestionarCuestionarioCUInt.consultarCuestionarioPorPatron(patronTitulo);

        ResponseEntity<List<CuestionarioDTORespuesta>> response = new ResponseEntity<List<CuestionarioDTORespuesta>>
                (cuestionarios,
                        HttpStatus.OK);
        return response;
    }


        @PostMapping("/registrar-respuestas")
        public ResponseEntity<?> registrarRespuestas(@RequestBody Map<String, Object> request) {
                try{
                        // Extraer los objetos del mapa
                        ObjectMapper mapper = new ObjectMapper();

                        DocenteDTOPeticion docente = mapper.convertValue(request.get("docente"), DocenteDTOPeticion.class);
                        CuestionarioDTOPeticion cuestionario = mapper.convertValue(request.get("cuestionario"), CuestionarioDTOPeticion.class);
                        List<PreguntaDTOPeticion> preguntas = mapper.convertValue(request.get("preguntas"), new TypeReference<List<PreguntaDTOPeticion>>() {});

                        Docente objDocenteCrear = modelMapper.map(docente,Docente.class);
                        Cuestionario objCuestionarioCrear = modelMapper.map(cuestionario,Cuestionario.class);
                        List<Pregunta> objPreguntas = preguntas.stream()
                                .map(preguntaDTO -> modelMapper.map(preguntaDTO, Pregunta.class))
                                .collect(Collectors.toList());

                        objRespuestaGatewayAdapter.registrarRespuesta(objDocenteCrear, objCuestionarioCrear, objPreguntas);
                        return ResponseEntity.ok().build();
                }catch (DocenteYaRespondioException e) {
                        Error error = ErrorUtils.crearError(CodigoError.VIOLACION_REGLA_DE_NEGOCIO.getCodigo(), e.getMessage(), HttpStatus.BAD_REQUEST.value());
                        return ResponseEntity.badRequest().body(error);
                } catch (Exception e) {
                        Error error = ErrorUtils.crearError(CodigoError.ERROR_GENERICO.getCodigo(), CodigoError.ERROR_GENERICO.getLlaveMensaje(), HttpStatus.INTERNAL_SERVER_ERROR.value());
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
                }
        }


    @GetMapping("/consultar-respuestas")
    public ResponseEntity<List<RespuestaDTORespuesta>> consultarRespuestas(@RequestParam Integer idDocente) {
        System.out.println(" contrrolle idDocente: " + idDocente);
        DocenteDTORespuesta docente = this.objGestionarDocenteCUInt.obtenerDocenteDTOPorId(idDocente);
        System.out.println("docenteDTO: " + docente.toString() + docente.getNombres());

        Iterable<Respuesta> resp = this.objGestionarCuestionarioCUInt.listarCuestionariosPorDocente(idDocente);
        List<RespuestaDTORespuesta> listaRespuestas = this.modelMapper.map(resp,
                new TypeToken<List<RespuestaDTORespuesta>>() {
                }.getType());
        for (RespuestaDTORespuesta respuesta : listaRespuestas) {
            CuestionarioDTORespuesta cuestionario = this.objGestionarCuestionarioCUInt.obtenerCuestionarioDTOPorRespuesta(respuesta.getIdrespuesta());

            List<PreguntaDTORespuesta> preguntas = objGestionarCuestionarioCUInt.obtenerPreguntasPorCuestionario(cuestionario.getIdcuestionario());
            objRespuestaGatewayAdapter.consultarRespuesta(docente, cuestionario, preguntas);

            respuesta.setObjCuestionario(cuestionario);
            respuesta.setObjDocente(docente);
            respuesta.setPreguntas(preguntas);

        }

        return new ResponseEntity<>(listaRespuestas, HttpStatus.OK);
    }




}


