import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TheaterController {
    private Theatre theatre;
    private Map<City, List<Theatre>> theaterCity;
    List<Theatre> allTheatre;

    public TheaterController(){
        theaterCity = new HashMap<>();
        allTheatre = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre, City city) {
        allTheatre.add(theatre);
        List<Theatre> theatres = theaterCity.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        theaterCity.put(city, theatres);
    }

    public Map<Theatre,List<Show>> getAllShow(Movie movie,City city){
        List<Theatre> theatres = theaterCity.get(city);
        // Create a map to store theatres and their respective shows running the given movie
         Map<Theatre, List<Show>> theatreShows = theatres.stream()
                 .filter(theatre -> theatre.getShows().stream()
                         .anyMatch(show -> show.getMovie().getMovieId()==movie.getMovieId()))
                         .collect(Collectors.toMap(theatre -> theatre, theatre -> theatre.getShows().stream()
                                 .filter(show -> show.getMovie().getMovieId()==(movie.getMovieId()))
                                 .collect(Collectors.toList()) ));
         return theatreShows;
    }

}
