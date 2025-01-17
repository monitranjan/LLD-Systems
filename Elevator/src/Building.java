import java.util.List;

public class Building {
    List<Floor> floorsList;
    Building(List<Floor> floors){
        this.floorsList = floors;
    }

    public List<Floor> getAllFloorsList(){
        return this.floorsList;
    }

    public void addFloorList(Floor floor){
        this.floorsList.add(floor);
    }

    public void removeFloor(Floor floor){
        this.floorsList.remove(floor);
    }
}
