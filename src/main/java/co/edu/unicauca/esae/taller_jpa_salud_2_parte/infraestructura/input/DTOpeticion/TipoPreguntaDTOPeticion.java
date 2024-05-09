package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TipoPreguntaDTOPeticion {
    //TODO: agregar notaciones
    private int idtippregunta;
    private String nombre;
    private String descripcion;
    private List<PreguntaDTOPeticion> preguntas;
}
