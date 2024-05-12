package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Respuesta {
    private int idrespuesta;
    private String descripcion;
    private Pregunta objPregunta;
    private Docente objDocente;

}

