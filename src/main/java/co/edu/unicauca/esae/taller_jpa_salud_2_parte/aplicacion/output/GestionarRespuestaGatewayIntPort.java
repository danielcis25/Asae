package co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output;

import java.util.List;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Pregunta;


public interface GestionarRespuestaGatewayIntPort {
    public void registrarRespuesta(Docente docente,Cuestionario cuestionario,List<Pregunta> preguntas);


}
