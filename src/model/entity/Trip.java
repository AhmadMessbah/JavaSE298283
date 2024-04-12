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
public class Trip {
    private int id;
    private String destination;
    private String description;
    private String tags;


    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
