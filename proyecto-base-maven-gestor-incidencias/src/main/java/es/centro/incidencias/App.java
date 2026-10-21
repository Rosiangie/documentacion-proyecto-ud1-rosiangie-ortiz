package es.centro.incidencias;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que pone en marcha la aplicacion incidencias
 * <p>
 *     Se encraga inicializar incidencias  y ejecutar sus metodos
 * </p>>
 * @author Rosiangie.nicol.orti
 * @version 1.0.1**/

public final class App {

    private App() {
    }
    /**
     * Punto de entrada principal de la aplicación.
     *
     * @param args los argumentos de la línea de comandos (no se requieren parámetros actualmente)
     */

    public static void main(String[] args) {
        GestorIncidencias gestor = new GestorIncidencias();

        if (args.length == 0) {
            ejecutarMenuInteractivo(gestor);
            return;
        }

        if ("ayuda".equalsIgnoreCase(args[0])) {
            mostrarAyuda();
            return;
        }

        String operacion = args[0].toLowerCase();
        switch (operacion) {
            case "listar" -> mostrar(gestor.listar());
            case "abiertas" -> mostrar(gestor.listarAbiertas());
            case "buscar" -> buscar(args, gestor);
            case "detalle" -> mostrarDetalle(args, gestor);
            default -> {
                System.out.println("Operación desconocida: " + args[0]);
                mostrarAyuda();
            }
        }
    }
/**
 * Metodo void que recibe el gestor de incidencias inicializado y se encarga de mostrarlo por consola
 * @param gestor es un atributo tipo lista de incidencias ya inicializado al inicio de programa
 *
 * **/
    private static void ejecutarMenuInteractivo(GestorIncidencias gestor) {
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("GESTOR DE INCIDENCIAS");
        System.out.println("Aplicación de consulta de avisos de soporte del centro.");

        while (continuar) {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");

            if (!entrada.hasNextLine()) {
                return;
            }

            String opcion = entrada.nextLine().trim();
            System.out.println();

            switch (opcion) {
                case "1" -> mostrar(gestor.listar());
                case "2" -> mostrar(gestor.listarAbiertas());
                case "3" -> buscarDesdeMenu(entrada, gestor);
                case "4" -> mostrarDetalleDesdeMenu(entrada, gestor);
                case "0" -> {
                    continuar = false;
                    System.out.println("Aplicación finalizada.");
                }
                default -> System.out.println("La opción indicada no es válida.");
            }

            System.out.println();
        }
    }
    /**
     * Metodo encarga de mostrar un menu con las opciones del programa
     * **/
    private static void mostrarMenu() {
        System.out.println("----------------------------------------");
        System.out.println("1. Mostrar todas las incidencias");
        System.out.println("2. Mostrar las incidencias abiertas");
        System.out.println("3. Buscar incidencias");
        System.out.println("4. Consultar una incidencia por su ID");
        System.out.println("0. Salir");
        System.out.println("----------------------------------------");
    }
    /**Metodo encargado de buscar desde menu el texto introducido
     * @param entrada atributo tipo entrada para leer texto introducido por usuario
     * @param gestor atributo tipo gestor de incidencias
     * **/
    private static void buscarDesdeMenu(Scanner entrada, GestorIncidencias gestor) {
        System.out.print("Texto que deseas buscar: ");
        String texto = entrada.hasNextLine() ? entrada.nextLine().trim() : "";

        if (texto.isBlank()) {
            System.out.println("Debes introducir algún texto.");
            return;
        }

        mostrar(gestor.buscar(texto));
    }
    /**Metodo que muestra el detalle del menu
     * @param entrada atributo tipo entrada para leer texto introducido por usuario
     * @param gestor atributo tipo gestor de incidencias
     * **/

    private static void mostrarDetalleDesdeMenu(Scanner entrada, GestorIncidencias gestor) {
        System.out.print("Identificador de la incidencia: ");
        String id = entrada.hasNextLine() ? entrada.nextLine().trim() : "";

        if (id.isBlank()) {
            System.out.println("Debes introducir un identificador.");
            return;
        }

        mostrarDetalle(id, gestor);
    }

    /**
     * Busca incidencias que contengan un texto específico en el sistema.
     * <p>
     * El método extrae el texto de búsqueda combinando todos los argumentos
     * a partir de la posición 1. Si no se proporciona ningún término de búsqueda,
     * muestra un mensaje de advertencia y cancela la operación.
     * </p>
     *
     *
     * @param args los argumentos de la línea de comandos, donde args[1] y siguientes
     *             componen el texto a buscar
     * @param gestor la instancia del gestor de incidencias que realiza la búsqueda
     */

    private static void buscar(String[] args, GestorIncidencias gestor) {
        if (args.length < 2) {
            System.out.println("Debes indicar el texto que deseas buscar.");
            return;
        }

        String texto = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
        mostrar(gestor.buscar(texto));
    }
    /**
     * Procesa los argumentos de la línea de comandos para mostrar el detalle de una incidencia.
     *
     * @param args los argumentos de la línea de comandos, donde {@code args[1]} debe ser
     *             el identificador de la incidencia
     * @param gestor la instancia del gestor de incidencias utilizada para recuperar los datos
     */

    private static void mostrarDetalle(String[] args, GestorIncidencias gestor) {
        if (args.length < 2) {
            System.out.println("Debes indicar el identificador de la incidencia.");
            return;
        }

        mostrarDetalle(args[1], gestor);
    }
    /**
     * Metodo que muestra detalle de incidencia si encuentra una coincidencia
     * * <p>
     * Este método intenta recuperar la incidencia. Si no se encuentra ninguna, se captura la
     * excepción {@link IncidenciaNoEncontradaException} de forma interna para mostrar el mensaje de
     *error por la consola.
     * </p>
     * @param id elemento String que representa el codigo unico que identifica una objeto incidencia
     * @param gestor elemto tipo GestosIncidencia que representa una lista de incidencia con acceso a metodos para gestionarlas
     *
     */

    private static void mostrarDetalle(String id, GestorIncidencias gestor) {
        try {
            System.out.println(gestor.buscarPorId(id));
        } catch (IncidenciaNoEncontradaException excepcion) {
            System.out.println(excepcion.getMessage());
        }
    }
    /**
     * Metodo que muestra un listado en incidencias, si el parametro que se le pasa no esta vacío
     * @param incidencias valor de tipo Listado de incidencias
     **/
    private static void mostrar(List<Incidencia> incidencias) {
        if (incidencias.isEmpty()) {
            System.out.println("No se han encontrado incidencias.");
            return;
        }
        incidencias.forEach(System.out::println);
    }
    /**
     * Metodo encargado de Mostrar una breve esplicacion de los opciones que tiene el usuario
     * **/
    private static void mostrarAyuda() {
        System.out.println("Gestor de incidencias");
        System.out.println("  ayuda              Muestra esta ayuda");
        System.out.println("  listar              Muestra todas las incidencias");
        System.out.println("  abiertas            Muestra las incidencias abiertas");
        System.out.println("  buscar <texto>      Busca por identificador o título");
        System.out.println("  detalle <id>        Muestra una incidencia");
    }
}
