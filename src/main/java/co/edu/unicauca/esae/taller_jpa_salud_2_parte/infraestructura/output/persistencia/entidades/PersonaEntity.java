package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Personas")
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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

    public PersonaEntity(String tipoidentificacion, String numeroidentificacion, String nombres, String apellidos) {
        this.tipoidentificacion = tipoidentificacion;
        this.numeroidentificacion = numeroidentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

}
