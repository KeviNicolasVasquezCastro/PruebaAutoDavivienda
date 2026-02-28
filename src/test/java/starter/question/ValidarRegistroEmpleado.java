package starter.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.AgregarEmpleadoPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarRegistroEmpleado implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(AgregarEmpleadoPage.SUCCESS_TOAST, isVisible())
                        .forNoMoreThan(10).seconds()
        );

        return AgregarEmpleadoPage.SUCCESS_TOAST
                .resolveFor(actor)
                .isCurrentlyVisible();
    }

    public static ValidarRegistroEmpleado conAlerta() {
        return new ValidarRegistroEmpleado();
    }
}