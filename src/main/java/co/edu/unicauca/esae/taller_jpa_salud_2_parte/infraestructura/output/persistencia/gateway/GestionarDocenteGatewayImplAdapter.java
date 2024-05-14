package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.TelefonoEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios.DocenteRepository;
@Service

public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort {

    private final ModelMapper DocenteModelMapper;
    private final DocenteRepository objDocenteRepository;

    public GestionarDocenteGatewayImplAdapter( DocenteRepository objDocenteRepository,
                                               ModelMapper DocenteModelMapper
                                              ){
        this.objDocenteRepository = objDocenteRepository;
        this.DocenteModelMapper = DocenteModelMapper;
    }

    @Override
    public boolean existeDocentePorId(int idDocente) {
        return this.objDocenteRepository.existsById(idDocente);
    }

    @Override
    public Docente guardar(Docente objDocente) {
        if (objDocente == null) {
            throw new IllegalArgumentException("El objeto Docente no puede ser nulo");
        }
        TelefonoEntity telefonoEntity = DocenteModelMapper.map(objDocente.getObjTelefono(),TelefonoEntity.class);
        DocenteEntity objDocenteEntity = DocenteModelMapper.map(objDocente, DocenteEntity.class);

        telefonoEntity.setObjDocente(objDocenteEntity);
        objDocenteEntity.setObjTelefono(telefonoEntity);

        DocenteEntity objDocenteEntityCreado = this.objDocenteRepository.save(objDocenteEntity);
        
        Docente objDocenteRespuesta = this.DocenteModelMapper.map(objDocenteEntityCreado, Docente.class);
        return objDocenteRespuesta;
    }

    @Override
    public List<Docente> listar() {
        Iterable<DocenteEntity> lista = this.objDocenteRepository.findAll();
        List<Docente> listaObtenida = this.DocenteModelMapper.map(lista, new TypeToken<List<Docente>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public Docente consultarDocentePorId(int id) {
        return this.DocenteModelMapper.map(this.objDocenteRepository.findById(id), Docente.class);
    }

}
