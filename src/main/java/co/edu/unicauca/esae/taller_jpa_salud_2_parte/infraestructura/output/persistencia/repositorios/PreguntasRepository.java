package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.PreguntaEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.RespuestaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PreguntasRepository extends CrudRepository<PreguntaEntity, Integer> {

    @Query("SELECT p FROM PreguntaEntity p WHERE p.objCuestionario.idcuestionario = :idCuestionario")
    List<PreguntaEntity> findByObjCuestionarioIdcuestionario(@Param("idCuestionario") Integer idCuestionario);
}