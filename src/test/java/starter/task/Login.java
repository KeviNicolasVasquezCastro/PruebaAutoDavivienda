package starter.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.models.LoginLoombokData;
import starter.ui.LoginPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    private final LoginLoombokData loginLoombokData;

    public Login (LoginLoombokData loginLoombokData){
        this.loginLoombokData = loginLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(loginLoombokData.getUrl()),
                WaitUntil.the(LoginPage.inputUser, isVisible())
                        .forNoMoreThan(10).seconds(),
                Enter.theValue(loginLoombokData.getUsuario()).into(LoginPage.inputUser),
                WaitUntil.the(LoginPage.inputPassword, isVisible())
                        .forNoMoreThan(10).seconds(),
                Enter.theValue(loginLoombokData.getContrasena()).into(LoginPage.inputPassword),
                Click.on(LoginPage.buttonLogin)
        );
    }

    public static Login conCredenciales(LoginLoombokData loginLoombokData){
        return Tasks.instrumented(Login.class, loginLoombokData);
    }

}
