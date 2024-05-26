package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.CuestionarioFormateadorResultadoIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Departamento;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.DocenteDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.ExcepcionesPropias.EntidadNoExisteException;

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
       if (this.objGestionarDocenteGateway.existeDocentePorCorreo(objDocente.getCorreo())) {
            this.objCuestionarioFormateadorResultados.
                    retornarRespuestaErrorEntidadExiste("Error. Ya existe un docente con ese correo ");
       }else{
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

    @Override
    public DocenteDTORespuesta obtenerDocenteDTOPorId(int idDocente) {
        System.out.println("1 ID DOCENTE: "+idDocente);
        return this.objGestionarDocenteGateway.consultarDocentePorId(idDocente);

    }


    @Override
    public Departamento asignarDepartamentoDocente(int idDepartamento, Docente objDocente) {

        //existe departamento y el docente ?
        if(this.objGestionarDocenteGateway.existeDocentePorCorreo(objDocente.getCorreo())){


                //obtener publicaicon y docente y agregarlo a la lista de autores
                Departamento departamento = this.objGestionarDocenteGateway.consultarDepartamentoPorId(idDepartamento);
                System.out.println("Departamento ES: "+ departamento.toString());
                //se pueder pasar aqui
                Docente docente = objDocente;

                departamento.getDocentes().add(docente);
                System.out.println("departamento:"+departamento.getDocentes().get(0).getIdpersona());


                return this.objGestionarDocenteGateway.guardarDepartamento(departamento);
            }

        else{
            EntidadNoExisteException objException = new EntidadNoExisteException("No existe el docente");
            throw  objException;
        }
    }

}


