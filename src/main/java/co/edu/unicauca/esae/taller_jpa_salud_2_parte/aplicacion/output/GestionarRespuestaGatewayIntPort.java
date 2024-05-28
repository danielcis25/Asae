package co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output;

import java.util.List;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Pregunta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.CuestionarioDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.DocenteDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.PreguntaDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.PreguntaEntity;


public interface GestionarRespuestaGatewayIntPort {
    public void registrarRespuesta(Docente docente,Cuestionario cuestionario,List<Pregunta> preguntas) throws Exception;

    public void consultarRespuesta(DocenteDTORespuesta docente, CuestionarioDTORespuesta cuestionario, List<PreguntaDTORespuesta> preguntas);


}
