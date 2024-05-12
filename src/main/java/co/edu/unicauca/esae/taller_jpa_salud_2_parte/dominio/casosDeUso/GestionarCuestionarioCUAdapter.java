package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.input.GestionarCuestionarioCUIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.CuestionarioFormateadorResultadoIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.ExcepcionesPropias.EntidadYaExisteException;

public class GestionarCuestionarioCUAdapter implements GestionarCuestionarioCUIntPort {

    private final GestionarCuestionarioGatewayIntPort objGestionarCuestionarioGateway;
    private final CuestionarioFormateadorResultadoIntPort objCuestionarioFormateadorResultados;
    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;

    public GestionarCuestionarioCUAdapter(GestionarCuestionarioGatewayIntPort objRegistrarCuestionarioGateway,
                                          CuestionarioFormateadorResultadoIntPort objCuestionarioFormateadorResultados, GestionarDocenteGatewayIntPort objGestionarDocenteGateway){
        this.objGestionarCuestionarioGateway = objRegistrarCuestionarioGateway;
        this.objCuestionarioFormateadorResultados = objCuestionarioFormateadorResultados;
        this.objGestionarDocenteGateway = objGestionarDocenteGateway;
    }

    @Override
    public Cuestionario crearCuestionario(Cuestionario cuestionario) {

        if(this.objGestionarCuestionarioGateway.existeCuestionarioPorTitulo(cuestionario.getTitulo())){
            EntidadYaExisteException objException = new EntidadYaExisteException("El Cuestionario con titulo: " + cuestionario.getTitulo() + " ya existe");
            throw  objException;
        }

        Cuestionario objCuestionarioCreado = null;
        if(this.objGestionarCuestionarioGateway.existeCuestionarioPorTitulo(cuestionario.getTitulo())){
            this.objCuestionarioFormateadorResultados.retornarRespuestaErrorEntidadExiste("Error, se encuentra en el sistema un Cuestionario con el titulo ingresado ");
        }else{
            //preguntar si se pasa titulo? o todos los atributos o el objCuestionario
            cuestionario.setTitulo(cuestionario.getTitulo());
            objCuestionarioCreado = this.objGestionarCuestionarioGateway.guardarCuestionario(cuestionario);
        }
        return objCuestionarioCreado;
    }


    @Override
    public List<Cuestionario> listarCuestionarios() {
      
        List<Cuestionario> listaCuestionarios = this.objGestionarCuestionarioGateway.listarCuestionarios();
        return listaCuestionarios;
    }



    @Override
    public Cuestionario asignarPreguntaCuestionario(Integer idPregunta) {

        Cuestionario preguntaCuestionario = this.objGestionarCuestionarioGateway.asignarPreguntaCuestionario(idPregunta);

        return null;
    }

    @Override
    public List<Cuestionario> listarRespuestasCuestionarios() {
        List<Cuestionario>listaRespuestaCuestionarios = this.objGestionarCuestionarioGateway.listarRespuestasCuestionarios();
        return listaRespuestaCuestionarios;
    }


}
