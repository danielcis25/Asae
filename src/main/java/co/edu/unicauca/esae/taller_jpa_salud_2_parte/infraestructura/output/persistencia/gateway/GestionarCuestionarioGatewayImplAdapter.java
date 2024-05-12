package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.gateway;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios.CuestionarioRepository;
@Service
public class GestionarCuestionarioGatewayImplAdapter implements GestionarCuestionarioGatewayIntPort {

    private final CuestionarioRepository objCuestionarioRepository;
    private final ModelMapper CuestionarioModelMapper;

    public GestionarCuestionarioGatewayImplAdapter(CuestionarioRepository objCuestionarioRepository,
                                                   ModelMapper CuestionarioModelMapper){
        this.objCuestionarioRepository = objCuestionarioRepository;
        this.CuestionarioModelMapper = CuestionarioModelMapper;
    }
    @Override
    public boolean existeCuestionarioPorTitulo(String titulo) {
        return this.objCuestionarioRepository.existeCuestionarioPorTitulo(titulo) == 1;
    }

    @Override
    public Cuestionario guardarCuestionario(Cuestionario objCuestionario) {
        CuestionarioEntity objCuestionarioEntity = this.CuestionarioModelMapper.map(objCuestionario, CuestionarioEntity.class);
        CuestionarioEntity objCuestionarioEntityCreado = this.objCuestionarioRepository.save(objCuestionarioEntity);
        Cuestionario objCuestionarioRespuesta = this.CuestionarioModelMapper.map(objCuestionarioEntityCreado, Cuestionario.class);
        return objCuestionarioRespuesta;
    }

    @Override
    public List<Cuestionario> listarCuestionarios() {
        Iterable<CuestionarioEntity> lista = this.objCuestionarioRepository.findAll();
        List<Cuestionario> listaObtenida = this.CuestionarioModelMapper.map(lista, new TypeToken<List<Cuestionario>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public List<Cuestionario> listarRespuestasCuestionarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarRespuestasCuestionarios'");
    }

}
