package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DepartamentoDTORespuesta {

    private int iddepartamento;
    private String nombre;
    private String descripcion;

    public DepartamentoDTORespuesta() {

    }

}
