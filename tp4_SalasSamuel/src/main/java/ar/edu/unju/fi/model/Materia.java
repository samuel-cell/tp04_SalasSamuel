package ar.edu.unju.fi.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Materia {
	private String codigo;
	private String nombre;
	private String curso;
	private String modalidad;
	
	@Autowired
	private Docente docete;
	
	@Autowired
	private Carrera carrera;
	
	public Materia() {
	}
	
	public Materia(String codigo, String nombre, String curso, Carrera carrera, String modalidad, Docente docente) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.carrera = carrera;
		this.modalidad = modalidad;
		this.docete = docente;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public Docente getDocente() {
		return docete;
	}

	public void setDocente(Docente docente) {
		this.docete = docente;
	}
}