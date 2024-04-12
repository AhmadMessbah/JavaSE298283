package model.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

public class Ticket {
    private int id;
    private String text;
    private String subject;
    private LocalDate dateTime;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
