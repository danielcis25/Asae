package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios.DocenteRepositoryInt;
@Service
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort{
    private final DocenteRepositoryInt objDocenteRepository;
    private final ModelMapper DocenteModelMapper;
    public GestionarDocenteGatewayImplAdapter(DocenteRepositoryInt objDocenteRepository,
    ModelMapper DocenteModelMapper){
        this.objDocenteRepository = objDocenteRepository;
        this.DocenteModelMapper = DocenteModelMapper;
    } 

    @Override
    public boolean existeDocentePorId(int idDocente) {
        return this.objDocenteRepository.existeDocentePorId(idDocente) == 1;
    }

    @Override
    public Docente guardar(Docente objDocente) {
        DocenteEntity objDocenteEntity = this.DocenteModelMapper.map(objDocente, DocenteEntity.class);
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

}
