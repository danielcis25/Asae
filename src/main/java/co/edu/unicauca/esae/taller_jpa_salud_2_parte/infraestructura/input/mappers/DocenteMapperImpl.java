package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.mappers;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Telefono;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.TelefonoDTORespuesta;
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
        Telefono objtelefono = new Telefono(
                peticion.getObjTelefono().getIdtelefono(),
                peticion.getObjTelefono().getNumero(),
                peticion.getObjTelefono().getTipotelefono()
        );
        Docente docente = new Docente(
            peticion.getNumeroidentificacion(),
            peticion.getTipoidentificacion(),
            peticion.getNombres(),
            peticion.getApellidos(),
            peticion.getCorreo(),
            peticion.getVinculacion(),
            objtelefono);
            //objtelefono.setObjDocente(docente);
        return docente;
        //throw new UnsupportedOperationException("Unimplemented method 'mappearDePeticionADocente'");
    }

    @Override
    public DocenteDTORespuesta mappearDeDocenteARespuesta(Docente docente) {

        TelefonoDTORespuesta objtelefono = new TelefonoDTORespuesta(
            docente.getObjTelefono().getIdtelefono(),
            docente.getObjTelefono().getNumero(),
            docente.getObjTelefono().getTipotelefono()
        );
        DocenteDTORespuesta docenteMapeado = new DocenteDTORespuesta();
        docenteMapeado.setNumeroidentificacion(docente.getNumeroidentificacion());
        docenteMapeado.setTipoidentificacion(docente.getTipoidentificacion());
        docenteMapeado.setNombres(docente.getNombres());
        docenteMapeado.setApellidos(docente.getApellidos());
        docenteMapeado.setCorreo(docente.getCorreo());
        docenteMapeado.setVinculacion(docente.getVinculacion());
        docenteMapeado.setObjTelefono(objtelefono);
        return docenteMapeado;

    }

    @Override
    public List<DocenteDTORespuesta> mappearDeDocentesARespuesta(List<Docente> docentes) {

        List<DocenteDTORespuesta> response = new ArrayList<>();
        for(int i = 0 ; i<docentes.size() ; i++){
            Docente docentePeticion = docentes.get(i);

            DocenteDTORespuesta docenteMapeado = new DocenteDTORespuesta();
            docenteMapeado.setNumeroidentificacion(docentePeticion.getNumeroidentificacion());
            docenteMapeado.setTipoidentificacion(docentePeticion.getTipoidentificacion());
            docenteMapeado.setNombres(docentePeticion.getNombres());
            docenteMapeado.setApellidos(docentePeticion.getApellidos());
            docenteMapeado.setCorreo(docentePeticion.getCorreo());
            docenteMapeado.setVinculacion(docentePeticion.getVinculacion());

            TelefonoDTORespuesta objtelefono = new TelefonoDTORespuesta(
                docentePeticion.getObjTelefono().getIdtelefono(),
                docentePeticion.getObjTelefono().getNumero(),
                docentePeticion.getObjTelefono().getTipotelefono()
            );
            docenteMapeado.setObjTelefono(objtelefono);
            response.add(docenteMapeado);
        }

        return response;
    }

}
