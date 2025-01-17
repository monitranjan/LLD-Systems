package Booking;

import Vehicle.Car;

import java.time.LocalDate;
import java.util.UUID;

public class Reservation {
    private String reservationId;
    private Enum status;
    private final Car car;
    private final Customer customer;
    private  LocalDate startDate;
    private  LocalDate endDate;

    // Constructor
    public Reservation(Car car, Customer customer, LocalDate startDate, LocalDate endDate) {
        if (car == null || customer == null || startDate == null || endDate == null) {
            throw new IllegalArgumentException("Car, customer, start date, and end date must not be null.");
        }
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date must be before or equal to end date.");
        }
        this.car = car;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reservationId = UUID.randomUUID().toString();
        this.status = ReservationStatus.BOOKED;
    }

    // Getters
    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "car=" + car +
                ", customer=" + customer +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                '}';
    }
}
