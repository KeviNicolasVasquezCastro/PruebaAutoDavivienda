package starter.ui;

import net.serenitybdd.screenplay.targets.Target;

public class AgregarEmpleadoPage {

    public static final Target PIM = Target.the("opcion PIM").locatedBy("//span[text()='PIM']");
    public static final Target EmployeeName = Target.the("campo de Employee Name").locatedBy("//label[text()='Employee Name']/following::input[1]");
    public static final Target EmployeeId = Target.the("campo de Employee Name").locatedBy("//label[text()='Employee Id']/following::input[1]");
    public static final Target EmploymentStatus = Target.the("click para desplegar lista").locatedBy("//label[text()='Employment Status']/following::div[contains(@class,'oxd-select-text')][1]");
    public static final Target EmploymentStatusOption = Target.the("opotion de Full-Time Contract").locatedBy("//div[@role='option' and text()='Full-Time Contract']");

}
