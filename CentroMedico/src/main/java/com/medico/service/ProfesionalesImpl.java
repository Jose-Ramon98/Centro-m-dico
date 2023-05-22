package com.medico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medico.entity.ProfesionalesDao;
import com.medico.model.Profesionales;


@Service
public class ProfesionalesImpl implements IProfesionales{

	
	
	
	@Autowired
	private ProfesionalesDao iProfesionales;
	
	@Autowired
	private IProfesionales iprofesionales;
	
	
		@Override
	 @Transactional(readOnly = true)
	public List<Profesionales> findAll() {
	    return (List<Profesionales>) iProfesionales.findAll();
	 }
		@Override
	 @Transactional
	    public void save(Profesionales profesionales) {
	    	iProfesionales.save(profesionales);
	    }
		@Override
	 @Transactional(readOnly = true)
	 public Profesionales findOne(Integer id) {
		 return iProfesionales.findById(id).orElseThrow(null);//muy importante este orElseThrow
	 }
		@Override
	 @Transactional
	 public void delete(Integer id) {
		 iProfesionales.deleteById(id);
	 }
		@Override
		 @Transactional(readOnly = true)
		public List<Profesionales> findByEspecialidad(Integer especialidad) {
		
			return iProfesionales.findByEspecialidad(especialidad);
		}
		@Override
		@Transactional
		public List<Profesionales> findById(Integer id) {
		    // TODO Auto-generated method stub
		    return null;
		}
		@Override
		public List<Profesionales> findByDescripcion(String descripcion) {
			return iProfesionales.findByDescripcion(descripcion);
		}
		
		
		
		
		@Override
		public Profesionales buscarPorid(Integer idVacante) {
			// TODO Auto-generated method stub
			return null;
		}
		

	
	 
	 		
}

