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

public class Phone {
    int id;
    String firstName;
    String lastName;
    String brand;
    String color;
    String serial;
    double price;

    public Phone(int id, String firstName, String lastName, String brand, String color, String serial, double price) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.brand = brand;
        this.color = color;
        this.serial = serial;
        this.price = price;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
