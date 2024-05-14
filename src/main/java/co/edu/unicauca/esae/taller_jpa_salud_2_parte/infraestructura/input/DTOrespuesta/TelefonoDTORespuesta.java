package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class TelefonoDTORespuesta {

    private int idtelefono;
    private String tipotelefono;
    private String numero;
    //private DocenteDTORespuesta objDocente;


    public TelefonoDTORespuesta(int idtelefono, String numero, String tipotelefono) {
    }
}
