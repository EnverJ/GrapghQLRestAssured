package pojos.Customer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Product {

    private String Id;
    private String name;
    private String price;
    private Dimensions dimensions;
    private List<String> tags;

    public <T> Product(String p100, String widget, double v, Dimensions dimensions, List<T> asList) {
    }

    static class Dimensions{
        private int width;
        private int height;
        private int depth;

        public Dimensions(int i, int i1, int i2) {
        }
    }
    
    }

