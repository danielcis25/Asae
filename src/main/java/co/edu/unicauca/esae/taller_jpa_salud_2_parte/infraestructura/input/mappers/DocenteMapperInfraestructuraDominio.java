package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.DocenteDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.DocenteDTORespuesta;
@Mapper(componentModel = "spring")
public interface DocenteMapperInfraestructuraDominio {
    Docente mappearDePeticionADocente(DocenteDTOPeticion peticion);

    DocenteDTORespuesta mappearDeDocenteARespuesta(Docente docente);

    List<DocenteDTORespuesta> mappearDeDocentesARespuesta(List<Docente> docentes);

    List<Docente> mappearRespuestaADocente(List<DocenteDTOPeticion> docentes);

}
