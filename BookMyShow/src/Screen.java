import java.util.List;

public class Screen {
    private int Id;
    List<Seat> seats;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
