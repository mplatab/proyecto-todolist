
# Proyecto TodoList con Spring Boot

Este es un proyecto de ejemplo de una aplicación TodoList desarrollada con Spring Boot. Permite gestionar tareas por hacer (todos) mediante operaciones CRUD básicas.


## Tecnologías Utilizadas

* Java 17
* Spring Boot 3.3.1
* Spring Data JPA
* Spring Web
* MySQL Connector
* Lombok
* Springdoc OpenAPI (Swagger UI)
* H2 Database (para pruebas)
## Installation

**2. Clonar el repositorio**

```bash
git clone https://github.com/tu_usuario/proyecto-todolist.git   
cd proyecto-todolist
```
**2. Configuración de la Base de Datos**
```application.yml o application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=usuario
spring.datasource.password=contraseña
spring.jpa.hibernate.ddl-auto=update

```
 **1. Compilar y Ejecutar**
```
mvn spring-boot:run
```
La aplicación estará disponible en http://localhost:8080.

    
## Uso

Crear Todo: Envía una solicitud POST a /todos con un JSON que contenga title, description, isCompleted (opcional), y priority.

```json
{
  "title": "Tarea 1",
  "description": "Descripción de la tarea 1",
  "isCompleted": false,
  "priority": 1
}

```
* **Listar Todos:** Envía una solicitud GET a /todos para obtener la lista de todos los todos ordenados por prioridad descendente y título ascendente.

* **Actualizar Todo:** Envía una solicitud PUT a /todos/{id} con un JSON que contenga los campos a actualizar.

* **Eliminar Todo:** Envía una solicitud DELETE a /todos/{id} para eliminar un todo por su ID.