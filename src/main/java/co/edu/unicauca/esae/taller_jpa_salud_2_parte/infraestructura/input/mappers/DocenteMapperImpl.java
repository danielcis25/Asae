package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.mappers;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Telefono;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.TelefonoDTORespuesta;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.DocenteDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.DocenteDTORespuesta;
// @Component
// @Mapper(componentModel = "spring")
@Service
public class DocenteMapperImpl implements DocenteMapperInfraestructuraDominio{

    @Override
    public Docente mappearDePeticionADocente(DocenteDTOPeticion peticion) {
        Telefono objtelefono = new Telefono(
                peticion.getObjTelefono().getIdtelefono(),
                peticion.getObjTelefono().getNumero(),
                peticion.getObjTelefono().getTipotelefono()
        );
        Docente docente = new Docente(
            peticion.getIdpersona(),
            peticion.getTipoidentificacion(),
            peticion.getNumeroidentificacion(),
            peticion.getNombres(),
            peticion.getApellidos(),
            peticion.getCorreo(),
            peticion.getVinculacion(),
            objtelefono);
        objtelefono.setObjDocente(docente);
        return docente;
    }

    @Override
    public DocenteDTORespuesta mappearDeDocenteARespuesta(Docente docente) {

        TelefonoDTORespuesta objtelefono = new TelefonoDTORespuesta(
            docente.getObjTelefono().getIdtelefono(),
            docente.getObjTelefono().getNumero(),
            docente.getObjTelefono().getTipotelefono()
        );
        DocenteDTORespuesta docenteMapeado = new DocenteDTORespuesta();
        docenteMapeado.setNumeroIdentificacion(docente.getNumeroidentificacion());
        docenteMapeado.setTipoIdentificacion(docente.getTipoidentificacion());
        docenteMapeado.setNombres(docente.getNombres());
        docenteMapeado.setApellidos(docente.getApellidos());
        docenteMapeado.setCorreo(docente.getCorreo());
        docenteMapeado.setVinculacion(docente.getVinculacion());
        docenteMapeado.setObjTelefono(objtelefono);
        return docenteMapeado;
        //return null;
    }

    @Override
    public List<DocenteDTORespuesta> mappearDeDocentesARespuesta(List<Docente> docentes) {

        List<DocenteDTORespuesta> response = new ArrayList<>();
        for(int i = 0 ; i<docentes.size() ; i++){
            Docente docentePeticion = docentes.get(i);

            DocenteDTORespuesta docenteMapeado = new DocenteDTORespuesta();
            docenteMapeado.setIdPersona(docentePeticion.getIdpersona());
            docenteMapeado.setTipoIdentificacion(docentePeticion.getTipoidentificacion());
            docenteMapeado.setNumeroIdentificacion(docentePeticion.getNumeroidentificacion());
            docenteMapeado.setNombres(docentePeticion.getNombres());
            docenteMapeado.setApellidos(docentePeticion.getApellidos());
            docenteMapeado.setCorreo(docentePeticion.getCorreo());
            docenteMapeado.setVinculacion(docentePeticion.getVinculacion());

            TelefonoDTORespuesta telefonoMapeado = new TelefonoDTORespuesta();
            telefonoMapeado.setIdtelefono(docentePeticion.getObjTelefono().getIdtelefono());
            telefonoMapeado.setNumero(docentePeticion.getObjTelefono().getNumero()); 
            telefonoMapeado.setTipotelefono(docentePeticion.getObjTelefono().getTipotelefono());
            docenteMapeado.setObjTelefono(telefonoMapeado);
            response.add(docenteMapeado);
        }
        return response;
}


    @Override
    public List<Docente> mappearRespuestaADocente(List<DocenteDTOPeticion> docentes) {
        List<Docente> response = new ArrayList<>();
        for(DocenteDTOPeticion docentePeticion : docentes){
            Docente docenteMapeado = this.mappearDePeticionADocente(docentePeticion);



            response.add(docenteMapeado);
        }
        return response;
    }

}
