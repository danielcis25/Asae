package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cuestionarios")

public class Cuestionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcuestionario;

    @Column( nullable = false, length = 30)
    private String titulo;

    @Column( nullable = false, length = 30)
    private String descripcion;

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER, mappedBy = "objCuestionario")
    private List<Pregunta> preguntas;
}
