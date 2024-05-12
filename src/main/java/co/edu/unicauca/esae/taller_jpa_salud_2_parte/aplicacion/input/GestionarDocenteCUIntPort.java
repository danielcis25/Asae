package co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.input;

import java.util.List;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;

public interface GestionarDocenteCUIntPort {

    public Docente  registrarDocente(Docente objDocente);

    public List<Docente> listar();
}
