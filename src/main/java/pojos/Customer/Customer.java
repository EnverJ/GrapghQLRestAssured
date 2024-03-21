package pojos.Customer;

import lombok.Getter;
import lombok.Setter;
import org.apache.juneau.annotation.Beanc;

import java.util.SplittableRandom;
@Getter
@Setter
public class Customer {

    private String user;
    private int id;
    private String name;
    private String email;
    private String [] roles;


    private String address;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String preference;
    private String notifications;
    private String[] themes; // dark light

    private String[] products;
    private String pId;
    private String pName;
    private String price;
    private String[] dimensions;
    private String width;
    private String height;
    private String depth;
    private String[] tags; // gadget, tech   appliance, home

    @Beanc(properties = "user,  id,  name, email, roles, address, street, city,  state, zipCode, country,preference, notifications, themes, products,pId, pName,price,dimensions,width,height,depth,tags")
    public Customer(String user, int id, String name, String email, String[] roles, String address, String street, String city, String state, String zipCode, String country, String preference, String notifications, String[] themes, String[] products, String pId, String pName, String price, String[] dimensions, String width, String height, String depth, String[] tags) {
        this.user = user;
        this.id = id;
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.address = address;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.preference = preference;
        this.notifications = notifications;
        this.themes = themes;
        this.products = products;
        this.pId = pId;
        this.pName = pName;
        this.price = price;
        this.dimensions = dimensions;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.tags = tags;
    }

}
