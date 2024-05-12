package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Personas")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpersona;

    @Column(nullable = false, length = 30)
    private String tipoidentificacion;

    @Column(unique = true, nullable = false, length = 30)
    private String numeroidentificacion;

    @Column(nullable = false, length = 30)
    private String nombres;

    @Column(nullable = false, length = 30)
    private String apellidos;


}
