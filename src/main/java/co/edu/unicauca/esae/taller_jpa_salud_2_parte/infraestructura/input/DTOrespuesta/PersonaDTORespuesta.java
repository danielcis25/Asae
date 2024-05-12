package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonaDTORespuesta {
    private int idpersona;
    private String tipoidentificacion;
    private String numeroidentificacion;
    private String nombres;
    private String apellidos;
    
    public PersonaDTORespuesta(){
        
    }
}
