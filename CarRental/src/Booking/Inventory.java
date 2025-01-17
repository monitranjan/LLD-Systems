package Booking;

import Vehicle.Car;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {
    private static Inventory instance;
    private List<Car> cars;

    private Inventory(){
        cars = new ArrayList<>();
    }

    public static synchronized Inventory getInstance(){
        if(instance == null){
            return  new Inventory();
        }
        return instance;
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public List<Car> getCars(){
        return cars;
    }

    public List<Car> searchByType(String type){
        return cars.stream().filter(car -> car.getType().equalsIgnoreCase(type)).collect(Collectors.toList());
    }

    public List<Car> searchByAvailability(LocalDate startDate, LocalDate endDate){
        return cars.stream().filter(car -> car.isAvailable(startDate,endDate)).collect(Collectors.toList());
    }

    public List<Car> searchByPriceRange(double minPrice, double maxPrice){
        return cars.stream().filter(car -> car.getRentalPricePerDay()>=minPrice && car.getRentalPricePerDay()<=maxPrice).collect(Collectors.toList());
    }

    public Car getCarByLicensePlate(String licenseNumber) {
        return cars.stream()
                .filter(car -> car.getLicensePlate().equalsIgnoreCase(licenseNumber))
                .findFirst()
                .orElse(null);
    }


    public List<Car> search(String type,LocalDate startDate, LocalDate endDate,double minPrice, double maxPrice){
        return cars.stream()
                .filter(car -> car.getType().equalsIgnoreCase(type))
                .filter(car -> car.isAvailable(startDate,endDate))
                .filter(car -> car.getRentalPricePerDay()>=minPrice && car.getRentalPricePerDay()<=maxPrice)
                .collect(Collectors.toList());
    }

    public boolean isAvailable(String licensePlate, LocalDate startDate, LocalDate endDate){
        return cars.stream().filter(car -> car.getLicensePlate().equals(licensePlate))
                .anyMatch(car -> car.isAvailable(startDate,endDate));
    }

    // Update availability for modifying reservations
    public void updateAvailability(String licensePlate, LocalDate startDate, LocalDate endDate, Enum status) {
        Car car = getCarByLicensePlate(licensePlate);
        if (car != null && Status.AVAILABLE == status) {
            car.markAvailable(startDate, endDate);
        } else if (car != null && Status.UNAVAILABLE == status) {
            car.markUnavailable(startDate, endDate);
        }
    }

}
