package serenitylabs.tutorials.vetclinic.screenplay.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.vetclinic.model.Breed;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.screenplay.abilities.ManageTheHotel;

public class FillTheHotel implements Task {
    private final int numOfPets;
    private final Breed breed;

    public FillTheHotel(int numOfPets, Breed breed) {
        this.numOfPets = numOfPets;
        this.breed = breed;
    }

    @Step("{0} books in #numOfPets pets")
    @Override
    public <T extends Actor> void performAs(T actor) {
        for(int count = 1;count<=numOfPets;count++){
            Pet pet = new Pet("Pet #"+count,breed);
            actor.usingAbilityTo(ManageTheHotel.class).checkInPet(pet);
        }
    }

    public static FillTheHotelBuilder with(int numOfPets) {

        return new FillTheHotelBuilder(numOfPets);
    }

    public static class FillTheHotelBuilder {
        private final int numOfPets;

        public FillTheHotelBuilder(int numOfPets) {
            this.numOfPets = numOfPets;
        }

        public Task cats() {
            return new FillTheHotel(numOfPets, Breed.Cat);
        }

        public Task dogs(){
            return new FillTheHotel(numOfPets,Breed.Dog);
        }
    }
}
