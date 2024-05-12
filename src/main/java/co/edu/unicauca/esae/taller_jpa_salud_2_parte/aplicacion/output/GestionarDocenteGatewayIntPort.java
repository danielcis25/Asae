package co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output;


import java.util.List;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;

public interface GestionarDocenteGatewayIntPort {

    public boolean existeDocentePorId(int idDocente);

    public Docente guardar(Docente objDocente);

    public List<Docente> listar();

}
