package model.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Borrow {
    private int id;
    private int Person_id;
    private int Book_id;
    private Timestamp Borrow_date;
    private Timestamp Return_date;


    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
