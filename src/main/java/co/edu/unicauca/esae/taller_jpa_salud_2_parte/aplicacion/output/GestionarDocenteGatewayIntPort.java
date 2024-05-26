package co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output;


import java.util.List;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Departamento;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.DocenteDTORespuesta;

public interface GestionarDocenteGatewayIntPort {

    // public boolean existeDocentePorId(int idDocente);

    public boolean existeDocentePorCorreo(String correo);

    public Docente guardar(Docente objDocente);

    public DocenteDTORespuesta consultarDocentePorId(int id);

    public List<Docente> listar();

    Departamento consultarDepartamentoPorId(int idDepartamento);

    Departamento guardarDepartamento(Departamento objDepartamento);
}
