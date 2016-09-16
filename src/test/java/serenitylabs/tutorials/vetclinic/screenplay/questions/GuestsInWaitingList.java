package serenitylabs.tutorials.vetclinic.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

import java.util.Collection;

public class GuestsInWaitingList implements Question<Collection<Pet>> {
    private final PetHotel petHotel;

    public GuestsInWaitingList(PetHotel petHotel) {
        this.petHotel = petHotel;
    }

    public static GuestsInWaitingList in(PetHotel petHotel) {
           return new GuestsInWaitingList(petHotel);
    }


    @Override
    public Collection<Pet> answeredBy(Actor actor) {
        return petHotel.getWaitingList();
    }
}
