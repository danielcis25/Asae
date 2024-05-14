package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@Entity
@AllArgsConstructor

@Table(name = "Docentes")
public class DocenteEntity extends PersonaEntity{

    public DocenteEntity(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos, String correo, String vinculacion,
                         TelefonoEntity objTelefono, List<RespuestaEntity> listaRespuestas, List<DepartamentoEntity> listaDepartamentos) {
        super( tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
        this.objTelefono = objTelefono;
        this.listaRespuestas = listaRespuestas;
        this.listaDepartamentos = listaDepartamentos;
    }

    @Column(nullable = false, length = 30)
    private String correo;

    @Column(nullable = false, length = 30)
    private String vinculacion;

    @JsonManagedReference
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "objDocente")
    private TelefonoEntity objTelefono;

    @OneToMany(mappedBy = "objDocente")
    private List<RespuestaEntity> listaRespuestas;

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name="DocenteDepartamento",
                joinColumns = @JoinColumn(name="iddocente"),
                inverseJoinColumns = @JoinColumn(name="iddepartamento"))
    private List<DepartamentoEntity> listaDepartamentos;


    public DocenteEntity(){
        this.listaDepartamentos = new ArrayList<>();
        this.listaRespuestas = new ArrayList<>();
    }
}
