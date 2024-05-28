package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.EstructuraExcepciones.CodigoError;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.EstructuraExcepciones.ErrorUtils;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.ExcepcionesPropias.EntidadNoExisteException;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.ExcepcionesPropias.EntidadYaExisteException;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.ExcepcionesPropias.ReglaNegocioExcepcion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.controladorExcepciones.EstructuraExcepciones.Error;
@ControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(Exception.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final Exception ex, final Locale locale) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.ERROR_GENERICO.getCodigo(),
                                                CodigoError.ERROR_GENERICO.getLlaveMensaje(),
                                                HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //===========
        // @ExceptionHandler(EntidadYaExisteException.class)
        // public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
        //                 final EntidadYaExisteException ex) {
        //         final Error error = ErrorUtils
        //                         .crearError(CodigoError.ENTIDAD_YA_EXISTE.getCodigo(),
        //                                         String.format("%s, %s", CodigoError.ENTIDAD_YA_EXISTE.getLlaveMensaje(),
        //                                                         ex.getMessage()),
        //                                         HttpStatus.NOT_ACCEPTABLE.value())
        //                         .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
        //         return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
        // }
        @ExceptionHandler(EntidadYaExisteException.class)
        @ResponseStatus(HttpStatus.CONFLICT)  // Puedes usar HttpStatus.CONFLICT (409) para indicar un conflicto de datos
        public ResponseEntity<String> handleEntidadYaExisteException(EntidadYaExisteException ex) {
        // Puedes devolver una estructura de JSON más detallada si lo prefieres
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
//========================================
        @ExceptionHandler(ReglaNegocioExcepcion.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final ReglaNegocioExcepcion ex, final Locale locale) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.VIOLACION_REGLA_DE_NEGOCIO.getCodigo(), ex.formatException(),
                                                HttpStatus.BAD_REQUEST.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(EntidadNoExisteException.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final EntidadNoExisteException ex, final Locale locale) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.ENTIDAD_NO_ENCONTRADA.getCodigo(),
                                                String.format("%s, %s",
                                                                CodigoError.ENTIDAD_NO_ENCONTRADA.getLlaveMensaje(),
                                                                ex.getMessage()),
                                                HttpStatus.NOT_FOUND.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
                System.out.println("Retornando respuesta con los errores identificados");
                Map<String, String> errores = new HashMap<>();
                ex.getBindingResult().getAllErrors().forEach((error) -> {
                        String campo = ((FieldError) error).getField();
                        String mensajeDeError = error.getDefaultMessage();
                        errores.put(campo, mensajeDeError);
                });

                return new ResponseEntity<Map<String, String>>(errores, HttpStatus.BAD_REQUEST);
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(ConstraintViolationException.class)
        ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
                return new ResponseEntity<>(e.getMessage(),
                                HttpStatus.BAD_REQUEST);
        }
}
