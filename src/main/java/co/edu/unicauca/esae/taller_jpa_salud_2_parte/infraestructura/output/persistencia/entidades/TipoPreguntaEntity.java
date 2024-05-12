package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TipoPregunta")

public class TipoPreguntaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtippregunta;

    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(nullable = false, length = 30)
    private String descripcion;


    @OneToMany(mappedBy = "objTipoPregunta")
    private List<PreguntaEntity> preguntas;

}
