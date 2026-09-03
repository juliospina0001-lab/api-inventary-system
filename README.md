# API REST - Sistema de Gestión de Inventario
Proyecto desarrollado para la materia de Construcción de Software II. Es una API RESTful hecha con Spring Boot para administrar el inventario de una tienda, permitiendo crear, consultar, actualizar y eliminar productos, además de hacer búsquedas por nombre y categoría.

## Integrantes
Julián Andres Avendaño Ospina
Jhojan David Villada Chalarca

## ¿De qué trata el proyecto?
El sistema resuelve el control de productos en inventario en tiempo real. Maneja datos clave como nombre, descripción, precio, stock disponible y categoría. 
Para proteger la información y cumplir con los requerimientos de la entrega, la API está asegurada con autenticación básica (Basic Auth), así que solo usuarios autorizados pueden hacer peticiones.

## Tecnologías que usamos
Java 21
Spring Boot 3 (Spring Data JPA, Spring Security, Spring Web)
MySQL
Maven
Postman (para pruebas)

## Variables de Entorno
Para conectar la base de datos sin dejar contraseñas quemadas en el código, configuramos dos variables en el entorno de ejecución:
DB_USER:root
DB_PASSWORD: Contraseña de MySQL

## Pasos para ejecutar el proyecto
1. Clonar el repositorio.
2. Crear la base de datos en MySQL con el comando: CREATE DATABASE inventory_db;
3. Abrir el proyecto en IntelliJ IDEA y dejar que Maven descargue los paquetes.
4. Definir las variables DB_USER y DB_PASSWORD en las opciones de ejecución (Run Configuration).
5. Correr la clase InventoryApplication.java.
6. El servidor levantará en http://localhost:8080.
7. 
## Endpoints de la API
Para probar las rutas en Postman hay que mandar credenciales Basic Auth:
Usuario:admin
Contraseña:admin123

| Método | Endpoint | Descripción |

 POST | /api/products | Crear un producto |
 GET | /api/products | Obtener todos los productos |
 GET | /api/products/{id} | Buscar producto por ID |
 PUT | /api/products/{id} | Actualizar un producto |
 DELETE | /api/products/{id} | Eliminar un producto |
 GET | /api/products/category/{category} | Buscar por categoría |
 GET | /api/products/search?name={nombre} | Buscar por nombre |

