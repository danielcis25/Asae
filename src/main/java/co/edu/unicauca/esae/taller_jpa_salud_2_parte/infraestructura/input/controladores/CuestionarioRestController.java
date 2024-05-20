package co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.controladores;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.input.GestionarCuestionarioCUIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.aplicacion.output.GestionarRespuestaGatewayIntPort;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Cuestionario;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Docente;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Pregunta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.dominio.modelos.Respuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.DocenteDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.PreguntaDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOpeticion.RespuestaDTOPeticion;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.CuestionarioDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.DTOrespuesta.DocenteDTORespuesta;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.input.mappers.CuestionarioMapperInfraestructuraDominio;
import co.edu.unicauca.esae.taller_jpa_salud_2_parte.infraestructura.output.persistencia.gateway.GestionarRespuestaGatewayImpAdapter;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class CuestionarioRestController {

    private final GestionarCuestionarioCUIntPort objGestionarCuestionarioCUInt;
    private final GestionarRespuestaGatewayIntPort objRespuestaGatewayAdapter;
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

    //=========
//     @PostMapping("/registrar-respuestas")
//     public ResponseEntity<Void> registrarRespuestas(@ModelAttribute DocenteDTOPeticion docente,
//             @ModelAttribute CuestionarioDTOPeticion cuestionario,
//             @ModelAttribute List<PreguntaDTOPeticion> preguntas) {
//                 Docente objDocenteCrear = modelMapper.map(docente,Docente.class);
//                 Cuestionario objCuestionarioCrear = modelMapper.map(cuestionario,Cuestionario.class);
//                 List<Pregunta> objPreguntas = preguntas.stream()
//                 .map(preguntaDTO -> modelMapper.map(preguntaDTO, Pregunta.class))
//                 .collect(Collectors.toList());

  
//         objRespuestaGatewayAdapter.registrarRespuesta(objDocenteCrear, objCuestionarioCrear, objPreguntas);
//         return ResponseEntity.ok().build();
//     }
        @PostMapping("/registrar-respuestas")
        public ResponseEntity<Void> registrarRespuestas(@RequestBody Map<String, Object> request) {
                // Extraer los objetos del mapa
                ObjectMapper mapper = new ObjectMapper();

                DocenteDTOPeticion docente = mapper.convertValue(request.get("docente"), DocenteDTOPeticion.class);
                CuestionarioDTOPeticion cuestionario = mapper.convertValue(request.get("cuestionario"), CuestionarioDTOPeticion.class);
                List<PreguntaDTOPeticion> preguntas = mapper.convertValue(request.get("preguntas"), new TypeReference<List<PreguntaDTOPeticion>>() {});

                Docente objDocenteCrear = modelMapper.map(docente,Docente.class);
                Cuestionario objCuestionarioCrear = modelMapper.map(cuestionario,Cuestionario.class);
                List<Pregunta> objPreguntas = preguntas.stream()
                        .map(preguntaDTO -> modelMapper.map(preguntaDTO, Pregunta.class))
                        .collect(Collectors.toList());

                objRespuestaGatewayAdapter.registrarRespuesta(objDocenteCrear, objCuestionarioCrear, objPreguntas);
                return ResponseEntity.ok().build();
    }
    //===

}
