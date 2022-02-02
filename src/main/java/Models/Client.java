package Models;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Clients")
public class Client extends BaseModel implements Serializable {

    private String name;

    private String notes;

    private Integer phone;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Adress adress;

//    @OneToMany(mappedBy = "client_order", cascade = CascadeType.ALL)
//    private List<Order> orderList = new ArrayList<>();


    public Client() {
    }

    public Client(String name, Integer phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                ", phone=" + phone +
                ", adress=" + adress +
                '}';
    }
}
