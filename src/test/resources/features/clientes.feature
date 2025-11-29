Feature: Pruebas del microservicio Cliente

  Background:
    * url baseUrl = 'http://localhost:3333'
    * def cliente = clientes.json

  Scenario: Crear cliente
    Given path '/api/clientes'
    And request cliente
    When method post
    Then status 201

  Scenario: Login del cliente y obtener token
    Given path '/auth/login'
    And request { clientId: 2002, contrasena: '12345' }
    When method post
    Then status 200
    * def token = response.token

  Scenario: Obtener todos los clientes
    Given path '/api/clientes'
    When method get
    Then status 200

  Scenario: Actualizar cliente (PUT)
    Given path '/api/clientes/2002'
    And request cliente
    When method put
    Then status 200

  Scenario: Patch cliente
    Given path '/api/clientes/2002'
    And request { direccion: "Nueva direccion" }
    When method patch
    Then status 200

  Scenario: Eliminar cliente
    Given path '/api/clientes/2002'
    When method delete
    Then status 200