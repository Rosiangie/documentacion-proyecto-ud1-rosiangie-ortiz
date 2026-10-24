# Gestor de incidencias

> Aplicación de consulta de gestor de incidencias.

---

## Descripción general

**Gestor de incidencias** es una aplicación desarrollada en Java diseñada para consultar las incidencias de un centro por distintos atributos de estas como su ID o situación. 

El código está estructurado de manera modular y cuenta con documentación Javadoc completa publicada y accesible en línea.

---

## Documentación y Enlaces

* **Documentación API (Javadoc):** [Ver Javadoc en GitHub Pages](https://Rosiangie.github.io/documentacion-proyecto-ud1-rosiangie-ortiz/)
* **Repositorio oficial:** [GitHub Repository](https://github.com/Rosiangie/documentacion-proyecto-ud1-rosiangie-ortiz.git)

---

## Versión de Java

* **Java Development Kit (JDK):** Versión 25

---

## Funcionalidades de la aplicación

La aplicación permite realizar las siguientes acciones:
* **Búsqueda por ID:** Permite buscar y localizar una incidencia específica dentro de la lista utilizando su identificador único.
* **Consulta de incidencias:** Permite obtener y listar los detalles de las incidencias registradas.
* **Coincidencias por texto:** Evalúa si una incidencia coincide con un texto de búsqueda determinado en sus atributos.
* **Control de excepciones:** Gestiona de forma personalizada los errores cuando se intenta buscar una incidencia que no existe en el sistema (`IncidenciaNoEncontradaException`).

---

## Clases Principales

| Clase | Responsabilidad General |
| :--- | :--- |
| **`GestorIncidencias`** | Administra la colección/lista de incidencias y centraliza la lógica de búsqueda y obtención de elementos. |
| **`Incidencia`** | Representa el modelo de datos de una incidencia individual y gestiona la lógica de coincidencia de textos. |
| **`IncidenciaNoEncontradaException`** | Excepción personalizada lanzada cuando una consulta por ID no devuelve resultados válidos. |

---

##  Estructura de Archivos

```text
proyecto-base-maven-gestor-incidencias/
 ├── src/                           # Código fuente de la aplicación (main y test)
 │    └── main/java/es/centro/incidencias/
 ├── pom.xml                        # Archivo de configuración y dependencias de Maven
 └── README.md                      # Documentación principal del proyecto