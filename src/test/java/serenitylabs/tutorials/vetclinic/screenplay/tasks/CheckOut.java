package serenitylabs.tutorials.vetclinic.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

/**
 * Created by pravyada on 9/14/2016.
 */
public class CheckOut implements Performable {
    private final PetHotel petHotel;
    private final Pet pet;

    public CheckOut(Pet pet, PetHotel petHotel) {
        this.pet = pet;
        this.petHotel = petHotel;
    }

    public static ChekcOutBuilder aPet(Pet pet) {
        return new ChekcOutBuilder(pet);
    }

    @Step("{0} Check'sout #pet from #petHotel")
    @Override
    public <T extends Actor> void performAs(T t) {
        petHotel.checkOut(pet);
    }

    public static class ChekcOutBuilder {
        private final Pet pet;

        public ChekcOutBuilder(Pet pet) {
            this.pet = pet;
        }

        public Performable from(PetHotel petHotel) {
            return new CheckOut(pet,petHotel);
        }
    }
}
