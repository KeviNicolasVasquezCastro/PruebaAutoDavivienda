package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import starter.models.AgregarEmpleadoLoombokData;
import starter.models.LoginLoombokData;
import starter.task.AgregarNuevoEmpleado;
import starter.task.Login;

public class AgregarNuevoEmpleadoStepDefinitions {

    @Given("el usuario se autentica en la aplicacion")
    public void elUsuarioSeAutentica(DataTable dataTable){
        OnStage.theActorCalled("Kevin").wasAbleTo(Login.conCredenciales(LoginLoombokData.setData(dataTable).get(0)));
    }

    @When("agrega un nuevo empleado con datos basicos")
    public void agregaNuevoEmpleado(DataTable dataTable){
       OnStage.theActorInTheSpotlight().attemptsTo(AgregarNuevoEmpleado.conDatos(AgregarEmpleadoLoombokData.setData(dataTable).get(0)));
    }


    @Then("valida que se inserte de manera exitosa")
    public void valida(DataTable dataTable){

    }

}
