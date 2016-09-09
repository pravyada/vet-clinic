package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;


public class Cat extends Animal implements NeedsVaccinations{


    private final String name;
    private final String breed;
    private final String colour;
    private LocalDate vaccinationDate;

    public Cat(String name, String breed, String colour) {

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

    public static CatBuilder called(String name) {
        return new CatBuilder(name);
    }


    @Override
    public String complains() {
        return "Meow";
    }

    public void wasVaccinatedOn(LocalDate today) {

        this.vaccinationDate = today;
    }
    public LocalDate nextVaccinationDue() {
        return vaccinationDate.plusYears(1);
    }

    public static class CatBuilder {
        private final String name;
        private String breed;

        public CatBuilder(String name) {
            this.name = name;
        }

        public CatBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Cat andOfColour(String colour) {
            return new Cat(name, breed, colour);
        }
    }
}
