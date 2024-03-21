package builder;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Customer {

    String name;
    int age;
    boolean isActive;
    String city;

    public Customer(String name, int age, boolean isActive, String city) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
        this.city = city;
    }

    @Builder
    public static Customer createInstance(String name, int age) {
        return new Customer(name, age, true, "NY");

    }

}
