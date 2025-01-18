import java.util.List;

public class Theatre {
    private int theatreID;
    private String address;
    private City city;
    private List<Screen> screenList;
    private List<Show> shows;

    public int getTheatreID() {
        return theatreID;
    }

    public String getAddress() {
        return address;
    }

    public City getCity() {
        return city;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setTheatreID(int theatreID) {
        this.theatreID = theatreID;
    }

    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
