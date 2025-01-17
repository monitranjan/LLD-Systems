public class Vehicle {
    private VehicleType vehicleType;
    private String color;
    private String vehicleNumber;

    public Vehicle(VehicleType vehicleType, String color, String vehicleNumber) {
        this.vehicleType = vehicleType;
        this.color = color;
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }
}