package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Telefono")
public class TelefonoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtelefono;

    @Column(nullable = false, length = 30)
    private String tipotelefono;

    @Column(nullable = false, length = 30)
    private String numero;
    
    // @JsonIgnore
    // @OneToOne
    // @JoinColumn(name="idDocente")
    // private DocenteEntity objDocente;
    @MapsId
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name="idpersona")
    private DocenteEntity objDocente;

}
