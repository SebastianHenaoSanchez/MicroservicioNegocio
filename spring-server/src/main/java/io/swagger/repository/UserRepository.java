package io.swagger.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


import io.swagger.model.RegistrarRequest;

@EnableScan
public interface UserRepository extends CrudRepository<RegistrarRequest, String>{
	//public List<RegistrarRequest> findByEmail(String email);
	public List<RegistrarRequest> findByIdadmin(String idadmin);
	public List<RegistrarRequest> findByIdnegocio(String idnegocio);
	public List<RegistrarRequest> findByTiponegocio(String tiponegocio);
}
