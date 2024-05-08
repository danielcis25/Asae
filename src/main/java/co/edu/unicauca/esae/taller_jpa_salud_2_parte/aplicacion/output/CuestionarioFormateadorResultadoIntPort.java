package co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output;

public interface CuestionarioFormateadorResultadoIntPort {

    public void retornarRespuestaErrorEntidadExiste(String mensaje);

    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);

}
