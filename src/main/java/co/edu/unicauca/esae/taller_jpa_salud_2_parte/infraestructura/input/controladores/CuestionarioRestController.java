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

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.input.GestionarCuestionarioCUIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.CuestionarioDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.mappers.CuestionarioMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class CuestionarioRestController {

    private final GestionarCuestionarioCUIntPort objGestionarCuestionarioCUInt;
    private final CuestionarioMapperInfraestructuraDominio objMapeador;

    @PostMapping("/cuestionarios")
    public ResponseEntity<CuestionarioDTORespuesta> create(@RequestBody CuestionarioDTOPeticion objCuestionario) {
        Cuestionario objCuestionarioCrear = objMapeador.mappearDePeticionACuestionario(objCuestionario);
        Cuestionario objCuestionarioCreado = objGestionarCuestionarioCUInt.crearCuestionario(objCuestionarioCrear);
        ResponseEntity<CuestionarioDTORespuesta> objRespuesta = new ResponseEntity<CuestionarioDTORespuesta>(
                objMapeador.mappearDeCuestionarioARespuesta(objCuestionarioCreado),
                HttpStatus.CREATED);
        return objRespuesta;
    }

    @GetMapping("/cuestionarios")
    public ResponseEntity<List<CuestionarioDTORespuesta>> listar() {
        ResponseEntity<List<CuestionarioDTORespuesta>> objRespuesta = new ResponseEntity<List<CuestionarioDTORespuesta>>(
                objMapeador.mappearDeCuestionariosARespuesta(this.objGestionarCuestionarioCUInt.listarCuestionarios()),
                HttpStatus.OK);
        return objRespuesta;
    }

}
