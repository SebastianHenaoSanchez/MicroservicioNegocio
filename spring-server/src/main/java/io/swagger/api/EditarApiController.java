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
public class EditarApiController implements EditarApi {
	
	@Autowired
    UserRepository personaRepository;

    private static final Logger log = LoggerFactory.getLogger(EditarApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public EditarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> editarPut(@ApiParam(value = "negocio que va a ser editado" ,required=true )  @Valid @RequestBody JsonApiBodyRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	JsonApiBodyResponseSuccess respuestaExitosa = new JsonApiBodyResponseSuccess();
        	JsonApiBodyResponseErrors responseError = new JsonApiBodyResponseErrors(); 
        	
        	String id_negocio = body.getNegocio().get(0).getIdnegocio();
        	String nombre_empresa = body.getNegocio().get(0).getNombreempresa();
        	String tipo_negocio = body.getNegocio().get(0).getTiponegocio();
        	
        	RegistrarRequest negocio = personaRepository.findOne(id_negocio);
        	if(negocio == null) {
        		
        		responseError.setCodigo("353");
        		responseError.setDetalle("El negocio a editar no existe");
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseError, HttpStatus.NOT_IMPLEMENTED);
        	}
            RegistrarRequest negocio1 = personaRepository.save(body.getNegocio().get(0));
            respuestaExitosa.setIdNegocio(id_negocio);
            respuestaExitosa.setNombreEmpresa(nombre_empresa);
            respuestaExitosa.setTipoNegocio(tipo_negocio);
            
            return new ResponseEntity<JsonApiBodyResponseSuccess>(respuestaExitosa, HttpStatus.OK);
        }

        return new ResponseEntity<JsonApiBodyResponseSuccess>(HttpStatus.NOT_IMPLEMENTED);
    }

}
