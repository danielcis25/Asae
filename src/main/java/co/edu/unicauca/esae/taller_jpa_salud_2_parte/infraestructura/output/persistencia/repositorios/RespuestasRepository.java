package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios;


import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.RespuestaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RespuestasRepository extends CrudRepository<RespuestaEntity, Integer> {

    @Query("SELECT p FROM RespuestaEntity p WHERE p.objDocente.idpersona = :idDocente")
    List<RespuestaEntity> findByidDocente(Integer idDocente);
}