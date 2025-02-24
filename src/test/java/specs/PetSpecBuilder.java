package specs;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static net.serenitybdd.rest.SerenityRest.given;

public final class PetSpecBuilder {

    public static RequestSpecification setPetSpecs() {
        //SerenityRest.setDefaultRequestSpecification(
              return given()
                        .log()
                        .all()
                        .baseUri("https://petstore.swagger.io/v2")
                        .basePath("/pet")
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON);
        //);
    }
}
