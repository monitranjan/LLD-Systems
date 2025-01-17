package Vehicle;

public class CarFactory {
    public static Car createCar(String type, String make, String model, int year, String licensePlate, double price){
        switch (type.toLowerCase()){
            case "sedan":
                return new Sedan(make,model,year,licensePlate,price);
            case "suv":
                return new SUV(make,model,year,licensePlate,price);
            default:
                throw new IllegalArgumentException("Invalid car type");
        }
    }
}
