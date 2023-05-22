package com.medico.entity;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.model.Profesionales;



public interface ProfesionalesDao extends PagingAndSortingRepository<Profesionales, Integer>{

	public  List<Profesionales> findByEspecialidad(Integer especialidad);
	public  List<Profesionales> findByDescripcion(String descripcion);
	
	
	
}
