package serenitylabs.tutorials.vetclinic.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pravyada on 9/9/2016.
 */
public class VetAssistant {
    List<String> complains = new ArrayList<String>();
    ComplaintRegister complaintRegister;
    public VetAssistant(ComplaintRegister complaintRegister) {
        this.complaintRegister = complaintRegister;
    }

    public void registerComplaintFrom(Animal someAnimal){
        complaintRegister.recordComplaint(someAnimal.complains());

    }

}
