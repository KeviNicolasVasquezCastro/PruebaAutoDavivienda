package starter.task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.models.AgregarEmpleadoLoombokData;
import starter.ui.AgregarEmpleadoPage;
import starter.ui.LoginPage;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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


        String rutaFoto = Paths.get("src/test/resources/" + nombreFoto)
                .toAbsolutePath()
                .toString();

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
                SendKeys.of(rutaFoto).into(AgregarEmpleadoPage.photo),
                Click.on(AgregarEmpleadoPage.buttonSave)

        );
    }

    public static AgregarNuevoEmpleado conDatos(AgregarEmpleadoLoombokData datosEmpleado, String nombreFoto) {
        return Tasks.instrumented(AgregarNuevoEmpleado.class, datosEmpleado, nombreFoto);
    }

}