package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DocenteDTOPeticion{
    //TODO: notaciones
    private Integer idpersona;
    private String tipoidentificacion;
    @Size(min=5, max = 11, message="{docente.longitud.numeroidenticacion}")
    private String numeroidentificacion;
    @NotNull(message = "{producto.codigo.emply}")
    @Size(min = 1, max = 30, message = "{producto.codigo.size}")
    private String nombres;
    @NotNull(message = "{producto.codigo.emply}")
    @Size(min = 1, max = 30, message = "{producto.codigo.size}")
    private String apellidos;
    //---
    @Email(message = "El correo electrónico debe tener un formato válido")
    private String correo;
    private String vinculacion;
    
    //la notacion va solo en el telefonoDTO o en cada dto que lo use?
    @Pattern(regexp = "^3[0-9]{9}$", message = "El teléfono debe tener 10 números y comenzar con 3")
    private TelefonoDTOPeticion objTelefono;
    private List<RespuestaDTOPeticion> listaRespuestas;
    private List<DepartamentoDTOPeticion> listaDepartamentos;
    // public DocenteDTOPeticion(int idpersona, String tipoidentificacion, String numeroidentificacion, String nombres, String apellidos) {
    //     super(idpersona, tipoidentificacion, numeroidentificacion, nombres, apellidos);
    // }
    // public DocenteDTOPeticion(){

    // }

}
