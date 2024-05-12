package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.TelefonoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TelefonosRepository extends CrudRepository<TelefonoEntity, Integer> {
}