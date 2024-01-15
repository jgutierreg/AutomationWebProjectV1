
Feature: Pruebas DemoQa


    @TestForDropDown
  Scenario: Selecciono elementos en Dropdown
    Given me dirijo a DemoQA
    When hago click sobre la opcion "jajaj"
    Then selecciono el elemento web a probar "Select Menu"
    And selecciono los valor para dropdown "Blue"


