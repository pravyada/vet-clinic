package serenitylabs.tutorials.vetclinic.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import java.util.List;

/**
 * Created by pravyada on 9/15/2016.
 */

@Subject("the pets in the hotel")
public class RegisteredGuests implements  Question<List<Pet>>{
    private final PetHotel petHotel;

    public RegisteredGuests(PetHotel petHotel) {
        this.petHotel = petHotel;
    }

    @Override
    public List<Pet> answeredBy(Actor actor) {
        return petHotel.getPets();
    }

    public static Question<List<Pet>> in(PetHotel petHotel) {
        return new RegisteredGuests(petHotel);
    }
}
