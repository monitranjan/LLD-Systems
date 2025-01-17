import java.util.PriorityQueue;

public class ElevatorController {
    PriorityQueue<Integer> upMinPQ;
    PriorityQueue<Integer> downMaxPQ;
    ElevatorCar elevatorCar;

    ElevatorController(ElevatorCar elevatorCar){
        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>((a,b)->b-a);
    }

    public void submitExternalRequest(int floor, Direction direction) {
        if (direction == Direction.DOWN) {
            downMaxPQ.offer(floor);
        } else {
            upMinPQ.offer(floor);
        }

        // Wake up the elevator if idle
        if (elevatorCar.elevatorDirection == Direction.IDLE) {
            elevatorCar.elevatorDirection = (floor > elevatorCar.currentFloor) ? Direction.UP : Direction.DOWN;
        }
    }


    public void submitInternalRequest(int floor) {
        if (floor > elevatorCar.currentFloor) {
            upMinPQ.offer(floor);
        } else {
            downMaxPQ.offer(floor);
        }
    }

    public void controlElevator() {
        while (true) {
            if (!upMinPQ.isEmpty() && (elevatorCar.elevatorDirection == Direction.UP || elevatorCar.elevatorDirection == Direction.IDLE)) {
                handleUpRequests();
            } else if (!downMaxPQ.isEmpty() && (elevatorCar.elevatorDirection == Direction.DOWN || elevatorCar.elevatorDirection == Direction.IDLE)) {
                handleDownRequests();
            } else if (upMinPQ.isEmpty() && downMaxPQ.isEmpty()) {
                elevatorCar.elevatorDirection = Direction.IDLE;
            }

            // Simulate some delay for elevator movement
            try {
                Thread.sleep(1000);  // Simulate elevator movement delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void handleUpRequests() {
        while (!upMinPQ.isEmpty()) {
            int nextFloor = upMinPQ.poll();
            elevatorCar.elevatorDirection = Direction.UP;
            elevatorCar.moveElevator(Direction.UP, nextFloor);
        }

        if (!downMaxPQ.isEmpty()) {
            elevatorCar.elevatorDirection = Direction.DOWN;
        } else {
            elevatorCar.elevatorDirection = Direction.IDLE;
        }
    }

    private void handleDownRequests() {
        while (!downMaxPQ.isEmpty()) {
            int nextFloor = downMaxPQ.poll();
            elevatorCar.elevatorDirection = Direction.DOWN;
            elevatorCar.moveElevator(Direction.DOWN, nextFloor);
        }

        if (!upMinPQ.isEmpty()) {
            elevatorCar.elevatorDirection = Direction.UP;
        } else {
            elevatorCar.elevatorDirection = Direction.IDLE;
        }
    }
}
