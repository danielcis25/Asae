package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.CuestionarioDTORespuesta;
@Component
@Mapper(componentModel = "spring")
public class CuestionarioMapperImpl implements CuestionarioMapperInfraestructuraDominio {

    @Override
    public Cuestionario mappearDePeticionACuestionario(CuestionarioDTOPeticion peticion) {
        // Implementa la lógica para mapear desde CuestionarioDTOPeticion a Cuestionario
        // Por ejemplo:
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setTitulo(peticion.getTitulo());;
        // Mapea otros campos aquí
        return cuestionario;
    }

    @Override
    public CuestionarioDTORespuesta mappearDeCuestionarioARespuesta(Cuestionario cuestionario) {
        // Implementa la lógica para mapear desde Cuestionario a CuestionarioDTORespuesta
        // Por ejemplo:
        CuestionarioDTORespuesta respuesta = new CuestionarioDTORespuesta();
        respuesta.setTitulo(cuestionario.getTitulo());
        // Mapea otros campos aquí
        return respuesta;
    }

    @Override
    public List<CuestionarioDTORespuesta> mappearDeCuestionariosARespuesta(List<Cuestionario> cuestionarios) {
        // eLIMINAR GPT  Implementa la lógica para mapear una lista de Cuestionario a una lista de CuestionarioDTORespuesta
        // Por ejemplo:
        return cuestionarios.stream()
                .map(this::mappearDeCuestionarioARespuesta)
                .collect(Collectors.toList());
    
    }

}
