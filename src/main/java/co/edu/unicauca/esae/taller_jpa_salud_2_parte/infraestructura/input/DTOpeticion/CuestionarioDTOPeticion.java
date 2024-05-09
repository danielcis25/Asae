package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CuestionarioDTOPeticion {
    //TODO:notaciones
    private int idcuestionario;
    @NotNull(message = "{producto.codigo.emply}")
    @Size(min = 3, max = 20, message = "{producto.codigo.size}")
    private String titulo;
    @NotNull(message = "{producto.codigo.emply}")
    @Size(min = 1, max = 100, message = "{producto.codigo.size}")
    private String descripcion;
    private List<PreguntaDTOPeticion> preguntas;

}
