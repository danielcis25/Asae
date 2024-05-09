package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RespuestaDTORespuesta {

    private int idrespuesta;
    private String descripcion;
    private PreguntaDTORespuesta objPregunta;
    private DocenteDTORespuesta objDocente;

    public RespuestaDTORespuesta(){

    }

}
