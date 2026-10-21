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
 * @return lista de incidencias creada
 * **/
    public GestorIncidencias() {
        incidencias = List.of(
                new Incidencia("INC-001", "No se puede iniciar sesión", "alta", true),
                new Incidencia("INC-002", "Actualizar el navegador", "media", false),
                new Incidencia("INC-003", "Impresora sin conexión", "baja", true),
                new Incidencia("INC-004", "Fallo de red en el aula", "alta", true)
        );
    }
    /**
     * Metodo que se encarga de listar las incidenciass
     * @return elemento lista de las incidencias
     * **/
    public List<Incidencia> listar() {
        return incidencias;
    }
    /**
     * Metodo que se encarga de listar las incidencias solo si estan en abiertas
     * @return elemento lista de las incidencias abiertas
     * **/
    public List<Incidencia> listarAbiertas() {
        return incidencias.stream()
                .filter(Incidencia::isAbierta)
                .toList();
    }
    /**
     * Metodo que se encarga buscar la incidencia que coincida con el parametro recibido
     * @param texto String que representa el nombre de una incidencia
     * @return elemento  lista ya inicializado en el contructor que coincida el atributo nombre con el String recibido
     * **/
    public List<Incidencia> buscar(String texto) {
        return incidencias.stream()
                .filter(incidencia -> incidencia.coincideCon(texto))
                .toList();
    }
    /**
     * Metodo que se encarga buscar la incidencia dentro de la lista cuyo id coincida con el atributo ide recibido
     * @param id atributo String que representa el id de una incidencia
     * @return elemento lista de las coincidencias
     * **/

    public Incidencia buscarPorId(String id) throws IncidenciaNoEncontradaException {
        return incidencias.stream()
                .filter(incidencia -> incidencia.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new IncidenciaNoEncontradaException(id));
    }
    /**
     * Metodo que se encarga de buscar por id llamando a la funcion burcarPorId
     * @param id atributo String que representa el id de una incidencia
     * return un lista con los elementos que coincidan
     * @deprecated buscarPorId
     * @thorws IllegalArgumentException si no encuentra un councidencia
     * **/
    @Deprecated(since = "1.0.0", forRemoval = false)
    public Incidencia obtenerIncidencia(String id) {
        try {
            return buscarPorId(id);
        } catch (IncidenciaNoEncontradaException excepcion) {
            return null;
        }
    }
}
