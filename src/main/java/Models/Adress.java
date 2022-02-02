package Models;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;
@Entity
@Table(name = "Adresses")
public class Adress extends BaseModel implements Serializable {
    private String Country;
    private String City;
    private String Street;

    public Adress() {
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "Country='" + Country + '\'' +
                ", City='" + City + '\'' +
                ", Street='" + Street + '\'' +
                '}';
    }
}
