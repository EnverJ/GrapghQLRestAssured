package pojos.Customer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class User {
    private int id;
    private String name;
    private String email;
    private List<String> roles;
    private Address address;
    private Preferences preference;

    static class Address{
        private String street;
        private String city;
        private String state;
        private String zipCode;
        private String country;

        public Address(String s, String north, String co, String s1, String usa) {
        }
    }
    class Preferences{
        private String notifications;
        private List<String> themes;
    }

    public User(int id, String name, String email, List<String> roles, Address address, Preferences preference) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.address = address;
        this.preference = preference;
    }
}
