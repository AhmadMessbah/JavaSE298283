package model.entity;

import com.google.gson.Gson;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Setter
@NoArgsConstructor
@Getter
@SuperBuilder


public class Product {

    private int id;
    private String name;
    private String brand;
    private String buyPrice;
    private String sellPrice;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}