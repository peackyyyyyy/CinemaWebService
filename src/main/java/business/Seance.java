package business;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document("seance")
public class Seance {
    @Id
    private final String day;
    private final String hour;
    private final List<Film> films;

    public Seance(String day, String hour, List<Film> films) {
        this.day = day;
        this.hour = hour;
        this.films = films;
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
                ", films='" + films +
                '}';
    }
}


