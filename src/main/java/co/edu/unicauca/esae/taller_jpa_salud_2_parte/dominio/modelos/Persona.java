package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos;


import lombok.Data;

@Data
public class Persona {

    private int idpersona;
    private String tipoidentificacion;
    private String numeroidentificacion;
    private String nombres;
    private String apellidos;

    public Persona(String tipoidentificacion, String numeroidentificacion, String nombres, String apellidos) {
        this.tipoidentificacion = tipoidentificacion;
        this.numeroidentificacion = numeroidentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Persona() {

    }
}
