package serenitylabs.tutorials.vetclinic.screenplay.tasks;

import net.serenitybdd.screenplay.Ability;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.screenplay.abilities.ManageTheHotel;

/**
 * Created by pravyada on 9/16/2016.
 */
public class Manage {
    public static Ability the(PetHotel petHotel) {
        return new ManageTheHotel(petHotel);
    }
}
