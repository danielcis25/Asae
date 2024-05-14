package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.PersonaEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonasRepository extends CrudRepository<PersonaEntity, Integer> {
    @Query("SELECT COUNT(d) > 0 FROM DocenteEntity d WHERE d.idpersona = :idpersona")
    //@Query("SELECT COUNT(d) > 0 FROM DocenteEntity d WHERE LOWER(CAST(d.idpersona AS string)) = LOWER(:idpersona)")

    boolean existsByID(@Param("idpersona") String idpersona);
}
