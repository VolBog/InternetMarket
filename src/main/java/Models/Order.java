package Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Orders")
public class Order extends BaseModel{

    @ManyToOne
    @JoinTable(name = "order_client")
    private Client client;

    private Date date;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "order_goods")
    private List<Goods> goodsList = new ArrayList<>();


    public Order() {
    }

    public Order(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public void addGoods(Goods goods) {
        goodsList.add(goods);
    }

    @Override
    public String toString() {
        return "Order{" +
                "client=" + client +
                ", date=" + date +
                ", goodsList=" + goodsList +
                '}';
    }
}
