package model.bl;

import model.entity.License;
import model.da.licenseDA;

public class LicenseBL {
    public static void save(License license) throws Exception {
        licenseDA licenseDA = new licenseDA();

        if (licenseDA.findById(license.getId())) {
            throw new Exception("Duplicate ID!!!");
        } else  {
            licenseDA.save(license);
        }
    }
}
