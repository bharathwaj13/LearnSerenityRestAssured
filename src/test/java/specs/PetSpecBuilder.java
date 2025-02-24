package specs;

import net.serenitybdd.rest.SerenityRest;

public final class PetSpecBuilder extends BaseSpecBuilder {

    public static void petSpecs(){
        SerenityRest.setDefaultBasePath("/pet");
    }
}
