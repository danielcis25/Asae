package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.mappers;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Pregunta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.PreguntaDTORespuesta;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.CuestionarioDTORespuesta;
@Component
@Mapper(componentModel = "spring")
public class CuestionarioMapperImpl implements CuestionarioMapperInfraestructuraDominio {

    private final DocenteMapperInfraestructuraDominio docenteMapper;

    public CuestionarioMapperImpl(DocenteMapperInfraestructuraDominio docenteMapper) {
        this.docenteMapper = docenteMapper;
    }


    @Override
    public Cuestionario mappearDePeticionACuestionario(CuestionarioDTOPeticion peticion) {
        // Implementa la lógica para mapear desde CuestionarioDTOPeticion a Cuestionario

        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setIdcuestionario(peticion.getIdcuestionario());
        cuestionario.setTitulo(peticion.getTitulo());
        cuestionario.setDescripcion(peticion.getDescripcion());
        //como consulto la lista?
        //cuestionario.setPreguntas(this.mappearPeticionAPregunta());

        return cuestionario;
    }

    @Override
    public CuestionarioDTORespuesta mappearDeCuestionarioARespuesta(Cuestionario cuestionario) {
        // Implementa la lógica para mapear desde Cuestionario a CuestionarioDTORespuest
        CuestionarioDTORespuesta respuesta = new CuestionarioDTORespuesta();
        respuesta.setIdcuestionario(cuestionario.getIdcuestionario());
        respuesta.setTitulo(cuestionario.getTitulo());
        respuesta.setDescripcion(cuestionario.getDescripcion());

        //respuesta.setPreguntas(this.mappearPreguntasARespuesta());

        return respuesta;
    }

    @Override
    public List<CuestionarioDTORespuesta> mappearDeCuestionariosARespuesta(List<Cuestionario> cuestionarios) {
        //Implementa la lógica para mapear una lista de Cuestionario a una lista de CuestionarioDTORespuesta
        //
        return cuestionarios.stream()
                .map(this::mappearDeCuestionarioARespuesta)
                .collect(Collectors.toList());
    
    }

    @Override
    public List<PreguntaDTORespuesta> mappearPreguntasARespuesta() {
        // Implementa la lógica para mapear desde Pregunta a Cuestionario
        // Por ejemplo:
        Pregunta pregunta = new Pregunta();
        pregunta.setIdpregunta(1);
        pregunta.setEnunciado("Enunciado 1");
        // Mapea otros campos aquí
        return null;
    }

    @Override
    public List<Pregunta> mappearPeticionAPregunta() {

        return List.of();
    }

}
