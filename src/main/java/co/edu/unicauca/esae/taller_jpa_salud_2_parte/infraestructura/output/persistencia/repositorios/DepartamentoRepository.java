package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios;


import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.DepartamentoEntity;
import org.springframework.data.repository.CrudRepository;

public interface DepartamentoRepository extends CrudRepository<DepartamentoEntity, Integer> {

}