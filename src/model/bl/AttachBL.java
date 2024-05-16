package model.bl;

import model.da.AttachDA;
import model.entity.Attach;

public class AttachBL {

    public static void save(Attach attach) throws Exception {
        AttachDA attachDA = new AttachDA();

        if (attachDA.findById(attach.getId())) {
            throw new Exception("Duplicate ID!!!");
        } else if (attachDA.findByPersonId(attach.getPersonId())) {
            throw new Exception("Duplicate Person ID!!!");
        } else if (attachDA.findByLicenseId(attach.getLicenseId())) {
            throw new Exception("Duplicate License ID!!!");
        } else {
            attachDA.save(attach);
        }
    }
}
