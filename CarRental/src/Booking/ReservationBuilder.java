package Booking;

import Vehicle.Car;

import java.time.LocalDate;

public class ReservationBuilder {
    private Car car;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;

    public ReservationBuilder setCar(Car car) {
        this.car = car;
        return this;
    }

    public ReservationBuilder setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public ReservationBuilder setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public ReservationBuilder setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public Reservation build() {
        return new Reservation(car, customer, startDate, endDate);
    }
}