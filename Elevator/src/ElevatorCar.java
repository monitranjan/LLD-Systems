public class ElevatorCar {
    int id;
    ElevatorDisplay display;
    InternalButtons internalButtons;
    ElevatorState elevatorState;
    int currentFloor;
    Direction elevatorDirection;
    ElevatorDoor elevatorDoor;

    public ElevatorCar(){
        display = new ElevatorDisplay();
        internalButtons = new InternalButtons();
        elevatorState = ElevatorState.IDLE;
        currentFloor = 0;
        elevatorDirection = Direction.UP;
        elevatorDoor = new ElevatorDoor();
    }

    public void showDisplay(){
        display.showDisplay();
    }

    public void pressButton(int destination){
        internalButtons.pressButton(destination, this);
    }

    public void setDisplay(){
        this.display.setDisplay(currentFloor,elevatorDirection);
    }

    boolean moveElevator(Direction dir, int destinationFloor) {
        if (dir == Direction.UP) {
            for (int i = currentFloor + 1; i <= destinationFloor; i++) {
                this.currentFloor = i;
                setDisplay();
                showDisplay();
                if (i == destinationFloor) {
                    return true;
                }
            }
        } else if (dir == Direction.DOWN) {
            for (int i = currentFloor - 1; i >= destinationFloor; i--) {
                this.currentFloor = i;
                setDisplay();
                showDisplay();
                if (i == destinationFloor) {
                    return true;
                }
            }
        }
        return false;
    }

}

