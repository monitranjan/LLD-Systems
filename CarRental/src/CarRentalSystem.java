import Booking.*;
import Payment.CreditCardPayment;
import Payment.PaymentStrategy;
import Vehicle.Car;
import Vehicle.CarFactory;

import java.time.LocalDate;
import java.util.List;

public class CarRentalSystem {
    public static void main(String[] args) {
        // Initialize Inventory
        Inventory inventory = Inventory.getInstance();
        inventory.addCar(CarFactory.createCar("sedan", "Toyota", "Camry", 2020, "ABC123", 50.0));
        inventory.addCar(CarFactory.createCar("suv", "Ford", "Explorer", 2021, "XYZ456", 80.0));
        inventory.addCar(CarFactory.createCar("sedan", "Honda", "Civic", 2022, "DEF789", 45.0));
        inventory.addCar(CarFactory.createCar("suv", "Jeep", "Cherokee", 2019, "GHI101", 70.0));

        // Initialize Concurrency Manager and Reservation Manager
        ConcurrencyManager cm = new ConcurrencyManager();
        ReservationManager reservationManager = new ReservationManager();

        // Customer Information
        Customer customer = new Customer("John Doe", "john.doe@example.com", "D1234567");

        // Search Filters
        String carType = "suv";               // Filter by car type
        double minPrice = 50.0;                // Minimum price filter
        double maxPrice = 80.0;                // Maximum price filter
        LocalDate startDate = LocalDate.of(2025, 1, 20);  // Rental start date
        LocalDate endDate = LocalDate.of(2025, 1, 25);    // Rental end date

        // Search for Cars Based on Criteria
        System.out.println("\nSearching for cars...");
        List<Car> availableCars = inventory.search(carType, startDate, endDate, minPrice, maxPrice);

        // Display Search Results
        if (!availableCars.isEmpty()) {
            System.out.println("Available cars matching criteria:");
            availableCars.forEach(System.out::println);
        } else {
            System.out.println("No cars match the search criteria.");
            return; // Exit if no cars are available
        }

        // Attempt to Reserve a Car
        String carId = availableCars.get(0).getLicensePlate(); // Get the first available car
        System.out.println("\nAttempting to reserve car " + carId + "...");
        cm.acquireLock(carId);
        Reservation reservation = null;
        try {
            if (inventory.isAvailable(carId, startDate, endDate)) {
                // Build Reservation
                reservation = new ReservationBuilder()
                        .setCar(inventory.getCarByLicensePlate(carId))
                        .setCustomer(customer)
                        .setStartDate(startDate)
                        .setEndDate(endDate)
                        .build();

                // Process Payment
                PaymentStrategy paymentStrategy = new CreditCardPayment(); // Example payment method
                paymentStrategy.pay(500);
                reservationManager.addReservation(reservation);

                // Update Inventory
                inventory.updateAvailability(carId, startDate, endDate, Status.UNAVAILABLE);

                System.out.println("Reservation successful: " + reservation);
            } else {
                System.out.println("Car is no longer available for the selected dates.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during reservation: " + e.getMessage());
        } finally {
            cm.releaseLock(carId);
        }

        if (reservation != null) {
            // Modify the reservation
            LocalDate newStartDate = LocalDate.of(2025, 1, 22);
            LocalDate newEndDate = LocalDate.of(2025, 1, 27);
            System.out.println("\nModifying reservation...");
            boolean updateRequest = reservationManager.modifyReservation(reservation.getReservationId(), newStartDate, newEndDate, inventory);

            // Cancel the reservation
            if(!updateRequest) {
                System.out.println("\nCanceling reservation...");
                reservationManager.cancelReservation(reservation.getReservationId(), inventory);
            }
        }

        // Display all reservations
        System.out.println("\nAll Reservations:");
        reservationManager.getAllReservations().forEach(System.out::println);

        // Display updated inventory
        System.out.println("\nUpdated Inventory:");
        inventory.getCars().forEach(System.out::println);
    }
}
