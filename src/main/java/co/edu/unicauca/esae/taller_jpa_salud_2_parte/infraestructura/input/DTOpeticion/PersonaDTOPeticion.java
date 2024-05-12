package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonaDTOPeticion {
    private int idpersona;
    @NotNull(message = "{producto.codigo.emply}")
    private String tipoidentificacion;
    @NotNull(message = "{producto.codigo.emply}")
    @Size(min = 1, max = 20, message = "{producto.codigo.size}")
    private String numeroidentificacion;
    @NotNull(message = "{producto.codigo.emply}")
    @Size(min = 1, max = 30, message = "{producto.codigo.size}")
    private String nombres;
    @NotNull(message = "{producto.codigo.emply}")
    @Size(min = 1, max = 30, message = "{producto.codigo.size}")
    private String apellidos;
    public PersonaDTOPeticion() {
    }

}
