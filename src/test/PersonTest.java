package test;

import controller.PersonController;
import model.bl.PersonBL;
import model.da.PersonDA;
import model.entity.Person;

public class PersonTest {
    public static void main(String[] args) throws Exception {
//        Person person = Person
//                .builder()
//                .name("reza")
//                .family("rezaii")
//                .nationalId("1234567899")
//                .build();
//
//        PersonBL personBl = new PersonBL();
//        personBl.save(person);
//        PersonDA personDA = new PersonDA();
//        System.out.println(personDA.findByNationalId("4567891230"));
//        personDA.save(person);
//        System.out.println(person);

        System.out.println(PersonController.save("test", "java", "1112223339"));
    }
}
