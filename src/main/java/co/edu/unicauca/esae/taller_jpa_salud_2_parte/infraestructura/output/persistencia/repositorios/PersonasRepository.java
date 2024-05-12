package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.PersonaEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonasRepository extends CrudRepository<PersonaEntity, Integer> {
}
