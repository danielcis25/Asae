package co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.input;

import java.util.List;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Departamento;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.DocenteDTORespuesta;

public interface GestionarDocenteCUIntPort {

    public Docente  registrarDocente(Docente objDocente);

    public List<Docente> listar();

    public DocenteDTORespuesta obtenerDocenteDTOPorId(int idDocente);

    Departamento asignarDepartamentoDocente(int idDepartamento, Docente objDocente);
}
