Feature: Pruebas para Google

@Test
Scenario: Busco algo en Google
  Given voy a google
  When busco algo "Perros"
  Then obtengo el resultado
