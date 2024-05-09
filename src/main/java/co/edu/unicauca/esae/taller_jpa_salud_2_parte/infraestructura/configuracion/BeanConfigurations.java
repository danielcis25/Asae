package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.CuestionarioFormateadorResultadoIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.casosDeUso.GestionarCuestionarioCUAdapter;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.casosDeUso.GestionarDocenteCUAdapter;

@Configuration
public class BeanConfigurations {

    @Bean
    public GestionarCuestionarioCUAdapter crearGestionarCuestionarioCUInt(
        GestionarCuestionarioGatewayIntPort objGestionarCuestionarioGateway,
        CuestionarioFormateadorResultadoIntPort objCuestionarioFormateadorRespuestas){
        GestionarCuestionarioCUAdapter objGestionarCuestionarioCU = new GestionarCuestionarioCUAdapter(objGestionarCuestionarioGateway,
         objCuestionarioFormateadorRespuestas);
        return objGestionarCuestionarioCU;
    }

    @Bean
    public GestionarDocenteCUAdapter crearGestionarDocenteCUInt(
            GestionarDocenteGatewayIntPort objGestionarDocenteGateway,
            CuestionarioFormateadorResultadoIntPort objDocenteFormateadorResultados) {
        return new GestionarDocenteCUAdapter(objGestionarDocenteGateway, objDocenteFormateadorResultados);
    }
}
