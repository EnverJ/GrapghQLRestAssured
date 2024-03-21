package builder;

public class TestUser {
    public static void main(String[] args) {
        User u1 = User.builder()
                .name("Tom")
                .age(23)
                .build();
        System.out.println(u1.getName() + " " + u1.getAge());  //Tom 23

        User u2 = User.builder().name("John").build();
        System.out.println(u2.getName() + " " + u2.getAge());  //John 0

        User u3 = User.builder().build();
        System.out.println(u3.getName() + " " + u3.getAge());  //null 0


        System.out.println("---Person-----");
        Person p1 = Person.builder().name("Peter").age(40).build();
        System.out.println(p1.getName() + " " + p1.getAge() + " " + p1.isActive + " " + p1.role);  // Peter 40 false null


        System.out.println("---Customer-----");
        Customer c1 = Customer.builder().name("Dinesh").age(25).build();
        System.out.println(c1.getName() + " " + c1.getAge() + " " + c1.isActive + " " + c1.getCity());  // Dinesh 25 true NY
    }
}
