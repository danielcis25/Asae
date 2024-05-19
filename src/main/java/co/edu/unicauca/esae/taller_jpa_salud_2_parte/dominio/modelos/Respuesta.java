package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.PreguntaDTOPeticion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Respuesta {
    private int idrespuesta;
    private String descripcion;

    public Respuesta(int idrespuesta, String descripcion, PreguntaDTOPeticion objPregunta) {
        this.idrespuesta = idrespuesta;
        this.descripcion = descripcion;
        //this.objPregunta = objPregunta;
    }
    //private Pregunta objPregunta;
    //private Docente objDocente;

}

