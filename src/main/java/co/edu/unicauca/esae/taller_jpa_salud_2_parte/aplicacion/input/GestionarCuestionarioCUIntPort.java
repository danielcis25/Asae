package co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.input;

import java.util.List;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;

public interface GestionarCuestionarioCUIntPort {
    public Cuestionario crearCuestionario(Cuestionario cuestionario);

    Cuestionario asignarPreguntaCuestionario(Integer idPregunta);

    public List<Cuestionario> listarRespuestasCuestionarios();

    public List<Cuestionario> listarCuestionarios();


}
