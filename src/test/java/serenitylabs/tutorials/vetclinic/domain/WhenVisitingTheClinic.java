package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

/**
 * Created by pravyada on 9/9/2016.
 */
public class WhenVisitingTheClinic {

    @Test
    public void cats_and_dogs_complains_to_assistant(){
        Cat felix = Cat.called("Felix").ofBreed("Siemense").andOfColour("White");
        Dog fido = Dog.called("Fido").ofBreed("Laborador").andOfColour("Black");

        ComplaintRegister complaintRegister = new ComplaintRegister();

        VetAssistant vetAssistant = new VetAssistant(complaintRegister);

        vetAssistant.registerComplaintFrom(fido);
        vetAssistant.registerComplaintFrom(felix);

        assertThat(complaintRegister.getComplains(),hasItems("Grrrr","Meow"));
    }

    @Test
    public void a_vet_should_know_the_next_vaccination_due_date(){
        NeedsVaccinations felix = Cat.called("Felix").ofBreed("Siemense").andOfColour("White");

        LocalDate today = LocalDate.now();
        LocalDate nextVaccinationDate = today.plusYears(1);
        felix.wasVaccinatedOn(today);

        assertThat(felix.nextVaccinationDue(),is(equalTo(nextVaccinationDate)));
    }

    @Test
    public void a_dog_should_be_vaccinated_on_every_six_monts(){
        NeedsVaccinations fido = Dog.called("Fido").ofBreed("Laborador").andOfColour("Black");

        LocalDate today = LocalDate.now();
        LocalDate nextVaccinationDate = today.plusMonths(6);
        fido.wasVaccinatedOn(today);

        assertThat(fido.nextVaccinationDue(),is(equalTo(nextVaccinationDate)));
    }
}
