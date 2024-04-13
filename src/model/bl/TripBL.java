package model.bl;

import model.da.TripDA;
import model.entity.Trip;

public class TripBL {
    public static void save(Trip trip) throws Exception{
        TripDA tripDA = new TripDA();
        tripDA.save(trip);
    }

    public static void edit(Trip trip) throws Exception{
        TripDA tripDA = new TripDA();
        tripDA.edit(trip);
    }
}
