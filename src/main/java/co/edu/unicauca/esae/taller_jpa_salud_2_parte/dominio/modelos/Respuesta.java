package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Respuesta")
public class Respuesta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrespuesta;

    @Column(nullable = false, length = 30)
    private String descripcion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPregunta")
    private Pregunta objPregunta;

    @ManyToOne
    @JoinColumn(name = "idDocente")
    private Docente objDocente;

}

