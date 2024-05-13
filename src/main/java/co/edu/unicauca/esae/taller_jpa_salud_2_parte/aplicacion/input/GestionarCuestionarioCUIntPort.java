package co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.input;

import java.util.List;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.CuestionarioDTORespuesta;

public interface GestionarCuestionarioCUIntPort {
    public Cuestionario crearCuestionario(Cuestionario cuestionario);

    Cuestionario consultarCuestionarioPorTitulo(String titulo);

    Cuestionario asignarPreguntaCuestionario(Integer idPregunta);

    public List<Cuestionario> listarRespuestasCuestionarios();

    public List<Cuestionario> listarCuestionarios();

    public List<CuestionarioDTORespuesta> consultarCuestionarioPorPatron(String titulo);

}
