package starter.task;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import starter.models.AgregarEmpleadoLoombokData;
import starter.ui.AgregarEmpleadoPage;
import starter.ui.ConsultarEmpleadoPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ConsultarEmpleado implements Task {


    private final AgregarEmpleadoLoombokData agregarEmpleadoLoombokData;

    public ConsultarEmpleado (AgregarEmpleadoLoombokData agregarEmpleadoLoombokData){
        this.agregarEmpleadoLoombokData = agregarEmpleadoLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Maximizar ventana para que todos los elementos sean visibles
        WebDriver driver = Serenity.getDriver();
        driver.manage().window().maximize();

        String nombreBuscado = agregarEmpleadoLoombokData.getFirstNameConId();
        actor.attemptsTo(
                WaitUntil.the(ConsultarEmpleadoPage.directory, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(ConsultarEmpleadoPage.directory),
                WaitUntil.the(ConsultarEmpleadoPage.employeeName, isVisible())
                        .forNoMoreThan(10).seconds(),
                Enter.theValue(nombreBuscado).into(ConsultarEmpleadoPage.employeeName),
                //damos unos segundos para que consulte los resultados
                new Interaction() {
                    @Override
                    @Step("{0} espera un momento")
                    public <T extends Actor> void performAs(T actor) {
                        try { Thread.sleep(4000); } catch (InterruptedException e) {}
                    }
                },
                SendKeys.of(Keys.ARROW_DOWN, Keys.ENTER).into(ConsultarEmpleadoPage.employeeName),
                Click.on(ConsultarEmpleadoPage.botoSearch),
                //damos unos segundos para que consulte los resultados
                new Interaction() {
                    @Override
                    @Step("{0} espera un momento")
                    public <T extends Actor> void performAs(T actor) {
                        try { Thread.sleep(4000); } catch (InterruptedException e) {}
                    }
                }
        );
    }
    public static ConsultarEmpleado enElSistema(AgregarEmpleadoLoombokData datosEmpleado) {
        return Tasks.instrumented(ConsultarEmpleado.class, datosEmpleado);
    }

}
