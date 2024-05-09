package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PreguntaDTORespuesta {

    private int idpregunta;
    private String enunciado;
	private List<RespuestaDTORespuesta> listaRespuestas;
    private TipoPreguntaDTORespuesta objTipoPregunta;
    private CuestionarioDTORespuesta objCuestionario;

    public PreguntaDTORespuesta(){

    }

}
