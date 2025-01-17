package Booking;

public class Customer {
    private final String name;
    private final String email;
    private final String driverLicense;

    public Customer(String name, String email, String driverLicense){
        this.name = name;
        this.email = email;
        this.driverLicense = driverLicense;
    }

    @Override
    public String toString() {
        return name;
    }
}
