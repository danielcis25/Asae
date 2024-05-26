package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaDTORespuesta {

    private int idpregunta;
    private String enunciado;
    @JsonIgnore
	private List<RespuestaDTORespuesta> listaRespuestas;
    private TipoPreguntaDTORespuesta objTipoPregunta;
    //private CuestionarioDTORespuesta objCuestionario;

    public PreguntaDTORespuesta(int idpregunta, String enunciado, TipoPreguntaDTORespuesta objTipoPregunta) {
        this.idpregunta = idpregunta;
        this.enunciado = enunciado;
        this.objTipoPregunta = objTipoPregunta;
    }

}
