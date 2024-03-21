package pojos.Customer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class DataWrapper {
    private  User user;
    private List<Product> products;

    public DataWrapper(User user, List<Product> products) {
        this.user = user;
        this.products = products;
    }
}
