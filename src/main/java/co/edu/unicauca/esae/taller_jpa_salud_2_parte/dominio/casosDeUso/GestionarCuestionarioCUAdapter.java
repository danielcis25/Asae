package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.input.GestionarCuestionarioCUIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.CuestionarioFormateadorResultadoIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Respuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.CuestionarioDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.PreguntaDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.ExcepcionesPropias.EntidadNoExisteException;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.PreguntaEntity;

public class GestionarCuestionarioCUAdapter implements GestionarCuestionarioCUIntPort {

    private final GestionarCuestionarioGatewayIntPort objGestionarCuestionarioGateway;
    private final CuestionarioFormateadorResultadoIntPort objCuestionarioFormateadorResultados;

    public GestionarCuestionarioCUAdapter(GestionarCuestionarioGatewayIntPort objRegistrarCuestionarioGateway,
                                          CuestionarioFormateadorResultadoIntPort objCuestionarioFormateadorResultados){
        this.objGestionarCuestionarioGateway = objRegistrarCuestionarioGateway;
        this.objCuestionarioFormateadorResultados = objCuestionarioFormateadorResultados;
    }

    @Override
    public Cuestionario crearCuestionario(Cuestionario cuestionario) {


        Cuestionario objCuestionarioCreado = null;
        if(this.objGestionarCuestionarioGateway.existeCuestionarioPorTitulo(cuestionario.getTitulo())){
            this.objCuestionarioFormateadorResultados.retornarRespuestaErrorEntidadExiste("Error, se encuentra en el sistema un Cuestionario con el titulo ingresado ");
        }else{
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
    public List<CuestionarioDTORespuesta> consultarCuestionarioPorPatron(String titulo){
        return this.objGestionarCuestionarioGateway.consultarCuestionarioPorPatron(titulo);
    }

    @Override
    public List<Respuesta> listarCuestionariosPorDocente(Integer idDocente) {

        return this.objGestionarCuestionarioGateway.listarCuestionariosPorDocente(idDocente);


    }

    @Override
    public CuestionarioDTORespuesta obtenerCuestionarioDTOPorRespuesta(Integer idRespuesta) {
        return this.objGestionarCuestionarioGateway.obtenerCuestionarioDTOPorRespuesta(idRespuesta);

    }

    @Override
    public List<PreguntaDTORespuesta> obtenerPreguntasPorCuestionario(Integer idCuestionario) {

        return this.objGestionarCuestionarioGateway.obtenerPreguntasDTOPorCuestionario(idCuestionario);

    }


    @Override
    public Cuestionario consultarCuestionarioPorTitulo(String titulo){
        if(this.objGestionarCuestionarioGateway.existeCuestionarioPorTitulo(titulo)){
            return this.objGestionarCuestionarioGateway.consultarCuestionarioPorTitulo(titulo);
        }

        EntidadNoExisteException objException = new EntidadNoExisteException("No existe publicacion con el titulo" + titulo );
        throw  objException;

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
