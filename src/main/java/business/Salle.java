package business;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Salle {

    @Id
    private final String id;
    private final Integer numSalle;
    private final Integer nbPlaces;

    public Salle(String id, Integer numSalle, Integer nbPlaces) {
        this.id = id;
        this.numSalle = numSalle;
        this.nbPlaces = nbPlaces;
    }

    public String getId() {
        return id;
    }

    public Integer getNumSalle() {
        return numSalle;
    }

    public Integer getNbPlaces() {
        return nbPlaces;
    }


    @Override
    public String toString() {
        return "Screening{" +
                "id='" + id +
                ", numSalle='" + numSalle +
                ", nbPlaces=" + nbPlaces +
                '}';
    }

}
