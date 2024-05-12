package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.CuestionarioFormateadorResultadoIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort {
    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;
    private final CuestionarioFormateadorResultadoIntPort objCuestionarioFormateadorResultados;

    public GestionarDocenteCUAdapter(GestionarDocenteGatewayIntPort objManagementDocenteGateway,
    CuestionarioFormateadorResultadoIntPort objCuestionarioFormateadorResultados){
        this.objGestionarDocenteGateway = objManagementDocenteGateway;
        this.objCuestionarioFormateadorResultados = objCuestionarioFormateadorResultados;
    }

    @Override
    public Docente registrarDocente(Docente objDocente) {



       Docente objDocenteCreado = null;
       if (this.objGestionarDocenteGateway.existeDocentePorId(objDocente.getIdpersona())) {
            this.objCuestionarioFormateadorResultados.
                    retornarRespuestaErrorEntidadExiste("Error. Ya existe un docente con ese ID ");
       }else{
        //objDocente.setIdpersona(0);
        objDocenteCreado = this.objGestionarDocenteGateway.guardar(objDocente);
       }
       return objDocenteCreado;
    }

    @Override
    public List<Docente> listar() {
        //List<Docente> listaObtenida = objGestionarDocenteateway.listar();
        //return listaObtenida;
        return this.objGestionarDocenteGateway.listar();
    }

}
