package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.ExcepcionesPropias;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.EstructuraExcepciones.CodigoError;
import lombok.Getter;

@Getter
public class EntidadYaExisteException extends RuntimeException{

private final String llaveMensaje;
  private final String codigo;

  public EntidadYaExisteException(CodigoError code) {
    super(code.getCodigo());
    this.llaveMensaje = code.getLlaveMensaje();
    this.codigo = code.getCodigo();
  }

  public EntidadYaExisteException(final String message) {
    super(message);
    this.llaveMensaje = CodigoError.ENTIDAD_YA_EXISTE.getLlaveMensaje();
    this.codigo = CodigoError.ENTIDAD_YA_EXISTE.getCodigo();
  }
}
