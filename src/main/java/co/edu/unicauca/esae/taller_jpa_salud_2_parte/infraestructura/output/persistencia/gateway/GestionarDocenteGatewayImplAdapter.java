package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.gateway;

import java.util.List;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Departamento;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.DepartamentoEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios.DepartamentoRepository;
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
    private final DepartamentoRepository objDepartamentoRepository;

    public GestionarDocenteGatewayImplAdapter( DocenteRepository objDocenteRepository,
                                               ModelMapper DocenteModelMapper,
                                                  DepartamentoRepository objDepartamentoRepository
                                              ){
        this.objDocenteRepository = objDocenteRepository;
        this.objDepartamentoRepository = objDepartamentoRepository;
        this.DocenteModelMapper = DocenteModelMapper;
    }

    @Override
    public boolean existeDocentePorCorreo(String correo) {
        return this.objDocenteRepository.existsByCorreo(correo);
    }

    @Override
    public Docente guardar(Docente objDocente) {
        if (objDocente == null) {
            throw new IllegalArgumentException("El objeto Docente no puede ser nulo");
        }
        TelefonoEntity telefonoEntity = DocenteModelMapper.map(objDocente.getObjTelefono(),TelefonoEntity.class);
        DocenteEntity objDocenteEntity = DocenteModelMapper.map(objDocente, DocenteEntity.class);

        objDocenteEntity.setObjTelefono(telefonoEntity);
        telefonoEntity.setObjDocente(objDocenteEntity);
        

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
    public Departamento consultarDepartamentoPorId(int idDepartamento) {
        return this.DocenteModelMapper.map(this.objDepartamentoRepository.findById(idDepartamento), Departamento.class);
    }

    @Override
    public Departamento guardarDepartamento(Departamento objDepartamento) {
        return this.DocenteModelMapper.map(this.objDepartamentoRepository.save(this.DocenteModelMapper.map(objDepartamento, DepartamentoEntity.class)), Departamento.class);
    }

    @Override
    public Docente consultarDocentePorId(int id) {
        return this.DocenteModelMapper.map(this.objDocenteRepository.findById(id), Docente.class);
    }

}
