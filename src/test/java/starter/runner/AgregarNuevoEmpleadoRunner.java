package starter.runner;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.nio.file.Paths;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/AgregarNuevoEmpleado.feature",
        glue = "starter",
        tags = "@RegistroExitoso",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class AgregarNuevoEmpleadoRunner {

    @AfterClass
    public static void mostrarRutaReporte() {

        // Genera la ruta absoluta del reporte de forma portable
        String rutaAbsoluta = Paths.get("target", "site", "serenity", "index.html")
                .toAbsolutePath()
                .toString();

        // Formatea la ruta para que sea compatible con file:// URLs y navegadores
        String urlFormateada = "file:///" + rutaAbsoluta.replace("\\", "/").replace(" ", "%20");

        System.out.println("\n=======================================");
        System.out.println("📊 REPORTE SERENITY:");
        System.out.println("👉 " + urlFormateada);
        System.out.println("=======================================\n");
    }
}