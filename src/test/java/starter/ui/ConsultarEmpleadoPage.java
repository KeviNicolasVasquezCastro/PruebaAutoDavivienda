package starter.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import starter.models.AgregarEmpleadoLoombokData;

public class ConsultarEmpleadoPage {

    private final AgregarEmpleadoLoombokData agregarEmpleadoLoombokData;
    private final String nombreCompleto;
    public final Target elementoEmpleado; // Target dinámico

    public ConsultarEmpleadoPage(AgregarEmpleadoLoombokData agregarEmpleadoLoombokData) {
        this.agregarEmpleadoLoombokData = agregarEmpleadoLoombokData;

        // Construir nombre completo concatenando firstNameConId + middleName + lastName + espacio final
        this.nombreCompleto = agregarEmpleadoLoombokData.getFirstNameConId()
                + " "
                + agregarEmpleadoLoombokData.getMiddleName()
                + " "
                + agregarEmpleadoLoombokData.getLastName()
                + " "; // <- espacio final necesario para coincidir con la UI

        // Target dinámico basado en el nombre completo con espacio final
        this.elementoEmpleado = Target.the("Empleado creado")
                .located(By.xpath("//p[text()='" + nombreCompleto + "']"));
    }

    // Targets estáticos
    public static final Target directory = Target.the("opcion de Directory")
            .locatedBy("//span[text()='Directory']");
    public static final Target employeeName = Target.the("campo para buscar por name")
            .locatedBy("//input[@placeholder='Type for hints...']");
    public static final Target botoSearch = Target.the("boton search")
            .locatedBy("//button[text()=' Search ']");
}