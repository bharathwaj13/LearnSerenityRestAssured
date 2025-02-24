package specs;

import net.serenitybdd.rest.SerenityRest;

public class BaseSpecBuilder {

     static void configureBaseSpecs() {
        SerenityRest.setDefaultRequestSpecification(
                SerenityRest.with()
                        .baseUri("https://petstore.swagger.io/v2")
                        .params("Content-Type", "application/json",
                                "Accept", "application/json")
                        .log()
                        .all());
    }
}
