package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.Doc;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {


    private int iddepartamento;
    private String nombre;
    private String descripcion;
    private List<Docente> docentes;


}

