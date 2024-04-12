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

public class FinancialDoc {
    int id;
    int amount;
    String description;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}