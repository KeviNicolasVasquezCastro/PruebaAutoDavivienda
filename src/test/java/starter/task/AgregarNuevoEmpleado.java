package starter.task;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.Keys;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.remote.RemoteWebDriver;
import starter.models.AgregarEmpleadoLoombokData;
import starter.ui.AgregarEmpleadoPage;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarNuevoEmpleado implements Task {

    private final AgregarEmpleadoLoombokData agregarEmpleadoLoombokData;
    private final String nombreFoto;

    public AgregarNuevoEmpleado(AgregarEmpleadoLoombokData agregarEmpleadoLoombokData, String nombreFoto) {
        this.agregarEmpleadoLoombokData=agregarEmpleadoLoombokData;
        this.nombreFoto = nombreFoto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        //crer id por tiempo
        String idUnico = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmssSS"));

        // Concatenar al nombre el id, ya que luego lo vamos a consultar en la ultima parte de la prueba, y para que sea mas confiable la prueba
        // sera mejor que el nombre sea unico, ya que se nos indico consular por nombre.
        String firstNameConId = agregarEmpleadoLoombokData.getFirstName() + idUnico;
        // Guardar en el mismo objeto
        agregarEmpleadoLoombokData.setFirstNameConId(firstNameConId);


        /** Esta parte se realizo para subir la imagen del empleado a BrowserStack sin embargo el input no no permite recibir archivos desde
        *Selenium cuando se ejecuta en un navegador remoto.
        File file = new File("src/test/resources/" + nombreFoto);
        String rutaAbsoluta = file.getAbsolutePath();

        WebDriverFacade webDriverFacade = (WebDriverFacade) Serenity.getDriver();
        RemoteWebDriver driverRemoto = (RemoteWebDriver) webDriverFacade.getProxiedDriver();

        // Subir a BrowserStack
        Map<String, Object> args = Map.of(
                "action", "uploadFile",
                "arguments", Map.of("filePath", rutaAbsoluta)
        );

        Map<String, Object> result = (Map<String, Object>) driverRemoto.executeScript(
                "browserstack_executor: " + new com.google.gson.Gson().toJson(args));

        String uploadedFilePath = (String) result.get("remoteFilePath");
         */

        actor.attemptsTo(
                WaitUntil.the(AgregarEmpleadoPage.PIM, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(AgregarEmpleadoPage.PIM),
                WaitUntil.the(AgregarEmpleadoPage.buttonAdd, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(AgregarEmpleadoPage.buttonAdd),
                WaitUntil.the(AgregarEmpleadoPage.firstName, isVisible())
                        .forNoMoreThan(10).seconds(),
                Enter.theValue(agregarEmpleadoLoombokData.getFirstNameConId()).into(AgregarEmpleadoPage.firstName),
                Enter.theValue(agregarEmpleadoLoombokData.getMiddleName()).into(AgregarEmpleadoPage.middleName),
                Enter.theValue(agregarEmpleadoLoombokData.getLastName()).into(AgregarEmpleadoPage.lastName),
                Click.on(AgregarEmpleadoPage.id),
                SendKeys.of(Keys.chord(Keys.CONTROL, "a")).into(AgregarEmpleadoPage.id),
                SendKeys.of(Keys.DELETE).into(AgregarEmpleadoPage.id),
                Enter.theValue(idUnico).into(AgregarEmpleadoPage.id),
               // aca se hubiera subido la foto  SendKeys.of(uploadedFilePath).into(AgregarEmpleadoPage.photo),
                Click.on(AgregarEmpleadoPage.buttonSave)

        );
    }

    public static AgregarNuevoEmpleado conDatos(AgregarEmpleadoLoombokData datosEmpleado, String nombreFoto) {
        return Tasks.instrumented(AgregarNuevoEmpleado.class, datosEmpleado, nombreFoto);
    }

}