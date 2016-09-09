package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

/**
 * Created by pravyada on 9/9/2016.
 */
public class WhenCollectingAnimals {

    @Test
    public void a_list_of_animals_can_contain_cats_and_dogs()
    {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("black");
        Cat felix = Cat.called("Fido").ofBreed("Labrador").andOfColour("black");

        List<Animal> animalList = new ArrayList<Animal>();

        animalList.add(fido);
        animalList.add(felix);

        assertThat(animalList,hasItems(fido,felix));



    }
}
