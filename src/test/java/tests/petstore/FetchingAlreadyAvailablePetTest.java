package tests.petstore;

import actions.PetApiActions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;

@ExtendWith(SerenityJUnit5Extension.class)
class FetchingAlreadyAvailablePetTest {

    PetApiActions petApiActions;
    Long newPetId;

    @Test
    void fetchAlreadyAvailablePet() {
        newPetId = petApiActions.givenKittyIsAvailableInPetStore();
        petApiActions.whenIAskForPetWithId(newPetId);
        petApiActions.thenISeekKittyAsResult();
    }
}
