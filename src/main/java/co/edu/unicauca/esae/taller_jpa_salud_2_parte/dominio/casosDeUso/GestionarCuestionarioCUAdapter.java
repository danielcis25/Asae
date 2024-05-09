package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.input.GestionarCuestionarioCUIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.CuestionarioFormateadorResultadoIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;

public class GestionarCuestionarioCUAdapter implements GestionarCuestionarioCUIntPort {

    private final GestionarCuestionarioGatewayIntPort objGestionarCuestionarioGateway;
    private final CuestionarioFormateadorResultadoIntPort objCuestionarioFormateadorResultados;

    public GestionarCuestionarioCUAdapter(GestionarCuestionarioGatewayIntPort objRegistrarCuestionarioGateway,
    CuestionarioFormateadorResultadoIntPort objCuestionarioFormateadorResultados){
        this.objGestionarCuestionarioGateway = objRegistrarCuestionarioGateway;
        this.objCuestionarioFormateadorResultados = objCuestionarioFormateadorResultados;
    }

    @Override
    public Cuestionario crearCuestionario(Cuestionario objCuestionario) {
        // TODO Auto-generated method stub
        Cuestionario objCuestionarioCreado = null;
        if(this.objGestionarCuestionarioGateway.existeCuestionarioPorTitulo(objCuestionario.getTitulo())){
            this.objCuestionarioFormateadorResultados.retornarRespuestaErrorEntidadExiste("Error, se encuentra en el sistema un Cuestionario con el titulo ingresado ");
        }else{
            //preguntar si se pasa titulo? o todos los atributos o el objCuestionario
            objCuestionario.setTitulo(objCuestionario.getTitulo());
            objCuestionarioCreado = this.objGestionarCuestionarioGateway.guardarCuestionario(objCuestionario);
        }

        return objCuestionarioCreado;
    }

    @Override
    public List<Cuestionario> listarCuestionarios() {
      
        List<Cuestionario> listaCuestionarios = this.objGestionarCuestionarioGateway.listarCuestionarios();
        return listaCuestionarios;
    }

    @Override
    public List<Cuestionario> listarRespuestasCuestionarios() {
        List<Cuestionario>listaRespuestaCuestionarios = this.objGestionarCuestionarioGateway.listarRespuestasCuestionarios();
        return listaRespuestaCuestionarios;
    }
}
