package serenitylabs.tutorials.vetclinic.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pravyada on 9/9/2016.
 */
public class ComplaintRegister {
    private List<String> complainsList = new ArrayList<String>();

    public List<String> getComplains(){
        return complainsList;
    }

    public void recordComplaint(String complains) {
        complainsList.add(complains);
    }
}
