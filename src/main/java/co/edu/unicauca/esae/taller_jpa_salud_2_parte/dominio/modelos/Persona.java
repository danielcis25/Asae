package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos;


import lombok.Data;

@Data
public class Persona {

    private int idpersona;
    private String tipoidentificacion;
    private String numeroidentificacion;
    private String nombres;
    private String apellidos;


    
}
