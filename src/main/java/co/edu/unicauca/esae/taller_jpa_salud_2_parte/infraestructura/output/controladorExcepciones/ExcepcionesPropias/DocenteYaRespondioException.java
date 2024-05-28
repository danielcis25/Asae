package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.ExcepcionesPropias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class DocenteYaRespondioException extends RuntimeException {

    public DocenteYaRespondioException(String message) {
        super(message);
    }
}
