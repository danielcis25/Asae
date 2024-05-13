package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CuestionarioRepository extends CrudRepository<CuestionarioEntity,Integer> {

    @Query("SELECT count(*) FROM CuestionarioEntity p  WHERE p.titulo=?1")
    Integer existeCuestionarioPorTitulo(String titulo);


    List<CuestionarioEntity> findByTituloIgnoreCaseContainingOrderByIdCuestionario(String patron);

    boolean existsByTitulo(@Param("titulo") String titulo);

    @Query("SELECT COUNT(p) > 0 FROM CuestionarioEntity p WHERE p.idcuestionario = :id")
    boolean existsById(@Param("id") String id);

    CuestionarioEntity findByTitulo(String titulo);

}
    