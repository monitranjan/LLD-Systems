import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    private Map<City, List<Movie>> moviecity;
    private List<Movie> allmovies;

    public MovieController(){
        moviecity = new HashMap<>();
        allmovies = new ArrayList<>();
    }

    public void addMovie(Movie movie,City city){
        allmovies.add(movie);
        List<Movie> movies = moviecity.getOrDefault(city,new ArrayList<>());
        movies.add(movie);
        moviecity.putIfAbsent(city,movies);
    }

    public Movie getMovieByName(String name){
        return allmovies.stream().filter(movie -> movie.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Movie> getMoviesByCity(City city){
        return moviecity.get(city);
    }
}
