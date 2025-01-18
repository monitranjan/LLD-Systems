public class Movie {
    private String name;
    private int id;
    private int duration;

    public Movie(String name, int id, int duration){
        this.duration = duration;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    public int getMovieId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
