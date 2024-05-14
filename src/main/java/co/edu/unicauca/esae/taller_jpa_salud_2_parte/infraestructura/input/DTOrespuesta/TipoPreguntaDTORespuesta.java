package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TipoPreguntaDTORespuesta {

    private int idtippregunta;
    private String nombre;
    private String descripcion;
    //private List<PreguntaDTORespuesta> preguntas;

    public TipoPreguntaDTORespuesta(){

    }

}
