package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.mappers;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Pregunta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.TipoPregunta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.PreguntaDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.TipoPreguntaDTORespuesta;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.PreguntaDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.CuestionarioDTORespuesta;
@Component
@Mapper(componentModel = "spring")
public class CuestionarioMapperImpl implements CuestionarioMapperInfraestructuraDominio {

    // @Override
    // public Cuestionario mappearDePeticionACuestionario(CuestionarioDTOPeticion peticion) {
    //     // Implementa la lógica para mapear desde CuestionarioDTOPeticion a Cuestionario

    //     Cuestionario cuestionario = new Cuestionario();
    //     cuestionario.setIdcuestionario(peticion.getIdcuestionario());
    //     cuestionario.setTitulo(peticion.getTitulo());
    //     cuestionario.setDescripcion(peticion.getDescripcion());
    //     //como consulto la lista?
    //     //cuestionario.setPreguntas(this.mappearPeticionAPregunta());

    //     return cuestionario;
    // }
    @Override
    public Cuestionario mappearDePeticionACuestionario(CuestionarioDTOPeticion peticion) {
        // Implementa la lógica para mapear desde CuestionarioDTOPeticion a Cuestionario
        List<Pregunta> preguntas = peticion.getPreguntas().stream()
            .map(this::mappearPeticionAPregunta)
            .collect(Collectors.toList());

        Cuestionario cuestionario = new Cuestionario(
            peticion.getIdcuestionario(),
            peticion.getTitulo(),
            peticion.getDescripcion(),
            preguntas
        );

        // Establecer la relación bidireccional
        preguntas.forEach(pregunta -> pregunta.setObjCuestionario(cuestionario));

        return cuestionario;
    }

    // @Override
    // public CuestionarioDTORespuesta mappearDeCuestionarioARespuesta(Cuestionario cuestionario) {
    //     // Implementa la lógica para mapear desde Cuestionario a CuestionarioDTORespuest
    //     CuestionarioDTORespuesta respuesta = new CuestionarioDTORespuesta();
    //     respuesta.setIdcuestionario(cuestionario.getIdcuestionario());
    //     respuesta.setTitulo(cuestionario.getTitulo());
    //     respuesta.setDescripcion(cuestionario.getDescripcion());

    //     //respuesta.setPreguntas(this.mappearPreguntasARespuesta());

    //     return respuesta;
    // }
    @Override
    public CuestionarioDTORespuesta mappearDeCuestionarioARespuesta(Cuestionario cuestionario) {
        List<PreguntaDTORespuesta> preguntasRespuesta = cuestionario.getPreguntas().stream()
            .map(this::mappearPreguntaARespuesta)
            .collect(Collectors.toList());

        CuestionarioDTORespuesta cuestionarioRespuesta = new CuestionarioDTORespuesta(
            cuestionario.getIdcuestionario(),
            cuestionario.getTitulo(),
            cuestionario.getDescripcion(),
            preguntasRespuesta
        );
        return cuestionarioRespuesta;
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
    public List<Cuestionario> mappearRespuestaACuestionario(List<CuestionarioDTOPeticion> cuestionarios) {
        return cuestionarios.stream()
            .map(this::mappearDePeticionACuestionario)
            .collect(Collectors.toList());
    }
   


    // @Override
    // public List<PreguntaDTORespuesta> mappearPreguntasARespuesta() {
    //     // Implementa la lógica para mapear desde Pregunta a Cuestionario
    //     // Por ejemplo:
    //     Pregunta pregunta = new Pregunta();
    //     pregunta.setIdpregunta(1);
    //     pregunta.setEnunciado("Enunciado 1");
    //     // Mapea otros campos aquí
    //     return null;
    // }

    
    
    //Cambio, metodos nuevos
    @Override
    public PreguntaDTORespuesta mappearPreguntaARespuesta(Pregunta pregunta) {
        TipoPreguntaDTORespuesta tipoPreguntaRespuesta = new TipoPreguntaDTORespuesta(
            pregunta.getObjTipoPregunta().getIdtippregunta(),
            pregunta.getObjTipoPregunta().getNombre(),
            pregunta.getObjTipoPregunta().getDescripcion()
        );

        return new PreguntaDTORespuesta(
            pregunta.getIdpregunta(),
            pregunta.getEnunciado(),
            tipoPreguntaRespuesta
        );
    }

    @Override
    public Pregunta mappearPeticionAPregunta(PreguntaDTOPeticion peticion) {
        TipoPregunta tipoPregunta = new TipoPregunta(
            peticion.getObjTipoPregunta().getIdtippregunta(),
            peticion.getObjTipoPregunta().getNombre(),
            peticion.getObjTipoPregunta().getDescripcion()
        );

        return new Pregunta(
            peticion.getIdpregunta(),
            peticion.getEnunciado(),
            tipoPregunta,
            null // La relación bidireccional se establece después
        );
    }

    
}



    
    