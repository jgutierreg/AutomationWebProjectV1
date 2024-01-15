# Proyecto de Automatización con Selenium, Java, Cucumber, JUnit, ChromeDriver, SparkReports y Cucumber Reports

Este proyecto es una implementación de automatización de pruebas utilizando Selenium, Java, Cucumber, JUnit, ChromeDriver, SparkReports y Cucumber Reports. Proporciona un marco de trabajo robusto y escalable para la ejecución eficiente de pruebas de software, facilitando la creación y mantenimiento de casos de prueba automatizados.

## Características Principales:

- **Selenium y Java:** Utiliza Selenium WebDriver con Java para interactuar con aplicaciones web.
- **Cucumber y JUnit:** Implementa escenarios de prueba utilizando el lenguaje natural Gherkin con Cucumber y ejecuta las pruebas con JUnit.
- **Informes Visuales:** Genera informes visuales detallados con SparkReports y Cucumber Reports para una fácil interpretación de los resultados.
   -Crear cuenta de Cucumber Reports: https://reports.cucumber.io/
- **Configuración Sencilla:** Incluye una estructura de proyecto clara y sencilla para facilitar la configuración y ejecución de pruebas.

## Cómo Empezar:

- Clone el repositorio.
- Asegúrese de tener las dependencias y requisitos previos instalados.
  * JDK 11 o superior
  * Gradle 8.5
  
- Construya el proyecto para las pruebas utilizando Gradle 8.5
  *Bash : gradle clean -gradle build

- Ejecute pruebas desde la clase Runner.class o por comando 
  * Clase Runner : Añadir tags o ejecute todas las pruebas

  * Comando/Bash :  gradle cucumber -P tags=@TagQueSeQuieraEjecutar 
  
- Explore los informes generados en la carpeta

  Local : test-output/SparkReport/MySparkReport.html

  Cucumber Reports: setear variable de entorno con su token
  Ejemplo: CUCUMBER_PUBLISH_TOKEN= 1ea0bb86-be2e-******************

## Contribuciones:

¡Contribuciones y sugerencias son bienvenidas! Siéntase libre de abrir problemas o enviar solicitudes de extracción para mejorar este proyecto.

##Autor
Jonathan Gutierrez / QA Automation Tester
