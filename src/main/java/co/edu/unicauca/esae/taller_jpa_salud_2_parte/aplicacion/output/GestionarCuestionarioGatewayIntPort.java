package co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output;

import java.util.List;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Pregunta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Respuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.CuestionarioDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.PreguntaDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.PreguntaEntity;

public interface GestionarCuestionarioGatewayIntPort {

    public boolean existeCuestionarioPorTitulo(String titulo);

    public Cuestionario guardarCuestionario(Cuestionario objCuestionario);

    public List<Cuestionario> listarCuestionarios();

    public List<Cuestionario> listarRespuestasCuestionarios();

    public Cuestionario asignarPreguntaCuestionario(Integer idPregunta);

    public Cuestionario consultarCuestionarioPorTitulo(String titulo);

    List<CuestionarioDTORespuesta> consultarCuestionarioPorPatron(String titulo);

    public List<Respuesta> listarCuestionariosPorDocente(Integer docente);

    public CuestionarioDTORespuesta obtenerCuestionarioDTOPorRespuesta(Integer idRespuesta);

    public List<PreguntaDTORespuesta> obtenerPreguntasDTOPorCuestionario(Integer idCuestionario);
}
