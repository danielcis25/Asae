package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "Preguntas")
public class Pregunta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpregunta;

    @Column(nullable = false, length = 30)
    private String enunciado;

    @OneToMany(mappedBy = "objPregunta", fetch = FetchType.EAGER)
	private List<Respuesta> listaRespuestas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipoPregunta", nullable = false)
    private TipoPregunta objTipoPregunta;

    @ManyToOne
    @JoinColumn(name = "idCuestionario", nullable = false)
    private Cuestionario objCuestionario;

    public Pregunta(){
        this.listaRespuestas = new ArrayList<>();
    }

}
