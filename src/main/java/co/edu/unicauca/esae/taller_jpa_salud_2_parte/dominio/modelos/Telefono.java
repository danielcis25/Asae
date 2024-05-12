package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Telefono {
    private int idtelefono;
    private String tipotelefono;
    private String numero;
    private Docente objDocente;
    
}