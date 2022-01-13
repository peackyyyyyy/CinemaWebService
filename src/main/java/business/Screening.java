package business;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Screening {
    @Id
    private final Integer id;
    private final Integer id_cinema;
    private final Integer id_film;
    private final String start_hour;
    private final String end_hour;
    private final List<Seance> seances;

    public Screening(Integer id, Integer id_cinema, Integer id_film, String start_hour, String end_hour, List<Seance> seances) {
        this.id = id;
        this.id_cinema = id_cinema;
        this.id_film = id_film;
        this.start_hour = start_hour;
        this.end_hour = end_hour;
        this.seances = seances;
    }

    public int getId() {
        return id;
    }

    public int getId_cinema() {
        return id_cinema;
    }

    public int getId_film() {
        return id_film;
    }

    public String getStart_hour() {
        return start_hour;
    }

    public String getEnd_hour() {
        return end_hour;
    }

    public List<Seance> getSeances() {
        return seances;
    }

    @Override
        public String toString() {
            return "Screening{" +
                    "id='" + id +
                    ", id_cinema='" + id_cinema +
                    ", id_film=" + id_film +
                    ", start_hour=" + start_hour +
                    ", end_hour=" + end_hour +
                    ", seances=" + seances +
                    '}';
        }

}
