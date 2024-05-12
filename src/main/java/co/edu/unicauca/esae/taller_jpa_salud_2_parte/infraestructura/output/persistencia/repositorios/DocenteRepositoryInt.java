package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.DocenteEntity;

public interface DocenteRepositoryInt extends CrudRepository<DocenteEntity,Integer> {
    @Query("SELECT count(*) FROM DocenteEntity p  WHERE p.idpersona=?1")
    Integer existeDocentePorId(int idpersona);
}
