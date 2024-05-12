package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos;

import java.util.ArrayList;
import java.util.List;


import lombok.Data;
@Data
public class Docente extends Persona{
    private String correo;
    private String vinculacion;
    private Telefono objTelefono;
    private List<Respuesta> listaRespuestas;
    private List<Departamento> listaDepartamentos;
    public Docente(){
        this.listaDepartamentos = new ArrayList<>();
        this.listaRespuestas = new ArrayList<>();
    }

}
