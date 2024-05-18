package co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output;


import java.util.List;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Departamento;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;

public interface GestionarDocenteGatewayIntPort {

    public boolean existeDocentePorId(int idDocente);

    public Docente guardar(Docente objDocente);

    public Docente consultarDocentePorId(int id);

    public List<Docente> listar();

    Departamento consultarDepartamentoPorId(int idDepartamento);

    Departamento guardarDepartamento(Departamento objDepartamento);
}
