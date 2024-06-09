package ar.edu.unju.fi.collections;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Materia;
public class ListadoMateria {
	private static List<Materia> materias = new ArrayList<>();

    public static List<Materia> listarMateriasActivas() {
        Predicate<Materia> activo = n -> !"-1".equals(n.getCodigo());
        return materias.stream().filter(activo).collect(Collectors.toList());
    }

    public static Materia buscarMateria(String codigo) {
        for (Materia materia : materias) {
            if (materia.getCodigo().equals(codigo)) {
                return materia;
            }
        }
        return null;
    }

    public static void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    public static void modificarMateria(Materia materia) {
        for (int i = 0; i < materias.size(); i++) {
            Materia materiaActual = materias.get(i);
            if (materiaActual.getCodigo().equals(materia.getCodigo())) {
                materias.set(i, materia);
                break;
            }
        }
    }

    public static void eliminarMateria(String codigo) {
        for (Materia materia : materias) {
            if (materia.getCodigo().equals(codigo)) {
                materia.setCodigo("-1");
                break;
            }
        }
    }
}