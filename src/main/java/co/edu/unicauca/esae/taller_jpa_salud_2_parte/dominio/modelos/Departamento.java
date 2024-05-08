package co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddepartamento;

    @Column(name = "nombredep", nullable = false, length = 30)
    private String nombre;

    @Column( nullable = false, length = 30)
    private String descripcion;
    

}

