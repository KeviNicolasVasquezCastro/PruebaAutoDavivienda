package starter.task;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.models.AgregarEmpleadoLoombokData;
import starter.ui.AgregarEmpleadoPage;


public class AgregarNuevoEmpleado implements Task {

    private AgregarEmpleadoLoombokData agregarEmpleadoLoombokData;

    public AgregarNuevoEmpleado (AgregarEmpleadoLoombokData agregarEmpleadoLoombokData){
        this.agregarEmpleadoLoombokData= agregarEmpleadoLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(AgregarEmpleadoPage.PIM)

        );

    }


    public static AgregarNuevoEmpleado conDatos(AgregarEmpleadoLoombokData agregarEmpleadoLoombokData){
        return Instrumented.instanceOf(AgregarNuevoEmpleado.class).withProperties(agregarEmpleadoLoombokData);
    }
}
