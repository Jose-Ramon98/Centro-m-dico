package com.medico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.medico.model.Profesionales;
import com.medico.model.Usuario;
import com.medico.service.IProfesionales;



@Controller

public class SaludController {
	
	@Autowired
	private IProfesionales profesionales;

	@GetMapping("/")
	public String Inicio(Model model) {
//model.addAttribute es un método de la clase Model en Spring MVC que se utiliza para agregar un objeto al modelo, 
//de manera que pueda ser utilizado en la vista//  Por ejemplo, si queremos mostrar una lista de productos en una página 
	    model.addAttribute("usuario", new Usuario());
	    return "inicio";
	}
//imaginemos que queremos crear un formulario para que los usuarios se registren en una página web. Podemos crear un objeto de modelo que
// represente al usuario, con atributos como "nombre", "correo electrónico", etc.  Luego, utilizamos la anotación @ModelAttribute
//para pasar ese objeto de modelo al formulario HTML ...{usuario.nombre}
	@RequestMapping(value = "/adelante", method = {RequestMethod.GET, RequestMethod.POST})
	
	
	public String adelante(@ModelAttribute("usuario") Usuario usuario){// se debe indicar la clase, sino da error
	    return "adelante";
	}
	@GetMapping("/especialidad")
//Imagina que estás en una tienda de dulces y le pides al dependiente que te dé un caramelo. El dependiente te pregunta "¿qué sabor de caramelo
//te gustaría?". Tú respondes "quiero un caramelo de fresa, por favor".En este caso, "sabor de caramelo" es como un "request param".
// un "request param". Es una información adicional que se le proporciona al dependiente para que pueda darte exactamente lo que estás buscando.	
	public String mostrarProfesionalesPorEspecialidad(@RequestParam Integer especialidad, Model model) {
// se inicializa con un valor vacío "" es para evitar problemas de referencia nula o "null pointer exceptions" en caso de que la 
//variable no se inicialice antes del switch statement.	    
		String nombreEspecialidad = "";
	    switch (especialidad) {
	        case 1:
	            nombreEspecialidad = "Odontología";
	            break;
	        case 2:
	            nombreEspecialidad = "Cardiología";
	            break;
	        case 3:
	            nombreEspecialidad = "Dermatología";
	            break;
	        case 4:
	            nombreEspecialidad = "Familiar";
	            break;
	        default:
	            nombreEspecialidad = "Especialidad no encontrada";
	            break;
	    }
	    List<Profesionales> profesionalesPorEspecialidad = profesionales.findByEspecialidad(especialidad);
	    model.addAttribute("profesionales", profesionalesPorEspecialidad);
	    
	    
	    model.addAttribute("nombreEspecialidad", nombreEspecialidad);
	    return "mostrarProfesionales";
	}

	
	@GetMapping("/descripcion")
	public String mostrarTabla(Model model){
	
		
		
		List<Profesionales> lista = profesionales.findAll();// serviceVacante declarado en el autowired de arriba (podriamos haberle puesto otro nombre) 
														   // buscarTodas viene de la clase interfaz que es esta linea de codigo  
		                                                   //List<Vacante> buscarTodas();
		
		
		model.addAttribute("profesionales", lista);//Agregamos una lista de tipos vacantes, obtenida gracias metodo getVacantes
		return "descripcion";
		
	}
	


}    