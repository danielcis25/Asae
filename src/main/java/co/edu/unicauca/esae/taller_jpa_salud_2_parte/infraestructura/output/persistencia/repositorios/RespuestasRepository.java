package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios;


import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.PreguntaEntity;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.RespuestaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RespuestasRepository extends CrudRepository<RespuestaEntity, Integer> {

    @Query("SELECT p FROM RespuestaEntity p WHERE p.objDocente.idpersona = :idDocente")
    List<RespuestaEntity> findByidDocente(Integer idDocente);

    @Query("SELECT p FROM RespuestaEntity p WHERE p.objPregunta.idpregunta = :idPregunta")
    List<RespuestaEntity> findByPregunta(Integer idPregunta);
    //prueba//
    // @Query("SELECT CASE WHEN COUNT(r) > 0 THEN TRUE ELSE FALSE END FROM Respuesta r WHERE r.idDocente = ?1 AND r.cuestionario = ?2")
    // boolean existsByDocenteAndCuestionario(Docente docente, Cuestionario cuestionario);
    //@Query("SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END AS Existe_Asociacion FROM Respuesta r WHERE r.idDocente = ?1 AND r.idpregunta = ?2")
    //boolean existsByDocenteAndCuestionario(Integer idDocente,Integer idCuestionario);
    // Método para verificar si ya existe una respuesta de un docente para una pregunta
    boolean existsByObjDocenteIdpersonaAndObjPreguntaIdpregunta(int idDocente, int idPregunta);

}