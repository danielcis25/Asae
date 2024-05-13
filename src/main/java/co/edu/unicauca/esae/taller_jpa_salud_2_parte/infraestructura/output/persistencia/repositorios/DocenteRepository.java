package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.DocenteEntity;
import org.springframework.data.repository.query.Param;

public interface DocenteRepository extends CrudRepository<DocenteEntity,Integer> {
    @Query("SELECT COUNT(d) > 0 FROM DocenteEntity d WHERE LOWER(d.correo) = LOWER(:correo)")
    boolean existsByCorreo(@Param("correo") String correo);

    DocenteEntity findByCorreo(String correo);

    int existsById(int idDocente);
}


