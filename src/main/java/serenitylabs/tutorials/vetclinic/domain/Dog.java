package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public class Dog extends Animal implements NeedsVaccinations {
    private final String name;
    private final String breed;
    private final String colour;
    private LocalDate vaccinationDate;

    public Dog(String name, String breed, String colour) {

        this.name = name;
        this.breed = breed;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getColour() {
        return colour;
    }

    public static DogBuilder called(String name) {
        return new DogBuilder(name);
    }


    @Override
    public String complains() {
     return "Grrrr";
    }

    @Override
    public void wasVaccinatedOn(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    @Override
    public LocalDate nextVaccinationDue() {
        return vaccinationDate.plusMonths(6) ;
    }

    public static class DogBuilder {
        private final String name;
        private String breed;

        public DogBuilder(String name) {
            this.name = name;
        }

        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog andOfColour(String colour) {
            return new Dog(name, breed, colour);
        }
    }
}