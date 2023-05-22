package com.medico.service;

import java.util.List;

import com.medico.model.Profesionales;


public interface IProfesionales {

	public List<Profesionales> findAll();
	public void save(Profesionales profesionales);
	public Profesionales findOne(Integer id);
	public void delete(Integer id); 
	public  List<Profesionales> findByEspecialidad(Integer especialidad);
	List<Profesionales> findById(Integer id);
	public  List<Profesionales> findByDescripcion(String descripcion);
	Profesionales buscarPorid(Integer idVacante);
	
	
}
