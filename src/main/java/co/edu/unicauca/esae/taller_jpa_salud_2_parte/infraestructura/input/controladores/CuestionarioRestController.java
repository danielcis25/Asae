package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.controladores;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.input.GestionarCuestionarioCUIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.CuestionarioDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.DocenteDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.mappers.CuestionarioMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class CuestionarioRestController {

    private final GestionarCuestionarioCUIntPort objGestionarCuestionarioCUInt;
    private final ModelMapper modelMapper;
    private final CuestionarioMapperInfraestructuraDominio objMapeador;

    // @PostMapping("/cuestionarios")
    // public ResponseEntity<CuestionarioDTORespuesta> create(@Valid @RequestBody CuestionarioDTOPeticion objCuestionario) {
    //     Cuestionario objCuestionarioCrear = objMapeador.mappearDePeticionACuestionario(objCuestionario);
    //     Cuestionario objCuestionarioCreado = objGestionarCuestionarioCUInt.crearCuestionario(objCuestionarioCrear);
    //     ResponseEntity<CuestionarioDTORespuesta> objRespuesta = new ResponseEntity<CuestionarioDTORespuesta>(
    //             objMapeador.mappearDeCuestionarioARespuesta(objCuestionarioCreado),
    //             HttpStatus.CREATED);
    //     return objRespuesta;
    // }
    @PostMapping("/cuestionarios")
    public ResponseEntity<CuestionarioDTORespuesta> create(@Valid @RequestBody CuestionarioDTOPeticion objCuestionario) {
        Cuestionario objCuestionarioCrear = modelMapper.map(objCuestionario,Cuestionario.class);
        Cuestionario objCuestionarioCreado = objGestionarCuestionarioCUInt.crearCuestionario(modelMapper.map(objCuestionarioCrear, Cuestionario.class));
        ResponseEntity<CuestionarioDTORespuesta> objRespuesta = new ResponseEntity<CuestionarioDTORespuesta>(
                modelMapper.map(objCuestionarioCreado, CuestionarioDTORespuesta.class),
                HttpStatus.CREATED);
        return objRespuesta;
    }

    // @GetMapping("/cuestionarios")
    // public ResponseEntity<List<CuestionarioDTORespuesta>> listar() {
    //     ResponseEntity<List<CuestionarioDTORespuesta>> objRespuesta = new ResponseEntity<List<CuestionarioDTORespuesta>>(
    //             objMapeador.mappearDeCuestionariosARespuesta(this.objGestionarCuestionarioCUInt.listarCuestionarios()),
    //             HttpStatus.OK);
    //     return objRespuesta;
    // }
    @GetMapping("/cuestionarios")
    public ResponseEntity<List<CuestionarioDTORespuesta>> listar() {

        Iterable<Cuestionario> cuestionarios = this.objGestionarCuestionarioCUInt.listarCuestionarios();
        List<CuestionarioDTORespuesta> listCuestionarios = this.modelMapper.map(cuestionarios,
                new TypeToken<List<CuestionarioDTORespuesta>>() {
                }.getType());

        ResponseEntity<List<CuestionarioDTORespuesta>> objRespuesta = new ResponseEntity<List<CuestionarioDTORespuesta>>
                (listCuestionarios,
                        HttpStatus.OK
                );

        return objRespuesta;
    }
    @GetMapping("/cuestionarios/patron-titulo")
    public ResponseEntity<List<CuestionarioDTORespuesta>> findAllPatron(@RequestParam String patronTitulo ) {
        List<CuestionarioDTORespuesta> publicaciones = this.objGestionarCuestionarioCUInt.consultarCuestionarioPorPatron(patronTitulo);

        ResponseEntity<List<CuestionarioDTORespuesta>> response = new ResponseEntity<List<CuestionarioDTORespuesta>>
                (publicaciones,
                        HttpStatus.OK);
        return response;
    }

}
