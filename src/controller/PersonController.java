package controller;

import model.bl.PersonBL;
import model.entity.Person;

import java.util.regex.Pattern;

public class PersonController {
    public static String save(String name, String family, String nationalId) {
        try {
            if (
                    Pattern.matches("^[a-zA-Z\\s]{2,20}$", name)
                    && Pattern.matches("^[a-zA-Z\\s]{2,20}$", family)
                    && Pattern.matches("^\\d{10}$", nationalId)
            ) {
                Person person = Person.builder().name(name).family(family).nationalId(nationalId).build();
                PersonBL.save(person);
                return "Person Saved.";
            }else{
                return "Error : Invalid Data";
            }

        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }
}
