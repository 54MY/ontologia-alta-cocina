
# Ontología - Spring Boot Project

Bienvenido al proyecto **Ontología** desarrollado con **Spring Boot**, **Apache Jena** y **Java 8**. Este proyecto es una demostración de una aplicación web que utiliza **Spring Boot** para la creación de servicios web, y **Apache Jena** para el manejo de ontologías y tecnologías relacionadas con la Web Semántica.

Este proyecto utiliza una ontología personalizada que está integrada en la aplicación para procesar y servir datos semánticos a través de una API RESTful.

## Descripción
Este proyecto es una aplicación demo basada en **Spring Boot** que integra **Apache Jena** para manipular datos RDF y trabajar con ontologías en la web semántica. La ontología utilizada está diseñada para un contexto específico relacionado con el dominio de **ontologías web** y **datos semánticos**. A través de esta aplicación, puedes consultar, procesar y exponer información estructurada desde la ontología mediante **servicios web**.

## Características
- **Spring Boot**: Framework Java para construir aplicaciones de manera rápida y sencilla.
- **Apache Jena**: Framework para trabajar con RDF, SPARQL y ontologías.
- **Web Semántica**: Uso de tecnologías de la Web Semántica para el manejo de datos RDF y SPARQL.
- **API RESTful**: Acceso a la ontología y a los datos semánticos a través de una API RESTful.

## Requisitos Previos

Asegúrate de tener las siguientes herramientas instaladas en tu máquina:

- **Java 8** o superior
- **Apache Maven 3.0** o superior

## Instalación

Sigue estos pasos para clonar y configurar el proyecto en tu máquina local:

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/54MY/ontologia-alta-cocina.git
   ```

2. Navega al directorio del proyecto:
   ```bash
   cd ontologia
   ```

3. Asegúrate de tener las dependencias necesarias de Maven. Si no tienes Maven instalado, puedes instalarlo siguiendo [esta guía de instalación](https://maven.apache.org/install.html).

4. Una vez instalado Maven, ejecuta el siguiente comando para descargar las dependencias:
   ```bash
   mvn clean install
   ```

---

## Compilación

Para compilar el proyecto, solo debes ejecutar el siguiente comando:

```bash
mvn clean package
```

Este comando creará el archivo `ontologia-1.0.0-SNAPSHOT.jar` en el directorio `target/`.

---

## Despliegue

Para ejecutar la aplicación, usa el siguiente comando de Maven:

```bash
mvn spring-boot:run
```

La aplicación se desplegará localmente en el puerto por defecto **8080**. Puedes acceder a la aplicación abriendo tu navegador en la siguiente dirección:

```
http://localhost:8080
```

---

## Endpoints API

Una vez que la aplicación esté en ejecución, podrás interactuar con la ontología a través de los siguientes endpoints RESTful. (Asegúrate de adaptar los endpoints a tu implementación real)

- **GET /ontologia**: Obtiene información básica sobre la ontología cargada.
- **GET /ontologia/query**: Realiza consultas SPARQL a la ontología cargada.

Consulta la documentación de tu API para obtener más detalles sobre los endpoints disponibles. 

---

## Ontología

Este proyecto utiliza una ontología definida para representar datos semánticos en el dominio específico de **Web Semántica**. La ontología está implementada en el proyecto usando **Apache Jena**. El propósito de esta ontología es permitir la representación y consulta eficiente de datos en un formato RDF, lo que facilita su procesamiento y consumo a través de servicios web.

**Características de la Ontología**:
- Utiliza el formato **RDF (Resource Description Framework)**.
- Permite realizar consultas **SPARQL** sobre los datos estructurados.
- Está integrada directamente en la aplicación, lo que permite consultas semánticas a través de los servicios RESTful.

Los datos de la ontología pueden ser consultados a través de la API expuesta por la aplicación, utilizando **SPARQL** para interactuar con el modelo de datos RDF.

### Estructura de la Ontología

- **Clases**: Definición de los tipos de recursos que existen en la ontología.
- **Propiedades**: Definición de las relaciones entre los recursos en la ontología.
- **Consultas SPARQL**: La aplicación permite realizar consultas SPARQL a la ontología para extraer información de manera eficiente.

A través de la API RESTful, puedes realizar consultas sobre la ontología, como obtener recursos específicos, filtrar resultados o realizar análisis sobre los datos semánticos.

---

## Dependencias del Proyecto

- **Spring Boot 2.7.0**: Framework para el desarrollo de aplicaciones web en Java.
- **Apache Jena 3.17.0**: Framework para el procesamiento de RDF y SPARQL.
- **JUnit 5**: Framework para la ejecución de pruebas unitarias.

## Pruebas

Para ejecutar las pruebas unitarias de la aplicación, usa el siguiente comando:

```bash
mvn test
```

Este comando ejecutará las pruebas definidas en el proyecto utilizando **JUnit**.

## Contribuciones

Las contribuciones son bienvenidas. Si tienes alguna mejora o corrección, abre un **issue** o un **pull request**.

1. Haz un **fork** de este repositorio.
2. Crea una rama para tu funcionalidad: `git checkout -b mi-nueva-funcionalidad`.
3. Realiza los cambios y haz commit: `git commit -am 'Agrega nueva funcionalidad'`.
4. Haz push a la rama: `git push origin mi-nueva-funcionalidad`.
5. Abre un **pull request**.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

## Contacto

Si tienes preguntas, no dudes en ponerte en contacto conmigo:

- **Email**: s.veizagarocha@gmail.com
- **GitHub**: [https://github.com/54MY](https://github.com/54MY)

---

¡Gracias por usar **Ontología**! 🚀