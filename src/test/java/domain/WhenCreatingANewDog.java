package domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pravyada on 9/8/2016.
 */
public class WhenCreatingANewDog {

    @Test
    public void a_dog_should_have_a_name(){
        Dog fido = Dog.called("Fido").ofBreed("Laborador").andOfColor("Black");

        Assert.assertEquals(fido.getName(),"Fido");
        Assert.assertEquals(fido.getBreed(),"Laborador");
    }
}
