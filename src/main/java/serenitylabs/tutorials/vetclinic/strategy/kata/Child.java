package serenitylabs.tutorials.vetclinic.strategy.kata;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by pravyada on 9/12/2016.
 */
public class Child {


    GameSchedule schoolSportScheduled = new SchoolSportScheduler();
    GameSchedule recreationaSportScheduled = new RecreationalSportsSchedule();

    public Game goPlayBallOn(LocalDate someDay) {
        if(someDay.getDayOfWeek() == DayOfWeek.WEDNESDAY){
            return schoolSportScheduled.forGameOn(someDay).play();
        }else {
            return recreationaSportScheduled.forGameOn(someDay).play();
        }
    }


}
