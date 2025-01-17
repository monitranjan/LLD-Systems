public class ExternalButton {
    ExternalDispatcher externaldispatcher;

    ExternalButton() {
        externaldispatcher = new ExternalDispatcher();
    }

    public void submitRequest(int floorNumber, Direction direction) {
        externaldispatcher.submitExternalRequest(floorNumber, direction);
    }
}
