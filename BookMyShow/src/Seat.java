public class Seat {
    private SeatCategory SeatType;
    int row;
    int id;

    public SeatCategory getSeatType() {
        return SeatType;
    }

    public void setSeatType(SeatCategory seatType) {
        SeatType = seatType;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
