package business;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Address {
    private final String number;
    private final String street;
    private final String zip;
    private final String city;

    public Address(String number, String street, String zip, String city){
        this.number = number;
        this.city = city;
        this.street = street;
        this.zip = zip;
    }

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
