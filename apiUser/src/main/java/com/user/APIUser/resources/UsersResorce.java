package com.user.APIUser.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.APIUser.repository.EmailRepository;
import com.user.APIUser.repository.FunctionalityRepository;
import com.user.APIUser.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.user.APIUser.models.Users;
import com.user.APIUser.models.Functionality;
@RestController
@RequestMapping(value = "/api")
@Api(value="API REST teste React-it")
@CrossOrigin(origins="*")

public class UsersResorce {

		
		@Autowired
		UserRepository userRepository;
		EmailRepository emailRepository;

		
		@GetMapping("/users")
		@ApiOperation(value = "Retorna uma lista de usuarios")
		public List<Users> ListaUsuarios(){
			return userRepository.findAll();
		}
		
		@GetMapping("/user/{id}")
		@ApiOperation(value = "Retorna um unico usuario")
		public Users ListaUnicoUsuario(@PathVariable(value="id")long id, @AuthenticationPrincipal UserDetails userDetails){
			return userRepository.findById(id);
		}
		
		@PostMapping("/user")
		@ApiOperation(value = "Salva novo usuario")
		public Users salvaUsuario(@RequestBody Users users) {
			return userRepository.save(users);
		}
		
		@DeleteMapping("/user")
		@PreAuthorize("hasRole('ADMIN')")
		@ApiOperation(value = "Deleta um usuario")
		public void deletaUsuario(@RequestBody Users users) {
			userRepository.delete(users);
		}
		
		
		@PutMapping("/user")
		@PreAuthorize("hasRole('ADMIN')")
		@ApiOperation(value = "Atualiza usuarios")
		public Users atualizaUsuario(@RequestBody Users users) {
			return userRepository.save(users);
		}
		
	/*	@Autowired
		FunctionalityRepository functionalityRepository;
		
		@GetMapping("/functionalitys")
		@ApiOperation(value = "Retorna uma lista de funcionalidades")
		public List<Functionality> ListaFuncionalidade(){
			return functionalityRepository.findAll();
		}
		
		@GetMapping("/functionality/{id}")
		@ApiOperation(value = "Retorna uma unica funcionalidade")
		public Functionality ListaUnicaFuncionalidade(@PathVariable(value="id")long id){
			return functionalityRepository.findById(id);
		}
		
		@PostMapping("/functionality")
		@ApiOperation(value = "Salva uma nova funcionalidade")
		public Functionality salvaFuncionalidade(@RequestBody Functionality functionality) {
			return functionalityRepository.save(functionality);
		}

		@DeleteMapping("/functionality")
		@ApiOperation(value = "Deleta uma funcionalidade")
		public void deletaFuncionalidade(@RequestBody Functionality functionality) {
			functionalityRepository.delete(functionality);
		}
		
		@PutMapping("/functionality")
		@ApiOperation(value = "Atualiza uma funcionalidade")
		public Functionality atualizaFuncionalidade(@RequestBody Functionality functionality) {
			return functionalityRepository.save(functionality);
			
		}*/
}
