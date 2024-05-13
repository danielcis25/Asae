package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DocenteDTORespuesta extends PersonaDTORespuesta {

    private String correo;
    private String vinculacion;
    private TelefonoDTORespuesta objTelefono;
    private List<RespuestaDTORespuesta> listaRespuestas;
    private List<DepartamentoDTORespuesta> listaDepartamentos;

    public DocenteDTORespuesta(int idpersona, String tipoidentificacion, String numeroidentificacion, String nombres, String apellidos) {
        super(idpersona, tipoidentificacion, numeroidentificacion, nombres, apellidos);
    }

    public DocenteDTORespuesta() {

    }
}
