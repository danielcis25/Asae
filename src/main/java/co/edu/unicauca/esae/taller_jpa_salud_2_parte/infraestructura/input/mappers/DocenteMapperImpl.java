package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.DocenteDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.DocenteDTORespuesta;
@Component
@Mapper(componentModel = "spring")
public class DocenteMapperImpl implements DocenteMapperInfraestructuraDominio{

    @Override
    public Docente mappearDePeticionADocente(DocenteDTOPeticion peticion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mappearDePeticionADocente'");
    }

    @Override
    public DocenteDTORespuesta mappearDeDocenteARespuesta(Docente docente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mappearDeDocenteARespuesta'");
    }

    @Override
    public List<DocenteDTORespuesta> mappearDeDocentesARespuesta(List<Docente> docentes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mappearDeDocentesARespuesta'");
    }

}
