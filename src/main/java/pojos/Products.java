package pojos;

import lombok.Getter;
import lombok.Setter;
import org.apache.juneau.annotation.Beanc;

import java.util.Arrays;

@Getter
@Setter
public class Products {
    private String name;
    private int price;
    private String color;
    private String[] sellerName;

    @Beanc(properties="name, price,color,sellerName")
    public Products(String name, int price, String color, String[] sellerName) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.sellerName = sellerName;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", sellerName=" + Arrays.toString(sellerName) +
                '}';
    }
}
