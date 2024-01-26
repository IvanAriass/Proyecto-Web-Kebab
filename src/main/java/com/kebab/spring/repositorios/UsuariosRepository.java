package com.kebab.spring.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kebab.spring.modelo.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{

	
	List<Usuarios> findByNombreContainsIgnoreCaseOrEmailContainsIgnoreCaseOrTelefonoContainsIgnoreCase(String nombre, String email, String telefono);
	
	@Query("select e from Usuarios e where lower(e.nombre) like %?1% or lower(e.email) like %?1% or lower(e.telefono) like %?1%")
	List<Usuarios> encuentraPorNombreEmailOTelefono(String cadena);
	
	@Query(value="SELECT * FROM USUARIOS WHERE LOWER(NOMBRE) LIKE CONCAT('%',?1,'%') OR LOWER(TELEFONO) LIKE CONCAT('%',?1,'%')", nativeQuery=true)
	List<Usuarios> encuentraPorNombreEmailOTelefonoNativa(String cadena);
	
	Usuarios findFirstByEmail(String cadena);
}
