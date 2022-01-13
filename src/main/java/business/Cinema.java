package business;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Cinema {
    @Id
    private final String id;
    private final String city;
    private final String address;
    private final List<Film> film;

    public String getId() {
        return id;
    }


    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public List<Film> getFilm() {
        return film;
    }

    public Cinema(String id, String city, String address, List<Film> film) {
        this.id = id;
        this.city = city;
        this.address = address;
        this.film = film;
    }
    @Override
    public String toString() {
        return "Cinema{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", film=" + film +
                '}';
    }

}
