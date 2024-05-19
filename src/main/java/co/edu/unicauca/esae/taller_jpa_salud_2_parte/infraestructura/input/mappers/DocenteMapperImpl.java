package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Departamento;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Telefono;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.DepartamentoDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.TelefonoDTORespuesta;
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
                peticion.getIdpersona(),
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
        List<DepartamentoDTORespuesta> departamentos = mappearDepartamentos(docente.getListaDepartamentos());
        docenteMapeado.setListaDepartamentos(departamentos);
        return docenteMapeado;
        //return null;
    }

    private List<DepartamentoDTORespuesta> mappearDepartamentos(List<Departamento> departamentos) {
        if (departamentos == null) {
            return new ArrayList<>();
        }
        return departamentos.stream().map(departamento -> {
            DepartamentoDTORespuesta dto = new DepartamentoDTORespuesta();
            dto.setIddepartamento(departamento.getIddepartamento());
            dto.setNombre(departamento.getNombre());
            dto.setDescripcion(departamento.getDescripcion());
            return dto;
        }).collect(Collectors.toList());
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
            telefonoMapeado.setIdtelefono(docentePeticion.getIdpersona());
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

    @Override
    public List<Docente> mappearDepartamentoADocente(List<DocenteDTOPeticion> docentes) {
        List<Docente> response = new ArrayList<>();
        for(DocenteDTOPeticion docentePeticion : docentes){
            Docente docenteMapeado = this.mappearDePeticionADocente(docentePeticion);
            response.add(docenteMapeado);
        }
        return response;
    }

}
