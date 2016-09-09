package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

/**
 * Created by pravyada on 9/9/2016.
 */
public interface NeedsVaccinations {
    void wasVaccinatedOn(LocalDate vaccinationDate);

    LocalDate nextVaccinationDue();
}
