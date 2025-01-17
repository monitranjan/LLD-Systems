import java.util.ArrayList;
import java.util.List;

public class ElevatorCreator {

    public static List<ElevatorController> elevatorControllerList = new ArrayList<>();

    public static void initializeElevators() {
        ElevatorCar elevatorCar1 = new ElevatorCar();
        elevatorCar1.id = 1;
        ElevatorController elevatorController1 = new ElevatorController(elevatorCar1);

        ElevatorCar elevatorCar2 = new ElevatorCar();
        elevatorCar2.id = 2;
        ElevatorController elevatorController2 = new ElevatorController(elevatorCar2);

        elevatorControllerList.add(elevatorController1);
        elevatorControllerList.add(elevatorController2);
    }
}
