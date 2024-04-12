package model.bl;

import model.da.PersonDA;
import model.entity.Person;

public class PersonBL {
    public static  void save(Person person) throws Exception{
        PersonDA personDA= new PersonDA();
        if(personDA.findByNationalId(person.getNationalId())){
            throw new Exception("Duplicate User !!!");
        }else{
            personDA.save(person);
        }
    }
}
