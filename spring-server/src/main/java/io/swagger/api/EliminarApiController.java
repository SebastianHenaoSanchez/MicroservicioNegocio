package io.swagger.api;

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
public class EliminarApiController implements EliminarApi {

	@Autowired
    UserRepository personaRepository;
	
    private static final Logger log = LoggerFactory.getLogger(EliminarApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public EliminarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> eliminarIdnegocioDelete(@ApiParam(value = "id de negocio a eliminar",required=true) @PathVariable("idnegocio") String idnegocio) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	System.out.println(idnegocio);
        	JsonApiBodyResponseSuccess respuestaExitosa = new JsonApiBodyResponseSuccess();
        	JsonApiBodyResponseErrors responseError = new JsonApiBodyResponseErrors(); 
        	RegistrarRequest negocio = personaRepository.findOne(idnegocio);
        	System.out.println("depues de buscar el id");
        	if (negocio ==null) {
        		responseError.setCodigo("435");
        		responseError.setDetalle("no existe el id en la base de datos");
        		return new ResponseEntity<JsonApiBodyResponseErrors>(responseError, HttpStatus.NOT_IMPLEMENTED);
        		
        	}
         
             personaRepository.delete(idnegocio);
             respuestaExitosa.setIdNegocio(negocio.getIdnegocio());
             respuestaExitosa.setNombreEmpresa(negocio.getNombreempresa());
             respuestaExitosa.setTipoNegocio(negocio.getTiponegocio());
             return new ResponseEntity<JsonApiBodyResponseSuccess>(respuestaExitosa,HttpStatus.OK);
            
        }

        return new ResponseEntity<JsonApiBodyResponseSuccess>(HttpStatus.NOT_IMPLEMENTED);
    }

}
