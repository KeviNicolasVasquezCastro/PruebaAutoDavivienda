package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import starter.models.AgregarEmpleadoLoombokData;
import starter.models.LoginLoombokData;
import starter.question.ValidarConsultaEmpleado;
import starter.question.ValidarRegistroEmpleado;
import starter.task.AgregarNuevoEmpleado;
import starter.task.ConsultarEmpleado;
import starter.task.Login;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AgregarNuevoEmpleadoStepDefinitions {

    private AgregarEmpleadoLoombokData empleado;

    @Given("el usuario se autentica en la aplicacion")
    public void elUsuarioSeAutentica(DataTable dataTable){
        OnStage.theActorCalled("Kevin").wasAbleTo(Login.conCredenciales(LoginLoombokData.setData(dataTable).get(0)));
    }

    @When("agrega un nuevo empleado con datos basicos")
    public void agregaNuevoEmpleado(DataTable dataTable){
        empleado = AgregarEmpleadoLoombokData.setData(dataTable).get(0);
       OnStage.theActorInTheSpotlight().attemptsTo(AgregarNuevoEmpleado.conDatos(empleado,"foto_empleado.jpg"));
    }

    @When("valida que se inserte de manera exitosa")
    public void valida(){
        OnStage.theActorInTheSpotlight().should(seeThat(ValidarRegistroEmpleado.conAlerta()));
    }

    @When("consulta empleado en el directory")
    public void consultaEmpleado(){
        OnStage.theActorInTheSpotlight().attemptsTo(ConsultarEmpleado.enElSistema(empleado));
    }

    @Then("valida que el usuario existe en el directory")
    public void validaUsuarioDirectory(){
        OnStage.theActorInTheSpotlight().should(seeThat(ValidarConsultaEmpleado.conDatos(empleado), org.hamcrest.Matchers.is(true)));
    }

}
