package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckIn;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckOut;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;

/**
 * Created by pravyada on 9/14/2016.
 */
@RunWith(SerenityRunner.class)
public class BookingAPetIntoHotel {

    @Test
    public void petra_books_her_pet_cat_into_hotel(){
        //GIVEN
        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = new PetHotel("Pet Hotel India");

        //WHEN
        petra.attemptsTo(
                CheckIn.aPet(ginger).into(petHotel)
        );
        //THEN

        assertThat(petHotel.getPets(),hasItems(ginger));

    }

    @Test
    public void petra_wants_to_checkout_her_pet_from_hotel(){
        //GIVEN
        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = new PetHotel("Pet Hotel India");
        petra.wasAbleTo(
                CheckIn.aPet(ginger).into(petHotel)
        );
        //WHEN
        petra.attemptsTo(
                CheckOut.aPet(ginger).from(petHotel)
        );
        //THEN

        assertThat(petHotel.getPets(),not(hasItems(ginger)));
    }
}
