package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuestionarioDTORespuesta {

    private int idcuestionario;
    private String titulo;
    private String descripcion;
    private List<PreguntaDTORespuesta> preguntas;

}
