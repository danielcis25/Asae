package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.CuestionarioDTORespuesta;

@Mapper(componentModel = "spring")
public interface CuestionarioMapperInfraestructuraDominio {

    Cuestionario mappearDePeticionACuestionario(CuestionarioDTOPeticion peticion);

    CuestionarioDTORespuesta mappearDeCuestionarioARespuesta(Cuestionario cuestionario);

    List<CuestionarioDTORespuesta> mappearDeCuestionariosARespuesta(List<Cuestionario> cuestionarios);

}
