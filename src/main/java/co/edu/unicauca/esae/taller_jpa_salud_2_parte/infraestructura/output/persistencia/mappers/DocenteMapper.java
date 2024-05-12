package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocenteMapper {
    @Bean
    //@Qualifier("DocenteModelMapper")
    
    public ModelMapper crearDocenteMapper() {
        return new ModelMapper();
    }
}
