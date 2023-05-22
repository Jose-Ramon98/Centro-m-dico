package com.medico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medico.entity.ProfesionalesDao;
import com.medico.model.Profesionales;
import com.medico.service.IProfesionales;

@Controller
@RequestMapping("/vacantes")
public class Controllers {
	
	@Autowired
	private IProfesionales profesionales;
	
	@Autowired
	private ProfesionalesDao profesionalesDao;
	
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") Integer id, Model model) {
		
	
	Profesionales profesionals = profesionales.findOne(id);
	model.addAttribute("profesionals", profesionals);
	return "detalle";

	
	}
	
	
	
}
