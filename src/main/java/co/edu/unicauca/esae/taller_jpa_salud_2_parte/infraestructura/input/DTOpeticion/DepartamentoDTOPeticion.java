package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DepartamentoDTOPeticion {
    //TODO: notaciones
    private int iddepartamento;
    private String nombre;
    private String descripcion;
}
