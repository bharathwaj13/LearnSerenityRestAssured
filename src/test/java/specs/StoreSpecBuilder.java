package specs;

import net.serenitybdd.rest.SerenityRest;

public final class StoreSpecBuilder extends BaseSpecBuilder {

    public static void storeSpecs(){
        SerenityRest.setDefaultBasePath("/store");
    }
}
