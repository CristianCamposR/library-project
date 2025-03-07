# Sistema de Biblioteca (Library System)

Este repositorio contiene dos proyectos principales: el backend desarrollado con Spring Boot y el frontend desarrollado con Angular 17. A continuación, se detallan las instrucciones para configurar y ejecutar ambos proyectos.

## Tabla de **Contenidos**

1. [Descripción del Proyecto](#descripción-del-proyecto)
2. [Tecnologías Utilizadas](#tecnologías-utilizadas)
3. [Requisitos Previos](#requisitos-previos)
4. [Configuración del Backend](#configuración-del-backend)
5. [Configuración del Frontend](#configuración-del-frontend)
6. [Ejecución del Proyecto](#ejecución-del-proyecto)
---
## Descripción del Proyecto

Este proyecto es un sistema de gestión de bibliotecas que permite administrar libros, usuarios y préstamos. El backend está desarrollado con Spring Boot y utiliza una base de datos Oracle. El frontend está desarrollado con Angular 17 y utiliza Bootstrap 5 para el diseño.

## Tecnologías Utilizadas

### Backend
- **Java 8**
- **Spring Boot 2.7.18**
- **Oracle Database 21c**
- **MyBatis 2.2.2**
- **Spring Data JPA**
- **Spring Web**

### Frontend
- **Angular 17**
- **Bootstrap 5**
- **TypeScript**
- **HTML/CSS**

## Requisitos Previos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

- **Java JDK 8**
- **Maven 3.x**
- **Node.js 19.x o superior**
- **Angular CLI 17.x**
- **Oracle Database 21c** (o una instancia accesible)
- **Git**

## Configuración del Backend

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/library-system.git
   cd library-system/backend

## Configuración de la Base de Datos

- Asegúrate de tener una instancia de Oracle Database 21c en ejecución.

- Configura las credenciales de la base de datos en el archivo application.properties ubicado en src/main/resources.

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

Remplaza los siguientes valores con los de tu entorno: }

- localhost:1521:xe: La URL de tu instancia de Oracle Database.

- tu_usuario: El nombre de usuario de la base de datos.

- tu_contraseña: La contraseña de la base de datos.

## Compilar y ejecutar el proyecto:

```bash
mvn clean install
mvn spring-boot:run
```

El backend estará disponible en http://localhost:8080.

## Configuración del Frontend

1. **Clonar el repositorio:**
```bash
git clone https://github.com/CristianCamposR/library-project.git
cd library-project/library-app
```

2. **Instalar las dependencias:**
```bash
npm install
```

3. **Ejecutar el proyecto:**

```bash
ng serve
```

El frontend estará disponible en http://localhost:4200.

### Ejecución del Proyecto

Una vez que ambos servidores (backend y frontend) estén en ejecución, puedes acceder a la aplicación a través de tu navegador en http://localhost:4200.e


### Endpoints del Backend

## Libros

| Método | Endpoint | Descripción | Backend | Frontend |
|--------|----------|-------------|----------|----------|
| GET    | /api/books | Obtiene la lista de libros | ✅ | ✅ |
| GET    | /api/books/{id} | Obtiene un libro por su ID | ✅ | ✅ |
| POST   | /api/books | Crea un nuevo libro | ✅ | ✅ |
| PUT    | /api/books/{id} | Actualiza un libro existente | ✅ | ✅ |
| DELETE | /api/books/{id} | Elimina un libro por su ID | ✅ | ✅ |

## Loan

| Método | Endpoint | Descripción | Backend | Frontend |
|--------|----------|-------------|---------|----------| 
| GET    | /api/loans | Obtiene la lista de préstamos | ✅ | ✅ | 
| GET    | /api/loans/{id} | Obtiene un préstamo por su ID | 🔴 | 🔴 | 
| POST   | /api/loans | Crea un nuevo préstamo | ✅ | 🔴 |
| PUT    | /api/loans/{id} | Actualiza un préstamo existente  | 🔴 | 🔴 | 
| DELETE | /api/loans/{id} | Elimina un préstamo por su ID  | 🔴 | 🔴 | 



