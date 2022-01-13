package business;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public record Address(@Id String number, String street, String zip,
                      String city) {

    public String getNumber() {
        return number;
    }

    public String geStreet() {
        return street;
    }

    public String getCodePostal() {
        return zip;
    }

    public String getVille() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "number='" + number + '\'' +
                ", street='" + street + '\'' +
                ", zip=" + zip +
                ", city=" + city +
                '}';
    }
}
