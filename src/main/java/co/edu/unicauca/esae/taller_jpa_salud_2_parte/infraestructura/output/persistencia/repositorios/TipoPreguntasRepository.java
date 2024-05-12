package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.TipoPreguntaEntity;
import org.springframework.data.repository.CrudRepository;

public interface TipoPreguntasRepository extends CrudRepository<TipoPreguntaEntity, Integer> {
}
