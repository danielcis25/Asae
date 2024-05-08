package co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output;

import java.util.List;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;

public interface GestionarCuestionarioGatewayIntPort {

    public boolean existeCuestionarioPorTitulo(String titulo);

    public Cuestionario guardarCuestionario(Cuestionario objCuestionario);

    public List<Cuestionario> listarCuestionarios();

    public List<Cuestionario> listarRespuestasCuestionarios();
}
