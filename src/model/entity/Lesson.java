package model.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
    @Getter
    @Setter
    @SuperBuilder
    public class Lesson {
        private int id;
        private String name;
        private String classNo;
        private String inPersonCode;
        private String onlineCode;
        private LocalDateTime startDateTime;

        @Override
        public String toString() {
            Gson gson = new Gson();
            return gson.toJson(this);
        }
    }

