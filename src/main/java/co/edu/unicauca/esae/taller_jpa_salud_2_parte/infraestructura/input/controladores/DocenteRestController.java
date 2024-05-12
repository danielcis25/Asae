package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.controladores;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.DocenteDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.DocenteDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.mappers.DocenteMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated  
public class DocenteRestController {

    private final GestionarDocenteCUIntPort objGestionarDocenteCUInt;
    private final DocenteMapperInfraestructuraDominio objMapeador;

    @PostMapping("/docentes")
    public ResponseEntity<DocenteDTORespuesta> create(@RequestBody DocenteDTOPeticion objDocente) {
        Docente objDocenteCrear = objMapeador.mappearDePeticionADocente(objDocente);
        Docente objDocenteCreado = objGestionarDocenteCUInt.registrarDocente(objDocenteCrear);
        ResponseEntity<DocenteDTORespuesta> objRespuesta = new ResponseEntity<DocenteDTORespuesta>(
                objMapeador.mappearDeDocenteARespuesta(objDocenteCreado),
                HttpStatus.CREATED);
        return objRespuesta;
    }

    @GetMapping("/docentes")
    public ResponseEntity<List<DocenteDTORespuesta>> listar() {
        ResponseEntity<List<DocenteDTORespuesta>> objRespuesta = new ResponseEntity<List<DocenteDTORespuesta>>(
                objMapeador.mappearDeDocentesARespuesta(this.objGestionarDocenteCUInt.listar()),
                HttpStatus.OK);
        return objRespuesta;
    }

}
