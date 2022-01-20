package business;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Screening {
    @Id
    private final String id;
    private final String id_cinema;
    private final String id_film;
    private final List<Seance> seances;

    public Screening(String id, String id_cinema, String id_film, List<Seance> seances) {
        this.id = id;
        this.id_cinema = id_cinema;
        this.id_film = id_film;
        this.seances = seances;
    }

    public String getId() {
        return id;
    }

    public String getId_cinema() {
        return id_cinema;
    }

    public String getId_film() {
        return id_film;
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
                    ", seances=" + seances +
                    '}';
        }

}
