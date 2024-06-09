package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarrera;
import ar.edu.unju.fi.collections.ListadoDocente;
import ar.edu.unju.fi.collections.ListadoMateria;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;


@Controller
public class MateriaController {
	@Autowired
	Materia materia = new Materia();
	
	@Autowired
	Docente docente = new Docente();
	
	@Autowired
	Carrera carrera = new Carrera();
	
	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		
		ModelAndView modelView = new ModelAndView("formMateria");
		
		modelView.addObject("nuevaMateria", materia);
		modelView.addObject("carreras", ListadoCarrera.listarCarreras());
		modelView.addObject("docentes", ListadoDocente.listarDocentesActivos());
		
		return modelView;
	}
	
	@PostMapping("/guardarMateria")
	public ModelAndView setFormMateria(@ModelAttribute("nuevaMateria") Materia m) {
	    docente = ListadoDocente.buscarDocente(m.getDocente().getLegajo());
	    carrera = ListadoCarrera.buscarCarrera(m.getCarrera().getCodigo());
	    m.setCarrera(carrera);
	    m.setDocente(docente);
	    ListadoMateria.agregarMateria(materia);
	    return mostrarLista();
	}
	
	@GetMapping("/eliminarMateria/{codigo}")
	public ModelAndView eliminarMateria(@PathVariable (name="codigo") String cod) {
		
		ListadoMateria.eliminarMateria(cod);
		
		return mostrarLista();
	}
	
	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView formModificarMateria(@PathVariable("codigo") String cod) {
		materia = ListadoMateria.buscarMateria(cod);
		
		ModelAndView modelView = new ModelAndView("modificarMateria");
		
		modelView.addObject("materiaModificada", materia);
		modelView.addObject("carreras", ListadoCarrera.listarCarreras());
		modelView.addObject("docentes", ListadoDocente.listarDocentesActivos());
		
		return modelView;
	}
	
	@PostMapping("/modificarMateria")
	public ModelAndView modificarMateria(@ModelAttribute("materiaModificada") Materia m) {
	    docente = ListadoDocente.buscarDocente(m.getDocente().getLegajo());
	    carrera = ListadoCarrera.buscarCarrera(m.getCarrera().getCodigo());
	    m.setCarrera(carrera);
	    m.setDocente(docente);
	    ListadoMateria.modificarMateria(m);
	    return mostrarLista();
	}
	
	@GetMapping("/listaDeMaterias")
	public ModelAndView mostrarLista() {
	    ModelAndView modelView = new ModelAndView("listaDeMaterias");
	    modelView.addObject("listadoMaterias", ListadoMateria.listarMateriasActivas());
	    return modelView;
	}
}