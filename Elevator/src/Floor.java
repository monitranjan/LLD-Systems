public class Floor {
    int floorNumber;
    ExternalButton externalButton;

    public Floor(int floorId){
        this.floorNumber = floorId;
        externalButton = new ExternalButton();
    }

    void pressButton(Direction direction){
        externalButton.submitRequest(floorNumber,direction);
    }
}
