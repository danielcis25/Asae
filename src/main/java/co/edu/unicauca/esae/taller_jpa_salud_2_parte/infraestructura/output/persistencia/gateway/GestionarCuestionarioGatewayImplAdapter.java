package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.gateway;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.CuestionarioDTORespuesta;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.PreguntaEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.TipoPreguntaEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios.CuestionarioRepository;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios.TipoPreguntasRepository;
@Service
public class GestionarCuestionarioGatewayImplAdapter implements GestionarCuestionarioGatewayIntPort {

    private final CuestionarioRepository objCuestionarioRepository;
    private final ModelMapper CuestionarioModelMapper;
    private final TipoPreguntasRepository tipoPreguntaRepository;

    public GestionarCuestionarioGatewayImplAdapter(CuestionarioRepository objCuestionarioRepository,
                                                   ModelMapper CuestionarioModelMapper,TipoPreguntasRepository tipoPreguntaRepository){
        this.objCuestionarioRepository = objCuestionarioRepository;
        this.CuestionarioModelMapper = CuestionarioModelMapper;
        this.tipoPreguntaRepository = tipoPreguntaRepository;
    }

    
    @Override
    public boolean existeCuestionarioPorTitulo(String titulo) {
        return this.objCuestionarioRepository.existeCuestionarioPorTitulo(titulo) == 1;
    }

    //
    @Override
    public Cuestionario guardarCuestionario(Cuestionario objCuestionario) {
        // Mapeo de las preguntas asociadas
        CuestionarioEntity objCuestionarioEntity = this.CuestionarioModelMapper.map(objCuestionario, CuestionarioEntity.class);
        List<PreguntaEntity> objPreguntaEntity = objCuestionario.getPreguntas().stream()
            .map(pregunta -> {
                PreguntaEntity preguntaEntity = CuestionarioModelMapper.map(pregunta, PreguntaEntity.class);
                //==========
                // Buscar y asignar TipoPreguntaEntity existente revisar por que no esta haciendo la relacion
                TipoPreguntaEntity tipoPreguntaEntity = tipoPreguntaRepository.findById(pregunta.getObjTipoPregunta().getIdTipoPregunta())
                        .orElseThrow(() -> new IllegalArgumentException("TipoPreguntaEntity no encontrada con ID: " + pregunta.getObjTipoPregunta().getIdTipoPregunta()));
                
                preguntaEntity.setObjTipoPregunta(tipoPreguntaEntity);
                //========
                // Establecer la relación con el cuestionario
                preguntaEntity.setObjCuestionario(objCuestionarioEntity);
                return preguntaEntity;
            })
            .collect(Collectors.toList());

        // Asignar las preguntas al cuestionario
        // objCuestionario.setPreguntas(objPreguntaEntity.stream()
        // .map(CuestionarioModelMapper::mapToDomain) // Mapear de vuelta a entidades de dominio
        // .collect(Collectors.toList()));
        objCuestionarioEntity.setPreguntas(objPreguntaEntity);
        //revisar va o no
        //objPreguntaEntity.forEach(pregunta -> pregunta.setObjCuestionario(objCuestionarioEntity));
        //PreguntaEntity objPreguntaEntity = this.CuestionarioModelMapper(objCuestionario.getPreguntas(),PreguntaEntity.class);
       
        CuestionarioEntity objCuestionarioEntityCreado = this.objCuestionarioRepository.save(objCuestionarioEntity);
        Cuestionario objCuestionarioRespuesta = this.CuestionarioModelMapper.map(objCuestionarioEntityCreado, Cuestionario.class);
        return objCuestionarioRespuesta;
    }


    @Override
    public List<Cuestionario> listarCuestionarios() {
        Iterable<CuestionarioEntity> lista = this.objCuestionarioRepository.findAll();
        List<Cuestionario> listaObtenida = this.CuestionarioModelMapper.map(lista, new TypeToken<List<Cuestionario>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public List<Cuestionario> listarRespuestasCuestionarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarRespuestasCuestionarios'");
    }

    @Override
    public Cuestionario asignarPreguntaCuestionario(Integer idPregunta) {
        return null;
    }

    @Override
    public Cuestionario consultarCuestionarioPorTitulo(String titulo) {
        return this.CuestionarioModelMapper.map(this.objCuestionarioRepository.findByTitulo(titulo), Cuestionario.class);
    }

    @Override
    public List<CuestionarioDTORespuesta> consultarCuestionarioPorPatron(String titulo) {
        System.out.println("patron " + titulo);

        Iterable<CuestionarioEntity> cuestionario = this.objCuestionarioRepository.findByTituloIgnoreCaseContainingOrderByIdcuestionario(titulo);;
        List<CuestionarioDTORespuesta> listCuestionarios = this.CuestionarioModelMapper.map(cuestionario, new TypeToken<List<CuestionarioDTORespuesta>>() {
        }.getType());
        return listCuestionarios;
    }
}
