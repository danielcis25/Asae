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
@Table(name = "TipoPregunta")
public class TipoPregunta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtippregunta;

    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(nullable = false, length = 30)
    private String descripcion;


    @OneToMany(mappedBy = "objTipoPregunta")
    private List<Pregunta> preguntas;


}

