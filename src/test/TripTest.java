package test;

import controller.TripController;
import model.bl.TripBL;
import model.da.TripDA;
import model.entity.Trip;

public class TripTest {
    public static void main(String[] args) throws Exception {
//        Trip trip = Trip
//                .builder()
//                .id(1)
//                .destination("Kerman")
//                .description("With Bus")
//                .tags("1000")
//                .build();
// TestDa

//        TripDA tripDA = new TripDA();
//        tripDA.save(trip);
//        tripDA.edit(trip);
//        tripDA.remove(2);
//        System.out.println(tripDA.findAll());
//        System.out.println(tripDA.findById(3));
//        System.out.println(tripDA.findByDestination("Esfahan"));

// Test BL

//TODO دلیل وارنینگ چیه؟ (Instantiation of utility class 'TripBL') & (Static member 'model.bl.TripBL.save(model.entity.Trip)' accessed via instance reference)
//        TripBL tripBL = new TripBL();
//        tripBL.save(trip);
//        TripBL.edit(trip);
// آیا به دلیل استاتیک بودن توابع سیو و ادیت میگه بدون ساختن شی اجرا کن؟

// Test Controller

//        System.out.println(TripController.save("Zanjan","With Taxi", "1600"));
//        System.out.println(TripController.edit(5,"Ghazvin","With Taxi", "1800"));


    }
}
