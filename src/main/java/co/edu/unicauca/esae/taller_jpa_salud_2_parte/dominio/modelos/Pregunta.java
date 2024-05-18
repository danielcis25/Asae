package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta {
    
    private int idpregunta;
    private String enunciado;
	//private List<Respuesta> listaRespuestas;
    private TipoPregunta objTipoPregunta;
    private Cuestionario objCuestionario;

}
