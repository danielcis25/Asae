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
	private List<Respuesta> listaRespuestas;
    private TipoPregunta objTipoPregunta;
    private Cuestionario objCuestionario;

    public Pregunta(String enunciado, TipoPregunta objTipoPregunta, Cuestionario objCuestionario) {
        this.enunciado = enunciado;
        this.objTipoPregunta = objTipoPregunta;
        this.objCuestionario = objCuestionario;
    }

    public Pregunta(int idpregunta, String enunciado, TipoPregunta tipoPregunta, Object respuestas) {
        this.enunciado = enunciado;
        this.objTipoPregunta = tipoPregunta;
        this.setIdpregunta(idpregunta);
        this.listaRespuestas = respuestas == null ? new ArrayList<>() : (List<Respuesta>) respuestas;

    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "idpregunta=" + idpregunta +
                ", enunciado='" + enunciado + '\'' +
                ", tipoPregunta=" + objTipoPregunta +
                // Evitar imprimir listaRespuestas directamente para evitar la recursión infinita
                ", numRespuestas=" + (listaRespuestas != null ? listaRespuestas.size() : 0) +
                '}';
    }

}
