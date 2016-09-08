package domain;

/**
 * Created by pravyada on 9/8/2016.
 */
public class Dog {
    private final String name;
    private final String breed;
    private final String color;


    public Dog(String name, String breed, String color) {
        this.name = name;
        this.breed = breed;
        this.color = color;
    }

    public static DogBuilder called(String name) {
        return new DogBuilder(name);
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
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

        public Dog andOfColor(String color) {
            return new Dog(name,breed,color);
        }
    }
}
