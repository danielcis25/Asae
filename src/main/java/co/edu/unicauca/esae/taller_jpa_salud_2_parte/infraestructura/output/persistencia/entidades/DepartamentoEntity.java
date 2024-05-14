package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "Departamentos")
public class DepartamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddepartamento;

    @Column(name = "nombredep", nullable = false, length = 30)
    private String nombre;

    @Column( nullable = false, length = 30)
    private String descripcion;

    public DepartamentoEntity() {
    }

    public DepartamentoEntity(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
