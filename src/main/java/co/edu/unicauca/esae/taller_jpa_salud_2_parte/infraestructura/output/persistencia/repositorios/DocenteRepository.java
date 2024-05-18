package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.DocenteEntity;
import org.springframework.data.repository.query.Param;

public interface DocenteRepository extends JpaRepository<DocenteEntity,Integer> {
    @Query("SELECT COUNT(d) > 0 FROM DocenteEntity d WHERE d.idpersona = :idpersona")
    //@Query("SELECT COUNT(d) > 0 FROM DocenteEntity d WHERE LOWER(CAST(d.idpersona AS string)) = LOWER(:idpersona)")

    boolean existsByID(@Param("idpersona") String idpersona);

    DocenteEntity findById(int idpersona);



    //
}


