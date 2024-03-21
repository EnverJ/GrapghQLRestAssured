package pojos.Customer;

import com.fasterxml.jackson.databind.JsonSerializable;
import org.apache.juneau.json.JsonSerializer;

import java.util.Arrays;
import java.util.List;
import java.util.SplittableRandom;
import java.util.prefs.Preferences;

public class CustomerTest {
    public static void main(String[] args) {

       User.Address address = new User.Address("12344 main street","North","CO","12345","USA");
    //    User user=new User(12345, "John Doe", "john.doe@example.com", Arrays.asList("admin", "user"), address, preferences);
      //  Preferences preferences= new Preferences(true, Arrays.asList("dark", "light"));
        Product product1 = new Product("p100", "Widget", 19.99, new Product.Dimensions(10, 5, 2), Arrays.asList("gadget", "tech"));
        Product product2 = new Product("p200", "Gizmo", 29.99, new Product.Dimensions(15, 10, 3), Arrays.asList("appliance", "home"));
        List<Product> products = Arrays.asList(product1, product2);
   //     DataWrapper dataWrapper = new DataWrapper(user, products);
        JsonSerializer jsonSerializer = JsonSerializer.DEFAULT_READABLE;

    }



}
