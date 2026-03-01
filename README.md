QA Automation Project Davivienda - Serenity BDD
Descripción

Prueba de postulación de automatización con Serenity BDD para probar la creación y consulta de un empleado 
en la URL de pruebas proporcionada. Se utiliza Lombok para mapear datos 
de los DataTable en los feature files.

Tecnologías

Java 11+
Serenity BDD + Cucumber
Lombok
Maven
GitHub Actions (CI y reportes)

Ejecución

Local:

mvn clean verify

GitHub Actions:
El pipeline genera el reporte automáticamente, accesible desde la sección Actions del repo.

Consideraciones

-Lombok requiere plugin activo en el IDE.
