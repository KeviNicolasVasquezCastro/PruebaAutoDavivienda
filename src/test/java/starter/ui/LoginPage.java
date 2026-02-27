package starter.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target inputUser = Target.the("campo name").locatedBy("//input[@placeholder='Username']");
    public static final Target inputPassword = Target.the("campo password").locatedBy("//input[@placeholder='Password']");
    public static final Target buttonLogin = Target.the("boton login").locatedBy("//button");

}
