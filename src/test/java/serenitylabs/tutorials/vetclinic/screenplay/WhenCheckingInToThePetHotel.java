package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.GuestList;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.model.WaitingList;
import serenitylabs.tutorials.vetclinic.screenplay.questions.TheGuests;
import serenitylabs.tutorials.vetclinic.screenplay.questions.TheGuestsOnTheWaitingList;
import serenitylabs.tutorials.vetclinic.screenplay.questions.TheRegisteredGuests;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

@RunWith(SerenityRunner.class)
public class WhenCheckingInToThePetHotel {


    PetHotel petHotel;
    @Before
    public void estabilishHotel() {

        GuestList guestList = new GuestList();
        WaitingList waitingList = new WaitingList();
        petHotel = new PetHotel("Pet Hotel California", guestList, waitingList);
    }


    @Test
    public void petra_checks_her_cat_in_when_the_hotel_is_full() {
        // GIVEN

        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = APetHotel.with(20).petsCheckedIn();

        Actor harry = Actor.named("Harry the hotel manager");

        //GIVEN
        harry.can(Manage.the(petHotel));

        // WHEN
        harry.wasAbleTo(FillTheHotel.with(20).cats());
        petra.wasAbleTo(CheckIn.aPet(ginger).into(petHotel));

        // THEN
        harry.should(seeThat(TheGuests.registeredInHotel(),not(hasItem(ginger))));
        harry.should(seeThat(TheGuests.onTheWaitingListIn(),hasItem(ginger)));
    }
}
