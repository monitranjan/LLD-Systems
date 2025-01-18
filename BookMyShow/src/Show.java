import java.util.ArrayList;
import java.util.List;

public class Show {
    private int showId;
    private Movie movie;
    private Screen screen;
    private int startTime;
    private List<Integer> bookingIDs = new ArrayList<>();

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public List<Integer> getBookingIDs() {
        return bookingIDs;
    }

    public void setBookingIDs(List<Integer> bookingIDs) {
        this.bookingIDs = bookingIDs;
    }
}
