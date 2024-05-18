package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Telefono {
    private int idtelefono;
    private Integer idPersona;
    private String tipotelefono;
    private String numero;
    private Docente objDocente;

    public Telefono(Integer idPersona, Integer idtelefono, String tipotelefono, String numero) {
        this.idPersona = idPersona;
        this.idtelefono = idtelefono;
        this.tipotelefono = tipotelefono;
        this.numero = numero;
    }
}