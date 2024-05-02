package controller;

import model.bl.LicenseBL;
import model.bl.PersonBL;
import model.entity.License;
import model.entity.Person;

import java.util.regex.Pattern;

public class LicenseController {
    public static String save(String licenseType, String fileName, String fileSize, String description) {
        try {
            if (
                    Pattern.matches("^[a-zA-Z\\s]{2,20}$", licenseType)
                            && Pattern.matches("^[a-zA-Z\\s]{2,20}$", fileName)
                            && Pattern.matches("^[a-zA-Z\\s]{2,20}$", description)
                            && Pattern.matches("^\\d{30}$", fileSize)
            ) {
                License license = License.builder().licenseType(licenseType).fileName(fileName).fileSize(Integer.parseInt(fileSize)).description(description).build();
                LicenseBL.save(license);
                return "License Saved.";
            }else{
                return "Error : Invalid Data";
            }

        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
    }
}
