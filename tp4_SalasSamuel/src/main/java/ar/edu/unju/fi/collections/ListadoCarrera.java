package ar.edu.unju.fi.collections;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Carrera;
public class ListadoCarrera {
	private static List<Carrera> carreras = new ArrayList<>();

    public static List<Carrera> listarCarreras() {
    	Predicate<Carrera> activo = n -> n.getEstado();
        List<Carrera> carrerasActivas = carreras.stream().filter(activo).collect(Collectors.toList());
        return carrerasActivas;
    }

    public static Carrera buscarCarrera(String cod) {
        for (Carrera carrera : carreras) {
            if (carrera.getCodigo().equals(cod)) {
                return carrera;
            }
        }
        return null;
    }

    public static void agregarCarrera(Carrera c) {
        carreras.add(c);
    }

    public static void modificarCarrera(Carrera c) {
        c.setEstado(true);
        for (int i = 0; i < carreras.size(); i++) {
            Carrera carrera = carreras.get(i);
            if (carrera.getCodigo().equals(c.getCodigo())) {
                carreras.set(i, c);
                break;
            }
        }
    }

    public static void eliminarCarrera(String cod) {
        for (Carrera carrera : carreras) {
            if (carrera.getCodigo().equals(cod)) {
                carrera.setEstado(false);
                break;
            }
        }
    }
}