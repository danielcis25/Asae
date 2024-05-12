package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.ExcepcionesPropias;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.EstructuraExcepciones.CodigoError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class GestionClientesRuntimeException extends RuntimeException{

protected CodigoError codigoError;

  public abstract String formatException();
}
