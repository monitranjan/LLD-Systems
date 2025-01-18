public class Driver {
    private String name;
    private boolean available;
    private RATING rating;

    public Driver(String name, RATING rating) {
        this.name = name;
        this.rating = rating;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public RATING getRating() {
        return rating;
    }

    public void setAvailable(boolean avail) {
        this.available = avail;
    }
}
