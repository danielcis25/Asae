package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.CuestionarioEntity;
public interface CuestionarioRepositoryInt extends CrudRepository<CuestionarioEntity,Integer> {

    @Query("SELECT count(*) FROM CuestionarioEntity p  WHERE p.titulo=?1")
    Integer existeCuestionarioPorTitulo(String titulo);
}
    