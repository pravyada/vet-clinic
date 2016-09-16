package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.screenplay.questions.GuestsInWaitingList;
import serenitylabs.tutorials.vetclinic.screenplay.questions.RegisteredGuests;
import serenitylabs.tutorials.vetclinic.screenplay.questions.TheGuests;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.*;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;


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

        //assertThat(petHotel.getPets(),hasItems(ginger));

        petra.should(seeThat(RegisteredGuests.in(petHotel),hasItem(ginger)));

    }

    @Test
    public void petra_checks_out_her_pet_from_hotel(){
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

        //assertThat(petHotel.getPets(),not(hasItems(ginger)));
        petra.should(seeThat(RegisteredGuests.in(petHotel),not(hasItem(ginger))));
    }

    @Test
    public void petra_checks_her_pet_in_when_the_hotel_is_full(){
        //GIVEN

        Actor petra = Actor.named("Petra the pet owner");
        PetHotel petHotel = new PetHotel("Pet Hotel India");//APetHotel.with(20).petsCheckedIn();
        Pet ginger = Pet.cat().named("Ginger");

        Actor harry = Actor.named("Harry the hotel manager");
        harry.can(Manage.the(petHotel));

        //GIVEN
        harry.wasAbleTo(
                FillTheHotel.with(20).cats()
        );
        //WHEN
       petra.attemptsTo(CheckIn.aPet(ginger).into(petHotel));

        //THEN
        harry.should(seeThat(TheGuests.registeredInHotel(),not(hasItem(ginger))),
                        seeThat(TheGuests.onTheWaitingListIn(),hasItem(ginger)));
        }
}
