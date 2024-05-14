package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos;

import java.util.ArrayList;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor

public class Docente extends Persona{
    private String correo;
    private String vinculacion;
    private Telefono objTelefono;
    private List<Respuesta> listaRespuestas;
    private List<Departamento> listaDepartamentos;
    public Docente(){
        super();
        this.listaDepartamentos = new ArrayList<>();
        this.listaRespuestas = new ArrayList<>();
    }

    public Docente( String tipoIdentificacion, String numeroIdentificacion, String nombres,
                    String apellidos, String correo, String vinculacion, Telefono telefono) {
        super( tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
    }


    public Docente(Integer idPersona, String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos, String correo, String vinculacion, Telefono telefono) {
        super(idPersona, tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
        this.objTelefono = telefono;
    }


}
