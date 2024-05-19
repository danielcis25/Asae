package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Size;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Preguntas")
public class PreguntaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpregunta;

    @Column(nullable = false, length = 30)
    private String enunciado;

    @OneToMany(mappedBy = "objPregunta", fetch = FetchType.EAGER)
    private List<RespuestaEntity> listaRespuestas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipoPregunta", nullable = false)
    private TipoPreguntaEntity objTipoPregunta;

    @ManyToOne
    @JoinColumn(name = "idCuestionario", nullable = false)
    private CuestionarioEntity objCuestionario;

    // public PreguntaEntity(){
    //     this.listaRespuestas = new ArrayList<>();
    // }

}
