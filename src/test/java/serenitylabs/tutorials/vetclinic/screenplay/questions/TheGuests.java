package serenitylabs.tutorials.vetclinic.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.screenplay.abilities.ManageTheHotel;

import java.util.Collection;
import java.util.List;

/**
 * Created by pravyada on 9/16/2016.
 */
public class TheGuests {
    public static Question<List<Pet>> registeredInHotel(PetHotel petHotel) {
        return actor -> actor.usingAbilityTo(ManageTheHotel.class).getRegisteredPets();
    }

    public static Question<Collection<Pet>> onTheWaitingListIn(PetHotel petHotel) {

        return actor -> actor.usingAbilityTo(ManageTheHotel.class).getPetsOnWaitingList();
    }
}
