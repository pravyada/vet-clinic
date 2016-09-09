package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenWeCreateANewDog {

    @Test
    public void a_new_dog_should_have_a_name_and_a_breed_and_a_colour() throws Exception {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        Assert.assertEquals("Fido",fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals("Black", fido.getColour());
    }

    @Test
    public void a_dog_complains_by_grawling(){
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");
        assertThat(fido.complains(),is(equalTo("Grrrr")));
    }

    @Test
    public void a_cat_complains_by_meowing(){
        Cat felix = Cat.called("Felix").ofBreed("Siemense").andOfColour("Black");
        assertThat(felix.complains(),is(equalTo("Mewo")));
    }

}
