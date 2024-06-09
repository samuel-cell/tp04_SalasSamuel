package ar.edu.unju.fi.collections;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Docente;
public class ListadoDocente {
	private static List<Docente> docentes = new ArrayList<>();

    public static List<Docente> listarDocentesActivos() {
        Predicate<Docente> activo = n -> n.getLegajo() != -1;
        return docentes.stream().filter(activo).collect(Collectors.toList());
    }

    public static Docente buscarDocente(int legajo) {
        for (Docente docente : docentes) {
            if (docente.getLegajo() == legajo) {
                return docente;
            }
        }
        return null;
    }

    public static void agregarDocente(Docente docente) {
        docentes.add(docente);
    }

    public static void modificarDocente(Docente docente) {
        for (int i = 0; i < docentes.size(); i++) {
            Docente docenteActual = docentes.get(i);
            if (docenteActual.getLegajo() == docente.getLegajo()) {
                docentes.set(i, docente);
                break;
            }
        }
    }

    public static void eliminarDocente(int legajo) {
        for (Docente docente : docentes) {
            if (docente.getLegajo() == legajo) {
                docente.setLegajo(-1);
                break;
            }
        }
    }
}