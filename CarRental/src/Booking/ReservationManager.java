package Booking;

import Vehicle.Car;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationManager {
    private final List<Reservation> reservations = new ArrayList<>();

    // Add a new reservation
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    // Find a reservation by its ID
    public Reservation findReservationById(String reservationId) {
        return reservations.stream()
                .filter(reservation -> reservation.getReservationId().equalsIgnoreCase(reservationId))
                .findFirst()
                .orElse(null);
    }

    // Modify an existing reservation
    public boolean modifyReservation(String reservationId, LocalDate newStartDate, LocalDate newEndDate, Inventory inventory) {
        Reservation reservation = findReservationById(reservationId);
        if (reservation != null) {
            Car car = reservation.getCar();
            if (car.isAvailable(newStartDate, newEndDate)) {
                reservation.setStartDate(newStartDate);
                reservation.setEndDate(newEndDate);
                inventory.updateAvailability(car.getLicensePlate(), newStartDate, newEndDate, Status.UNAVAILABLE);
                System.out.println("Booking.Reservation modified successfully.");
                return true;
            } else {
                System.out.println("Car is not available for the new dates.");
            }
        } else {
            System.out.println("Booking.Reservation not found.");
        }
        return false;
    }

    // Cancel a reservation
    public boolean cancelReservation(String reservationId, Inventory inventory) {
        Reservation reservation = findReservationById(reservationId);
        if (reservation != null) {
            reservation.setStatus(ReservationStatus.CANCELLED);
            inventory.updateAvailability(reservation.getCar().getLicensePlate(), reservation.getStartDate(), reservation.getEndDate(), Status.AVAILABLE);
            System.out.println("Booking.Reservation canceled successfully.");
            return true;
        } else {
            System.out.println("Booking.Reservation not found.");
        }
        return false;
    }

    // View all reservations
    public List<Reservation> getAllReservations() {
        return reservations;
    }
}