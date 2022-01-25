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
    //private final String city;
    private final String name;
    private final Address address;
    private final List<Film> film;

    public String getId() {
        return id;
    }


    public String getName(){
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<Film> getFilm() {
        return film;
    }

    public Cinema(String id, String name, Address address, List<Film> film) {
        this.id = id;
        //this.city = city;
        this.name = name;
        this.address = address;
        this.film = film;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", film=" + film +
                '}';
    }

}
