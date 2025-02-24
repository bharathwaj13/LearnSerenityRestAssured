package actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import models.Pet;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.*;


public class PetApiActions extends UIInteractions {

    @Given("Kitty is available in the pet store")
    public Long givenKittyIsAvailableInPetStore() {
        Pet pet = Pet.builder().name("Rocky").status("available").build();
        return SerenityRest.given()
                .log()
                .all()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(pet)
                .when()
                .post()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .as(Pet.class)
                .getId();
    }

    @When("I ask for a pet using Kitty's ID:")
    public void whenIAskForPetWithId(Long id) {
        when().get("/" + id);
    }

    @Then("I get Kitty as result")
    public void thenISeekKittyAsResult() {
        then().body("name", Matchers.equalTo("Rocky"));
    }

}
