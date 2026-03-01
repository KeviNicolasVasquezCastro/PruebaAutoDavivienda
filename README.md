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
Integración de la automatización con BrowserStack para el flujo de trabajo.

Ejecución

Local:

mvn clean verify

GitHub Actions:
El pipeline genera el reporte automáticamente, accesible desde la sección Actions del repo.

Consideraciones

-Lombok requiere plugin activo en el IDE.
-Para ejecutar las pruebas en BrowserStack, es necesario configurar las credenciales de tu cuenta como **variables de entorno**:

# Windows (CMD)
setx BROWSERSTACK_USERNAME "tu_usuario"
setx BROWSERSTACK_ACCESS_KEY "tu_access_key"
