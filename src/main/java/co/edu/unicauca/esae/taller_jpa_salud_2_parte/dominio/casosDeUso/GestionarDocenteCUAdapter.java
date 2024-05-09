package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.casosDeUso;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.CuestionarioFormateadorResultadoIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort {
    private final GestionarDocenteGatewayIntPort objGestionarDocenteateway;
    private final CuestionarioFormateadorResultadoIntPort objDocenteFormateadorResultados;

    public GestionarDocenteCUAdapter(GestionarDocenteGatewayIntPort objRegistrarDocenteGateway,
    CuestionarioFormateadorResultadoIntPort objDocenteFormateadorResultados){
        this.objGestionarDocenteateway = objRegistrarDocenteGateway;
        this.objDocenteFormateadorResultados = objDocenteFormateadorResultados;
    }

    @Override
    public Docente registrarDocente(Docente objDocente) {
       Docente objDocenteCreado = null;
       if (this.objGestionarDocenteateway.existeDocentePorId(objDocente.getIdpersona())) {
            this.objDocenteFormateadorResultados.retornarRespuestaErrorEntidadExiste("Error. Ya existe un docente con ese ID ");
       }else{
        //objDocente.setIdpersona(0);
        objDocenteCreado = this.objGestionarDocenteateway.guardar(objDocente);
       }
       return objDocenteCreado;
    }

}
