package model.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Car {
    private  int id;
    private  String name;
    private  String plateNumber;
    private  String color;


    @Override
    public String toString(){
        Gson gson = new Gson();

        return  gson.toJson( this);
    }



}