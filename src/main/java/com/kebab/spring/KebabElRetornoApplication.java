package com.kebab.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kebab.spring.modelo.Categorias;
import com.kebab.spring.modelo.Productos;
import com.kebab.spring.modelo.Usuarios;
import com.kebab.spring.servicios.CategoriasServiceDB;
import com.kebab.spring.servicios.ProductosServiceDB;
import com.kebab.spring.servicios.UsuariosServiceDB;

@SpringBootApplication
public class KebabElRetornoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KebabElRetornoApplication.class, args);
	}

	
	@Bean
	CommandLineRunner initData(UsuariosServiceDB service, ProductosServiceDB Sproductos, CategoriasServiceDB Scategorias) {
		
		return (args) -> {
//			List<Categorias> listaC = new ArrayList<Categorias>();
//			List<Categorias> listaB = new ArrayList<Categorias>();
//			List<Categorias> listaF = new ArrayList<Categorias>();
//			
//			Usuarios usuario = new Usuarios("Ivan", "Arias Pastor","ivanarias@example.com", "123", "Admin", "123456789", "asfdaf", "123456789");
//			service.add(usuario);
//			
//			usuario = new Usuarios("Rosa", "Melendez Abaat","rosamelendez@example.com", "123", "Usuario", "987654321", "asfdaf", "123456789");
//			service.add(usuario);
//			
//			Categorias categorias = new Categorias("Rollo");
//			listaC.add(categorias);
//			Scategorias.add(categorias);
//			
//			categorias = new Categorias("Box");
//			listaB.add(categorias);
//			Scategorias.add(categorias);
//			
//			categorias = new Categorias("Falafel");
//			listaF.add(categorias);
//			Scategorias.add(categorias);
//			
//			Productos productos = new Productos("Ternera", "Ternera, Cebolla, Olivas, Oregáno, Lechuga, Salsa de Yogur", 3.5, " ", listaC);
//			Sproductos.add(productos);
//			productos = new Productos("Pollo", "Pollo, Cebolla, Olivas, Oregáno, Lechuga, Salsa de Yogur", 3.5, " ", listaC);
//			Sproductos.add(productos);
//			productos = new Productos("Mixto", "Pollo, Ternera, Cebolla, Olivas, Oregáno, Lechuga, Salsa de Yogur", 4, " ", listaC);
//			Sproductos.add(productos);
//			
//			productos = new Productos("Ternera", "Ternera, Patatas, Arroz Cebolla, Olivas, Oregáno, Lechuga, Salsa de Yogur", 4, " ", listaB);
//			Sproductos.add(productos);
//			productos = new Productos("Pollo", "Pollo, Patatas, Arroz, Cebolla, Olivas, Oregáno, Lechuga, Salsa de Yogur", 4, " ", listaB);
//			Sproductos.add(productos);
//			productos = new Productos("Mixto", "Pollo, Ternera, Patatas, Arroz, Cebolla, Olivas, Oregáno, Lechuga, Salsa de Yogur", 4, " ", listaB);
//			Sproductos.add(productos);
//			
//			productos = new Productos("Tradicional", "Garbanzos, Cebolla, Perejil, Cilantro, Pan rayado, Comino, Sal, Pimienta, Ajo picado", 4, " ", listaF);
//			Sproductos.add(productos);
//			productos = new Productos("Vegano", "Garbanzos, Perejil, Ajo picado, Chalotas, Semillas de sésamo, Comino, Sal, Harina", 4, " ", listaF);
//			Sproductos.add(productos);
			
			
		};
	}
}
