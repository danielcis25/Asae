package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cuestionario {
    
    private int idcuestionario;
    private String titulo;
    private String descripcion;
    private List<Pregunta> preguntas;
}
