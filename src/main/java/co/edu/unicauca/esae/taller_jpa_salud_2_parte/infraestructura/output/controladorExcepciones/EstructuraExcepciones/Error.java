package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.EstructuraExcepciones;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Error {
    /**
   * Código de error de la aplicación
   */
    private String codigoError;
    /**
     * Mensaje de error generado
     */
    private String mensaje;
    /**
     * Código de estatus http
     */
    private Integer codigoHttp;
    /**
     * Url de la petición que generó el error
     */
    // @Accessors(chain = true)
    private String url;
    /**
     * Método de la petición que generó el error
     */
    // @Accessors(chain = true)
    private String metodo;

}
