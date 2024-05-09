package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PreguntaDTOPeticion {
    //TODO:notaciones
    private int idpregunta;
    @NotNull(message = "{producto.codigo.emply}")
    private String enunciado;
	private List<RespuestaDTOPeticion> listaRespuestas;
    private TipoPreguntaDTOPeticion objTipoPregunta;
    private CuestionarioDTOPeticion objCuestionario;
}
