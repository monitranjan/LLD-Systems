import Payment.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Show show;
    private List<Seat> bookedSeats = new ArrayList<>();
    private PaymentStrategy payment;


    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}
