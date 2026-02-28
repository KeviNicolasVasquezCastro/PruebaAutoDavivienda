package starter.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class AgregarEmpleadoPage {

    public static final Target PIM = Target.the("opcion PIM").locatedBy("//span[text()='PIM']");
    public static final Target buttonAdd = Target.the("boton + Add").locatedBy("//button[text()=' Add ']");
    public static final Target firstName = Target.the("campo de first name").locatedBy("//input[@placeholder='First Name']");
    public static final Target middleName = Target.the("campo de middle name").locatedBy("//input[@placeholder='Middle Name']");
    public static final Target lastName = Target.the("campo de last name").locatedBy("//input[@placeholder='Last Name']");
    public static final Target id = Target.the("campo de id").locatedBy("//label[text()='Employee Id']/following::input[1]");
    public static final Target photo = Target.the("opcion para subir foto").locatedBy("//input[@type='file']");
    public static final Target buttonSave = Target.the("boton save").locatedBy("//button[@type='submit' and contains(.,'Save')]");
    public static final Target SUCCESS_TOAST = Target.the("success toast message").located(By.cssSelector("div.oxd-toast--success"));
}
