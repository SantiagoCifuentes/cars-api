# cars-api

API REST para la gestión de autos y marcas, desarrollada con Java Spring Boot.

## Características

- CRUD de autos y marcas
- Paginación y validación de datos
- Manejo global de excepciones
- Documentación con Javadoc

## Requisitos

- Java 17+
- Maven 3.8+
- Base de datos compatible con JPA (H2, PostgreSQL, MySQL, etc.)

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/cars-api.git
   cd cars-api
   
2. Configura la base de datos en `src/main/resources/application.properties`:
   ```properties
   server.port=8020
   
3. Construye el proyecto con Maven:
   ```bash
   mvn clean install
4. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```
    La aplicación estará disponible en `http://localhost:8020`.

## Pruebas
Ejecuta los tests con
mvn test

## Estructura del proyecto

| Carpeta       | Descripción                     |
|---------------|---------------------------------|
| `controller/` | Controladores REST              |
| `service/`    | Lógica de negocio               |
| `model/`      | Entidades JPA                   |
| `repository/` | Acceso a datos (Spring Data JPA)|

repository/ — Acceso a datos

## Endpoints principales

**Carros**

| Método | Endpoint       | Descripción          |
|--------|---------------|----------------------|
| `GET`  | `/api/cars`   | Listar autos (paginación) |
| `POST` | `/api/cars`   | Crear un auto        |


Ejemplo Body:
```json
{
  "carModel": "Mercedes Benz",
  "description": "Lo mejorcito",
  "price": 15000,
  "mileage": 12000,
  "brand_id": {
    "id": 3,
    "name": "Mercedes"
  }
}
```

**Marcas**

| Método | Endpoint      | Descripción     |
| ------ | ------------- | --------------- |
| `POST` | `/api/brands` | Crear una marca |


```json
{
  "id": 1,
  "name": "Toyota"
}
```

