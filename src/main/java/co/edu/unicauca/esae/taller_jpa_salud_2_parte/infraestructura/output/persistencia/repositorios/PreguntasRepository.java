package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.PreguntaEntity;
import org.springframework.data.repository.CrudRepository;

public interface PreguntasRepository extends CrudRepository<PreguntaEntity, Integer> {

}