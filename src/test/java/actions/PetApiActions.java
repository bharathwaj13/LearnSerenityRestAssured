package actions;

import utils.ApiRequestHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Pet;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractions;
import org.hamcrest.Matchers;
import specs.PetSpecBuilder;


import static net.serenitybdd.rest.SerenityRest.*;
import static utils.ResponseAssertionHelper.*;


public class PetApiActions extends UIInteractions {


    private static final ThreadLocal<Object> requestObject = new ThreadLocal<>();
    private static final ThreadLocal<RequestSpecification> requestSpecification = new ThreadLocal<>();
    private static final ThreadLocal<Response> response = new ThreadLocal<>();

    @Given("^I generate (?:a|an) (Pet|Store) named \"(.*?)\" and make it (?:as|to be) \"(.*?)\"$")
    public void iCreateRequestObject(String requestObj, String name, String status) {
        if ("Pet".equalsIgnoreCase(requestObj)) {
            requestObject.set(Pet.builder().name(name).status(status).build());
        } else if ("Store".equalsIgnoreCase(requestObj)) {

        }

    }

    @When("^I send (?:a|an) (POST|GET|PATCH|PUT|DELETE) Request to (Pet|Store) application with the generated body$")
    public void sendRequestToApplicationWithBody(String requestType, String application) {
        if (application.equalsIgnoreCase("pet")) {
            requestSpecification.set(PetSpecBuilder.setPetSpecs());
        } else if (application.equalsIgnoreCase("store")) {

        }
        response.set(ApiRequestHelper.sendPost(requestSpecification.get(), requestObject.get()));
        Serenity.setSessionVariable("petId").to(response.get().jsonPath().get("id"));

    }

    @When("^I send (?:a|an) (POST|GET|PATCH|PUT|DELETE) Request to (Pet|Store) application with the generated body and resource \"(.*?)\"$")
    public void sendRequestToApplicationWithBodyAndEndpoint(String requestType, String application, String endpoint) {
        if (application.equalsIgnoreCase("pet")) {
            requestSpecification.set(PetSpecBuilder.setPetSpecs());
        } else if (application.equalsIgnoreCase("store")) {

        }
        response.set(ApiRequestHelper.sendPostWithEndpoint(requestSpecification.get(), requestObject, endpoint));
        Serenity.setSessionVariable("petId").to(response.get().jsonPath().get("id"));
    }

    @When("^I ask for a pet using Kitty's ID:$")
    public void whenIAskForPetWithId() {
        when().get("/" + Serenity.sessionVariableCalled("petId"));
    }

    @Then("^I get (?:a|an) Kitty named \"(.*?)\" as result$")
    public void thenISeekKittyAsResult(String name) {
        assertFieldEquals("name", name);
    }

    @Then("^the response should have a status code (\\d+)$")
    public void verifyStatusCode(int expectedStatusCode) {
        assertStatusCode(expectedStatusCode);
    }

}
