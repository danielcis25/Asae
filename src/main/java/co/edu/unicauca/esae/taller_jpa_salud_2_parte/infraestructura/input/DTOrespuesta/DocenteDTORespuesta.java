package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDTORespuesta {
    private Integer idPersona;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private String correo;
    private String vinculacion;
    private TelefonoDTORespuesta objTelefono;
    // @JsonIgnore
    private List<RespuestaDTORespuesta> listaRespuestas;
    // @JsonIgnore
    private List<DepartamentoDTORespuesta> listaDepartamentos;

    // public DocenteDTORespuesta(int idpersona, String tipoidentificacion, String numeroidentificacion, String nombres, String apellidos) {
    //     super(idpersona, tipoidentificacion, numeroidentificacion, nombres, apellidos);
    // }

    // public DocenteDTORespuesta() {

    // }
}
