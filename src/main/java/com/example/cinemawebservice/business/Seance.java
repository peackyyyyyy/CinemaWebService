package com.example.cinemawebservice.business;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class Seance {
    @Id
    private final String day;
    private final List<String> hour;

    public Seance(String day, List<String> hour) {
        this.day = day;
        this.hour = hour;
    }

    public String getDay() {
        return day;
    }

    public List<String> getHour() {
        return hour;
    }

    @Override
    public String toString() {
        return "Seance{" +
                "day='" + day +
                ", hour='" + hour +
                '}';
    }
}


