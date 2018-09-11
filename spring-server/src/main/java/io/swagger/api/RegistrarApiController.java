package io.swagger.api;

import io.swagger.model.JsonApiBodyRequest;
import io.swagger.model.JsonApiBodyResponseErrors;
import io.swagger.model.JsonApiBodyResponseSuccess;
import io.swagger.model.RegistrarRequest;
import io.swagger.repository.UserRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-02T15:28:49.618Z")


@Controller
public class RegistrarApiController implements RegistrarApi {
	
	@Autowired
	UserRepository personaRepository;
	
    private static final Logger log = LoggerFactory.getLogger(RegistrarApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public RegistrarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<JsonApiBodyResponseSuccess> registrarPost(@ApiParam(value = "Json a ingresar" ,required=true )  @Valid @RequestBody JsonApiBodyRequest body) {
        String accept = request.getHeader("Accept");
        JsonApiBodyResponseSuccess respuestaExitosa = new JsonApiBodyResponseSuccess(); 
        if (accept != null && accept.contains("application/json")) {
            String id_negocio = body.getNegocio().get(0).getIdnegocio();
            String nombre_empresa = body.getNegocio().get(0).getNombreempresa();
            String tipo_negocio = body.getNegocio().get(0).getTiponegocio();
            
            
            
            RegistrarRequest persona = personaRepository.save(body.getNegocio().get(0));
            
            respuestaExitosa.setIdNegocio(persona.getIdnegocio());
            respuestaExitosa.setNombreEmpresa(persona.getNombreempresa());
            respuestaExitosa.setTipoNegocio(persona.getTiponegocio());
            return new ResponseEntity<JsonApiBodyResponseSuccess>(respuestaExitosa, HttpStatus.OK);
             
        }

        return new ResponseEntity<JsonApiBodyResponseSuccess>(HttpStatus.NOT_IMPLEMENTED);
    }

}
