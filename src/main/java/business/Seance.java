package business;

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
    private final String hour;

    public Seance(String day, String hour) {
        this.day = day;
        this.hour = hour;
    }

    public String getDay() {
        return day;
    }

    public String getHour() {
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


