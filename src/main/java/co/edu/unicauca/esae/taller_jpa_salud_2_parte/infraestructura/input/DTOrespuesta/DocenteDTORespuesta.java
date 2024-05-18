package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDTORespuesta {

    private int idpersona;
    private String tipoidentificacion;
    private String numeroidentificacion;
    private String nombres;
    private String apellidos;
    private String correo;
    private String vinculacion;
    //@JsonIgnore
    private TelefonoDTORespuesta objTelefono;
    //@JsonIgnore
    private List<RespuestaDTORespuesta> listaRespuestas;
    //@JsonIgnore
    private List<DepartamentoDTORespuesta> listaDepartamentos;

}
