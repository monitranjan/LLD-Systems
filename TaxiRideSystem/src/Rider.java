public class Rider {
    private String name;
    private RATING rating;

    public Rider(String name, RATING rating) {
        this.name = name;
        this.rating = rating;
    }

    public RATING getRating() {
        return this.rating;
    }

    public String getName() {
        return name;
    }

}
