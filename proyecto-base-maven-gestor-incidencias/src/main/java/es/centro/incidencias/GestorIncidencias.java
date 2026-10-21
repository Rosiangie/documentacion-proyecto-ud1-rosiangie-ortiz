package es.centro.incidencias;

import java.util.List;
/**
 * Representa un gestor de incidencias y contiene una lista de incidencias
 * @author Rosiangie.nicol.orti
 * @version 1.0.0
 * **/
public final class GestorIncidencias {
    /**
     * Atributo tipo List que es una listra de objetos de tipo incidencia**/
    private final List<Incidencia> incidencias;
/**
 * Crea un Objeto gestor de incidencias que inicializa una lista objetos de tipo incidencia
 * @param
 * **/
    public GestorIncidencias() {
        incidencias = List.of(
                new Incidencia("INC-001", "No se puede iniciar sesión", "alta", true),
                new Incidencia("INC-002", "Actualizar el navegador", "media", false),
                new Incidencia("INC-003", "Impresora sin conexión", "baja", true),
                new Incidencia("INC-004", "Fallo de red en el aula", "alta", true)
        );
    }

    public List<Incidencia> listar() {
        return incidencias;
    }

    public List<Incidencia> listarAbiertas() {
        return incidencias.stream()
                .filter(Incidencia::isAbierta)
                .toList();
    }

    public List<Incidencia> buscar(String texto) {
        return incidencias.stream()
                .filter(incidencia -> incidencia.coincideCon(texto))
                .toList();
    }

    public Incidencia buscarPorId(String id) throws IncidenciaNoEncontradaException {
        return incidencias.stream()
                .filter(incidencia -> incidencia.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new IncidenciaNoEncontradaException(id));
    }

    @Deprecated(since = "1.0.0", forRemoval = false)
    public Incidencia obtenerIncidencia(String id) {
        try {
            return buscarPorId(id);
        } catch (IncidenciaNoEncontradaException excepcion) {
            return null;
        }
    }
}
