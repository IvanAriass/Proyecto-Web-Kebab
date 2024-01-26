package com.kebab.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kebab.spring.modelo.Usuarios;
import com.kebab.spring.repositorios.UsuariosRepository;

@Service("usuariosServiceDB")
public class UsuariosServiceDB {

	
	@Autowired
	private UsuariosRepository repositorio;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public Usuarios add(Usuarios e) {
		e.setContraseña(passwordEncoder.encode(e.getContraseña()));
		return repositorio.save(e);
	}
	
	public List<Usuarios> findAll() {
		return repositorio.findAll();
	}
	
	public Usuarios findById(long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Usuarios findFirstByEmail(String email) {
		return repositorio.findFirstByEmail(email);
	}

}
