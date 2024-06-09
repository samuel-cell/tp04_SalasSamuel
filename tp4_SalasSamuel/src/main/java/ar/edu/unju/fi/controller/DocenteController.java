package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDocente;
import ar.edu.unju.fi.model.Docente;

@Controller
public class DocenteController {
	@Autowired
    Docente docente;
	
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		ModelAndView modelView = new ModelAndView("formDocente");
		modelView.addObject("nuevoDocente", docente);
	
		return modelView;
	}
	
	@PostMapping("/guardarDocente")
    public ModelAndView setFormDocente(@ModelAttribute("nuevoDocente") Docente nuevoDocente) {
        ListadoDocente.agregarDocente(nuevoDocente);

        return new ModelAndView("redirect:/listaDeDocentes");
    }
	
	@GetMapping("/eliminarDocente/{legajo}")
	public ModelAndView eliminarDocente(@PathVariable (name="legajo") int legajo) {
		
		ListadoDocente.eliminarDocente(legajo);
		
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocente.listarDocentesActivos());
		
		return modelView;
	}
	
	@GetMapping("/modificarDocente/{legajo}")
    public ModelAndView formModificarDocente(@PathVariable("legajo") int legajo) {
        docente = ListadoDocente.buscarDocente(legajo);

        ModelAndView modelView = new ModelAndView("modificarDocente");
        modelView.addObject("docenteModificado", docente);
        
        return modelView;
    }

    @PostMapping("/modificarDocente")
    public ModelAndView modificarDocente(@ModelAttribute("docenteModificado") Docente d) {

        ListadoDocente.modificarDocente(d);
        
        return mostrarLista();
    }
	
	@GetMapping("/listaDeDocentes")
	public ModelAndView mostrarLista() {
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocente.listarDocentesActivos());
	
		return modelView;
	}
}