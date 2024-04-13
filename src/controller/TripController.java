package controller;

import model.bl.TripBL;
import model.entity.Trip;

import java.util.regex.Pattern;

public class TripController {
    public static String save(String destination, String description, String tags) {
        try {
            if (
                    Pattern.matches("^[a-zA-Z\\s]{2,50}$", destination)
                            && Pattern.matches("^[a-zA-Z\\s\\d]{2,100}$", description)
                            && Pattern.matches("^[a-zA-Z\\s\\d]{2,20}$", tags)
            ) {
                Trip trip = Trip.builder().destination(destination).description(description).tags(tags).build();
                TripBL.save(trip);
                return "Trip Saved.";
            }else{
                return "Error : Invalid Data";
            }
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }

    public static String edit(int id, String destination, String description, String tags) {
        try {
            if (
                    Pattern.matches("^[a-zA-Z\\s]{2,50}$", destination)
                            && Pattern.matches("^[a-zA-Z\\s\\d]{2,100}$", description)
                            && Pattern.matches("^[a-zA-Z\\s\\d]{2,20}$", tags)
            ) {
                Trip trip = Trip.builder().id(id).destination(destination).description(description).tags(tags).build();
                TripBL.edit(trip);
                return "Trip Edited.";
            }else{
                return "Error : Invalid Data";
            }
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }
}
