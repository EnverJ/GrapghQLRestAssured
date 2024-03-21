package pojos;

import com.fasterxml.jackson.databind.JsonSerializable;
import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.xml.XmlSerializer;

public class ProductTest {
    public static void main(String[] args) {
        // pojo to json
       JsonSerializer jsonSerializable= JsonSerializer.DEFAULT_READABLE;
       String sellerNames[]={"amazon","walmart","target"};
       Products products=new Products("ZARA",1000,"white",sellerNames);
       String json=jsonSerializable.serialize(products);
        System.out.println(json);

        System.out.println("------XmlSerializer--------");
        // pojo to xml
        XmlSerializer xmlSerializer= XmlSerializer.DEFAULT_NS_SQ_READABLE;
        String xml=xmlSerializer.serialize(products);
        System.out.println("xmlSerializer = " + xml);


        // pojo to html
        System.out.println("-pojo to html----");
        HtmlSerializer htmlSerializer= HtmlSerializer.DEFAULT_SQ_READABLE;
        String html=htmlSerializer.serialize(products);
        System.out.println("htmlSerializer = " + html);

        // deserialization
        // json to pojo

        JsonParser jsonParser=JsonParser.DEFAULT;
        String jsonVal="{\n" +
                "\t\"color\": \"white\",\n" +
                "\t\"name\": \"ZARA\",\n" +
                "\t\"price\": 1000,\n" +
                "\t\"sellerName\": [\n" +
                "\t\t\"amazon\",\n" +
                "\t\t\"walmart\",\n" +
                "\t\t\"target\"\n" +
                "\t]\n" +
                "}";
        Products products1=jsonParser.parse(jsonVal, Products.class);
        System.out.println("products1.getName() = " + products1.getName());  // products1.getName() = ZARA
        System.out.println(products1); // Products{name='ZARA', price=1000, color='white', sellerName=[amazon, walmart, target]}
    }
    }


