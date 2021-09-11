package protostuff;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 商品类
 */
public class Products {

    private String name;

    private int price;

    private Date creatTime;

    private HashMap<String, String> hashMap;

    public Products(String name, int price, Date creatTime) {
        this.name = name;
        this.price = price;
        this.creatTime = creatTime;
        this.hashMap = new HashMap<>();
        this.hashMap.put("test", "test");
    }

    public Products() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {

        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return name +":"+ price;
    }
}