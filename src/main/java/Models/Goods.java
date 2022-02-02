package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;


@Entity(name = "Goods")
public class Goods extends BaseModel implements Serializable {

    private String name;
    @Column(name="description")
    private String desc;
    private int count;

    public Goods() {
    }

    public Goods(String name, String desc, int count) {
        this.name = name;
        this.desc = desc;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", count=" + count +
                '}';
    }
}
