package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta;


import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.PreguntaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaDTORespuesta {

    private int idrespuesta;
    private String descripcion;
    private List<PreguntaDTORespuesta> preguntas;

    private DocenteDTORespuesta objDocente;
    private CuestionarioDTORespuesta objCuestionario;

    public RespuestaDTORespuesta(int idrespuesta, String descripcion) {
    }







    //private PreguntaDTOPeticion objPregunta;
    //private DocenteDTORespuesta objDocente;

    // public RespuestaDTORespuesta(){

    // }

    // public RespuestaDTORespuesta(int idrespuesta, String descripcion, PreguntaDTOPeticion objPregunta) {
    //     this.idrespuesta = idrespuesta;
    //     this.descripcion = descripcion;
    //     this.objPregunta = objPregunta;
    // }
}
