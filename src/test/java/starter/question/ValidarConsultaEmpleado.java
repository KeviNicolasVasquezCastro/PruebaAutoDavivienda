package starter.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import starter.models.AgregarEmpleadoLoombokData;
import starter.ui.ConsultarEmpleadoPage;

public class ValidarConsultaEmpleado implements Question<Boolean> {

    private final AgregarEmpleadoLoombokData agregarEmpleadoLoombokData;

    public ValidarConsultaEmpleado(AgregarEmpleadoLoombokData agregarEmpleadoLoombokData) {
        this.agregarEmpleadoLoombokData = agregarEmpleadoLoombokData;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        ConsultarEmpleadoPage page = new ConsultarEmpleadoPage(agregarEmpleadoLoombokData);

        return WebElementQuestion.the(page.elementoEmpleado)
                .answeredBy(actor)
                .isVisible();
    }
    public static ValidarConsultaEmpleado conDatos(AgregarEmpleadoLoombokData agregarEmpleadoLoombokData) {
        return new ValidarConsultaEmpleado(agregarEmpleadoLoombokData);
    }
}