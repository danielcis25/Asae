package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta;


import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.PreguntaDTOPeticion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaDTORespuesta {

    private int idrespuesta;
    private String descripcion;
    //private PreguntaDTOPeticion objPregunta;
    //private DocenteDTORespuesta objDocente;

    // public RespuestaDTORespuesta(){

    // }

    // public RespuestaDTORespuesta(int idrespuesta, String descripcion, PreguntaDTOPeticion objPregunta) {
    //     this.idrespuesta = idrespuesta;
    //     this.descripcion = descripcion;
    //     this.objPregunta = objPregunta;
    // }
}
