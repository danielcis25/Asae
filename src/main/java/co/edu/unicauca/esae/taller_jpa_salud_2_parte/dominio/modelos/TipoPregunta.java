package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoPregunta {
    private int idtippregunta;
    private String nombre;
    private String descripcion;
    private List<Pregunta> preguntas;


}

