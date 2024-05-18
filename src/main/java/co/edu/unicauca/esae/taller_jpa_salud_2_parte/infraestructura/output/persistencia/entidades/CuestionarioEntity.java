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
@Table(name = "Cuestionarios")

public class CuestionarioEntity {

    public CuestionarioEntity(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcuestionario;

    @Column( nullable = false, length = 30)
    private String titulo;

    @Column( nullable = false, length = 30)
    private String descripcion;

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER, mappedBy = "objCuestionario")
    private List<PreguntaEntity> preguntas;
}
