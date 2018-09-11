package io.swagger.api;

import io.swagger.model.JsonApiBodyRequest;
import io.swagger.model.JsonApiBodyResponseErrors;
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
import java.util.ArrayList;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-02T15:28:49.618Z")

@Controller
public class ListarApiController implements ListarApi {

	 @Autowired
	 UserRepository personaRepository;
	 
    private static final Logger log = LoggerFactory.getLogger(ListarApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
   
    @org.springframework.beans.factory.annotation.Autowired
    public ListarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> listarGet() {
    	String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	
        	JsonApiBodyResponseErrors ResponseError = new JsonApiBodyResponseErrors();
            List<RegistrarRequest> negocios = (List<RegistrarRequest>) personaRepository.findAll();
            JsonApiBodyRequest body = new JsonApiBodyRequest();
            body.setNegocio(negocios);
            
            if (negocios.isEmpty()) {
            	ResponseError.setCodigo("1");
            	ResponseError.setDetalle("No hay negocios en la BD");
            	return new ResponseEntity<JsonApiBodyResponseErrors>(ResponseError, HttpStatus.FAILED_DEPENDENCY);
            	
            }else {
            	return new ResponseEntity<JsonApiBodyRequest>(body, HttpStatus.OK);
            	
            }
        }

        return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<?> listarIdadminIdadminGet(@ApiParam(value = "ID del admin",required=true) @PathVariable("idadmin") String idadmin) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	
        	JsonApiBodyResponseErrors responseError = new JsonApiBodyResponseErrors();
            List<RegistrarRequest> negocios = personaRepository.findByIdadmin(idadmin);
           
            if(idadmin == null || negocios.isEmpty()) {
            	responseError.setCodigo("2323");
            	responseError.setDetalle("Id_admin no ingresado o no existe");
            	return new ResponseEntity<JsonApiBodyResponseErrors> (responseError, HttpStatus.NOT_IMPLEMENTED);
            }
            
            JsonApiBodyRequest body = new JsonApiBodyRequest();
            body.setNegocio(negocios);
            return new ResponseEntity<JsonApiBodyRequest>(body, HttpStatus.OK);
            
        }

        return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<?> listarIdnegocioIdnegocioGet(@ApiParam(value = "id de negocio a retornar",required=true) @PathVariable("idnegocio") String idnegocio) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	JsonApiBodyResponseErrors responseError = new JsonApiBodyResponseErrors();   		
                RegistrarRequest negocio = personaRepository.findOne(idnegocio);
             
                if(idnegocio == null || negocio == null) {
                	responseError.setCodigo("2222");
                	responseError.setDetalle("Id_negocio no ingresado o no existe");
                	return new ResponseEntity<JsonApiBodyResponseErrors> (responseError, HttpStatus.NOT_IMPLEMENTED);
                }
                
                JsonApiBodyRequest body = new JsonApiBodyRequest();
                List<RegistrarRequest> lista = new ArrayList<RegistrarRequest>();
                lista.add(negocio);
                body.setNegocio(lista);
                return new ResponseEntity<JsonApiBodyRequest>(body, HttpStatus.OK);
        		
        	
        	
        
        }
        return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<?> listarTiponegocioTiponegocioGet(@ApiParam(value = "tipo de negocio a retornar",required=true) @PathVariable("tiponegocio") String tiponegocio) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	JsonApiBodyResponseErrors responseError = new JsonApiBodyResponseErrors();   		
            List<RegistrarRequest> negocios = personaRepository.findByTiponegocio(tiponegocio);
         
            if(tiponegocio == null || negocios.isEmpty()) {
            	responseError.setCodigo("256");
            	responseError.setDetalle("Tipo negocio no ingresado o no existe");
            	return new ResponseEntity<JsonApiBodyResponseErrors> (responseError, HttpStatus.NOT_IMPLEMENTED);
            }
            
            JsonApiBodyRequest body = new JsonApiBodyRequest();     
            body.setNegocio(negocios);
            return new ResponseEntity<JsonApiBodyRequest>(body, HttpStatus.OK);
    		
    	
    	
    
    }
    return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
    }

}
