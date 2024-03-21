package demo;

public class TestCustomer {
    public static void main(String[] args) {
        Customer customer=new Customer("tom",23,"NY",true,"09/23/2012");
//        customer.setName("Ez");
//        customer.setAge(23);
//        System.out.println(customer.getName()+" "+customer.getAge());
        System.out.println(customer);
        System.out.println(customer.getName()+customer.getDob());
        customer.setActive(false);
        System.out.println(customer);
    }
}
