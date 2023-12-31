# API SlowBind - Puntos de Interés

Esta API permite a los usuarios buscar y filtrar puntos de interés, ofreciendo información detallada sobre monumentos y lugares de interés. Está desarrollada en Java Spring Boot y proporciona endpoints para consultar y filtrar puntos de interés. Los usuarios pueden interactuar con la API mediante solicitudes HTTP a través de herramientas como Postman.

---

## Requisitos

Antes de utilizar esta API, asegúrate de cumplir con los siguientes requisitos:

- [Java JDK 17](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- [Maven](https://maven.apache.org/download.cgi) instalado.

---

## Dependencias del Proyecto

- [spring-boot-starter-web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
- [spring-boot-starter-data-jpa](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)
- [spring-boot-devtools](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)
- [mysql-connector-java](https://mvnrepository.com/artifact/mysql/mysql-connector-java)
- [jackson-databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)
- [spring-boot-starter-test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test)

---

## Modelo de Puntos de Interés

El modelo de datos para representar los puntos de interés incluye información como categoría, zona, nombre, rating, latitud y longitud.

---

## Ejecución del Proyecto

Sigue estos pasos para ejecutar el proyecto:

1. Clona este repositorio en tu máquina local.

```bash
git clone https://github.com/tuusuario/tu-repo.git
cd tu-repo
mvn spring-boot:run
```


## Documentación de Swagger

Puedes acceder a la documentación de la API y probar sus rutas utilizando Swagger. Para acceder 
a la documentación, ejecuta el proyecto y visita la siguiente URL en tu navegador:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/doc/swagger-ui/index.html)

Swagger proporciona una interfaz interactiva para explorar y probar todas las funcionalidades 
de la API.

---

