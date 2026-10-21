package es.centro.incidencias;
/**Excepción lanzada cuando se intenta buscar o manipular una incidencia
 * que no existe en el sistema.
 * @author Rosiangie.nicol.orti
 * @version 1.0.1
 * **/
public class IncidenciaNoEncontradaException extends Exception {

    /**
     * @Crea uina nueva excepcion con el identificador de la incidencia
     * @param id es el identificador unico de la incidencia que no se ha encontrado*/


    public IncidenciaNoEncontradaException(String id) {
        super("No existe ninguna incidencia con el identificador " + id + ".");
    }
}
