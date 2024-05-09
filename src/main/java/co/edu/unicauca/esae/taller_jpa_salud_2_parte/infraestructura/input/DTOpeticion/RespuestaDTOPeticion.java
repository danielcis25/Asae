package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespuestaDTOPeticion {
    //TODO: notaciones
    private int idrespuesta;
    private String descripcion;
    private PreguntaDTOPeticion objPregunta;
    private DocenteDTOPeticion objDocente;
}
