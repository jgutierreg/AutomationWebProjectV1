
Feature: Pruebas de TestPage

  Rule: Validacion de Tabla


    Background: Ir a pagina
      Given me dirijo a TestPage

 @TestFail
  Scenario: Obtener el texto de una tabla
    When selecciono la opcion de 'Table test page'
    Then obtengo el texto en la tabla de la fila "2" y la columna "1"
    And valido que el texto obtenido sea "failParam"


  Scenario Outline: Obtener el texto de una tabla
    When selecciono la opcion de 'Table test page'
    Then obtengo el texto en la tabla de la fila "<Filas>" y la columna "<Columnas>"
    And valido que el texto obtenido sea "<Dato>"

    Examples:
      |Filas|Columnas| Dato       |
      |  2  |   1    | Alan       |
      |  3  |   1    | Bob        |
      |  4  |   1    | Aleister   |
      |  5  |   1    | Douglas    |
