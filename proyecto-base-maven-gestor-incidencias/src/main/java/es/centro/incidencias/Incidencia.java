package es.centro.incidencias;

import java.util.Locale;
/**
 * Representa un incidencia
 * contiene informacion especifica como: id, titulo, prioriad, abierta
 * @author Rosiangie.nicol.orti
 * @version 1.0.0
 * */


public final class Incidencia {
    /**
     * Atributo tipo cadena de caracyeres que representa de identificador de el objeto
     **/
    private final String id;
    /**
     * Atributo tipo cadena de caracteres que da nombre al objeto
     **/
    private final String titulo;
    /**
     * Atributo tipo cadena de texto que representa la prioridad del objeto
     **/
    private final String prioridad;
    /**
     * Atributo tde tipo logico que representa si la incidencia esta abierta o no
     **/
    private final boolean abierta;

    /**
     * @param abierta
     * @param id
     * @param prioridad
     * @param titulo **/


    /**
     * Crea un nueva instancia de la clase Incidencia con un id, titulo, prioridad y status representado con abierta
     * @param id numero que representa la numeración de la instacia
     * @param titulo representa el nombre de instacia
     * @param prioridad representa la prioridad de la instancia
     * @param abierta representa si la incidencia esta abieta o no
     *  **/
    public Incidencia(String id, String titulo, String prioridad, boolean abierta) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.abierta = abierta;
    }
    /**
     * Obtiene el numero del id
     * @return el id de la intancia
     * **/
    public String getId() {
        return id;
    }
    /**
     * Obtiene el titulo de la instancia
     * @return  el titulo actual d ela instacia**/
    public String getTitulo() {
        return titulo;
    }
    /**
     * Obtiene el grado de priorioridad
     * @return el grado de prioridad actual
     * **/
    public String getPrioridad() {
        return prioridad;
    }
    /**
     * Obtiene un valor booleano que representa si esta abieta o no la incidencia
     * @return  el estado de la incidencia**/
    public boolean isAbierta() {
        return abierta;
    }
    /**
     * Obtiene una cadena de caracteres
     * @return  la comprobación de coincidencia entre una incidenia y otra
     * **/
    public boolean coincideCon(String texto) {
        String criterio = texto.toLowerCase(Locale.ROOT);
        return id.toLowerCase(Locale.ROOT).contains(criterio)
                || titulo.toLowerCase(Locale.ROOT).contains(criterio);
    }

}
