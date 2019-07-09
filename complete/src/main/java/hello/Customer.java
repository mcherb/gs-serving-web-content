package hello;

public class Customer {
    @Trim
    private String firstName;

    public Customer() {
    }

//    public Customer(String firstName) {
//        this.firstName = firstName;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
