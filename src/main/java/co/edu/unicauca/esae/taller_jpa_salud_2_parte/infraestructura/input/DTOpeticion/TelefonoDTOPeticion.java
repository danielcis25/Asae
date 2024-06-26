package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
// @NoArgsConstructor
public class TelefonoDTOPeticion {
    //TODO: notaciones
    //@Nullable
    private int idtelefono;
    private String tipotelefono;
    //@Pattern(regexp = "^3[0-9]{9}$", message = "El teléfono debe tener 10 números y comenzar con 3")
    private String numero;
    private DocenteDTOPeticion objDocente;

}
