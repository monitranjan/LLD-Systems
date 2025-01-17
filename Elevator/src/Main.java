import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create floors
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            floors.add(new Floor(i));
        }

        // Create a building with floors
        Building building = new Building(floors);

        // Initialize the elevators
        ElevatorCreator.initializeElevators();

        // Create dispatchers
        ExternalDispatcher externalDispatcher = new ExternalDispatcher();
        InternalDispatcher internalDispatcher = new InternalDispatcher();

        // Submit external requests (odd-even strategy)
        System.out.println("Submitting external requests...");
        externalDispatcher.submitExternalRequest(3, Direction.UP);  // Should be handled by elevatorCar1 (odd)
        externalDispatcher.submitExternalRequest(7, Direction.DOWN); // Should be handled by elevatorCar1 (odd)
        externalDispatcher.submitExternalRequest(0, Direction.UP);  // Should be handled by elevatorCar2 (even)
        externalDispatcher.submitExternalRequest(5, Direction.DOWN);

        // Submit internal requests
        System.out.println("Submitting internal requests...");
        ElevatorCar elevatorCar1 = ElevatorCreator.elevatorControllerList.get(0).elevatorCar;
        internalDispatcher.submitInternalRequest(8, elevatorCar1);  // Internal request for elevatorCar1

        ElevatorCar elevatorCar2 = ElevatorCreator.elevatorControllerList.get(1).elevatorCar;
        internalDispatcher.submitInternalRequest(2, elevatorCar2);  // Internal request for elevatorCar2

        // Start controlling the elevators
        new Thread(() -> {
            for (ElevatorController controller : ElevatorCreator.elevatorControllerList) {
                controller.controlElevator();
            }
        }).start();
    }
}
