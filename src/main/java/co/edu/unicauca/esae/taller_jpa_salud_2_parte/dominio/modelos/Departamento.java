package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Departamento {


    private int iddepartamento;
    private String nombre;
    private String descripcion;
    

}

