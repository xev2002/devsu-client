# Microservicio Cliente

Este repositorio contiene ejemplos de payload y endpoints para probar el microservicio **Cliente** usando Postman.  
Permite realizar pruebas de creación, consulta, actualización, eliminación y login de clientes.

---

### `Clientes`
Contiene la información de un cliente para pruebas de:

- **Crear cliente:** `POST /api/clientes`
- **Actualizar cliente:** `PUT /api/clientes/{clienteId}`
- **Actualizar parcialmente:** `PATCH /api/clientes/{clienteId}`
- **Eliminar cliente:** `DELETE /api/clientes/{clienteId}`
- **Login del cliente:** `POST /auth/login`

El login del cliente es importante al momento de usar el microservicio de cuenta/movimiento ya que nos genera un token para poder realizar las operaciones.

> **Uso en Postman:**  
> 1. Crear una nueva petición en Postman.  
> 2. Seleccionar el método HTTP correspondiente.  
> 3. Copiar el contenido de `clientes.json` en el body de la petición (`raw` → `JSON`).  
> 4. Ejecutar la petición y validar la respuesta.

---
## Uso
-  `POST http://localhost:3333/api/clientes`  
El archivo para el body se encuentra en:  
springboot-test-devsu-1-client\src\test\resources\data\clientes.json
- `PUT http://localhost:3333/api/clientes/2002`  
El archivo para el body se encuentra en:  
springboot-test-devsu-1-client\src\test\resources\data\clientePut.json
- `PATCH http://localhost:3333/api/clientes/2002`  
El archivo para el body se encuentra en:  
springboot-test-devsu-1-client\src\test\resources\data\clientePatch.json
- `POST http://localhost:3333/auth/login`  
El archivo para el body se encuentra en:  
springboot-test-devsu-1-client\src\test\resources\data\clienteLogin.json
- `DELETE http://localhost:3333/api/clientes/2002`
