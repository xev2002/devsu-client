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
\src\test\resources\data\clientes.json
- `PUT http://localhost:3333/api/clientes/2002`  
El archivo para el body se encuentra en:  
\src\test\resources\data\clientePut.json
- `PATCH http://localhost:3333/api/clientes/2002`  
El archivo para el body se encuentra en:  
\src\test\resources\data\clientePatch.json
- `POST http://localhost:3333/auth/login`  
El archivo para el body se encuentra en:  
\src\test\resources\data\clienteLogin.json
- `DELETE http://localhost:3333/api/clientes/2002`


---
## Ejecución con Docker
> 1. Crear carpeta llamada Devsu
> 2. Pegar la carpeta mysql-init
Esta carpeta debe contener el archivo init.sql con la creación del usuario y permisos necesarios.
> 3. Pegar el archivo docker-compose.yml
> 4. Descargar el repositorio devsu-client dentro de la carpeta Devsu
> 5. Descargar el repositorio devsu-account dentro de la carpeta Devsu
> 6. Dentro de la ruta, ejecutar el siguiente comando docker: docker-compose up --build


La estructura para el perfecto funcionamiento debe ser:  
Devsu  
├── docker-compose.yml  
├── mysql-init  
│   └── init.sql  
├── devsu-client  
└── devsu-account  
Es importante tener los puertos 3306, 3333 y 4444 disponibles.
