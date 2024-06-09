package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarrera;
import ar.edu.unju.fi.model.Carrera;

@Controller
public class CarreraController {
	@Autowired
	Carrera carrera;

	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
	    return new ModelAndView("formCarrera", "nuevaCarrera", new Carrera());
	}
	
	@PostMapping("/guardarCarrera")
	public String setFormCarrera(@ModelAttribute("nuevaCarrera") Carrera c) {
	    ListadoCarrera.agregarCarrera(c);
	    return "redirect:/formularioCarrera";
	}
	
	@GetMapping("/listaDeCarreras")
	public ModelAndView mostrarLista() {
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", ListadoCarrera.listarCarreras());
	
		return modelView;
	}
	
	@GetMapping("/eliminarCarrera/{codigo}")
	public String eliminarCarrera(@PathVariable(name = "codigo") String cod) {
	    ListadoCarrera.eliminarCarrera(cod);
	    return "redirect:/listaDeCarreras";
	}
	
	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView formModificarCarrera(@PathVariable("codigo") String cod) {
		carrera = ListadoCarrera.buscarCarrera(cod);
		
		ModelAndView modelView = new ModelAndView("modificarCarrera");
		modelView.addObject("carreraModificada", carrera);
	
		return modelView;
	}
	
	@PostMapping("/modificarCarrera")
	public String modificarCarrera(@ModelAttribute("carreraModificada") Carrera c) {
	    ListadoCarrera.modificarCarrera(c);
	    return "redirect:/listaDeCarreras";
	}
}