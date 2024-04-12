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

public class License {
    private int id;
    private String licenseType;
    private String fileName;
    private int fileSize;
    private String description;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

