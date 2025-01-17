package Vehicle;

import Booking.Status;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Car {
    private final String type;
    private final String make;
    private final String model;
    private final int year;
    private final String licensePlate;
    private final double rentalPricePerDay;
    private Enum status;
    private final Map<LocalDate, Boolean> availability = new HashMap<>();

    public Car(String type,String make, String model, int year, String licensePlate, double rentalPricePerDay) {
        this.type = type;
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.rentalPricePerDay = rentalPricePerDay;
        this.status = Status.AVAILABLE;
    }

    public boolean isAvailable(LocalDate startDate, LocalDate endDate){
        for(LocalDate date = startDate; !date.isAfter(endDate); date= date.plusDays(1)){
            if (availability.getOrDefault(date,true)==false) {
                return false;
            }
        }
        return true;
    }

    public void markAvailable(LocalDate startDate, LocalDate endDate){
        for(LocalDate date = startDate; !date.isAfter(endDate); date= date.plusDays(1)){
            availability.put(date,true);
        }
        this.status= Status.AVAILABLE;
    }

    public void markUnavailable(LocalDate startDate, LocalDate endDate){
        for(LocalDate date = startDate; !date.isAfter(endDate); date= date.plusDays(1)){
            availability.put(date,false);
        }
        this.status= Status.UNAVAILABLE;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Enum getStatus() {
        return status;
    }

    public String getType(){
        return type;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                ", type='" + type + '\'' +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", available=" + status +
                '}';
    }
}
