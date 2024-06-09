package ar.edu.unju.fi.collections;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Alumno;
public class ListadoAlumno {
	private static List<Alumno> alumnos = new ArrayList<>();

	public static List<Alumno> listarAlumnosActivos() {
	    Predicate<Alumno> activo = n -> !"-1".equals(n.getDni());
	    return alumnos.stream().filter(activo).collect(Collectors.toList());
	}

    public static Alumno buscarAlumno(String dni) {
        for (Alumno alumno : alumnos) {
            if (alumno.getDni().equals(dni)) {
                return alumno;
            }
        }
        return null;
    }

    public static void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public static void modificarAlumno(Alumno alumno) {
        for (int i = 0; i < alumnos.size(); i++) {
            Alumno alumnoActual = alumnos.get(i);
            if (alumnoActual.getDni().equals(alumno.getDni())) {
                alumnos.set(i, alumno);
                break;
            }
        }
    }

    public static void eliminarAlumno(String dni) {
	    alumnos.removeIf(alumno -> alumno.getDni().equals(dni));
	}
}