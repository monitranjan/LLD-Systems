import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieController movieController;
    TheaterController theatreController;

    BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheaterController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();

        bookMyShow.initialize();

        //user1
        bookMyShow.createBooking(City.BANGALORE, "BAAHUBALI");
        //user2
        bookMyShow.createBooking(City.BANGALORE, "BAAHUBALI");

    }

    private void createBooking(City city, String movieName) {
        //1. search movie by my location
        List<Movie> movies = movieController.getMoviesByCity(city);

        //2. select the movie which you want to see. i want to see Baahubali
        Movie interestedMovie = null;
        for (Movie movie : movies) {

            if ((movie.getName()).equals(movieName)) {
                interestedMovie = movie;
            }
        }

        //3. get all show of this movie in Bangalore location
        Map<Theatre, List<Show>> showsTheatreWise = theatreController.getAllShow(interestedMovie, city);

        //4. select the particular show user is interested in
        Map.Entry<Theatre,List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        //5. select the seat
        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookingIDs();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);
            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat screenSeat : interestedShow.getScreen().getSeats()) {
                if(screenSeat.getId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");

    }

    private void initialize() {
        //create movies
        createMovies();

        //create theater with screens, seats and shows
        createTheatre();

    }

    private void createTheatre() {
        Movie avengerMovie = movieController.getMovieByName("AVENGERS");
        Movie baahubali = movieController.getMovieByName("BAAHUBALI");

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreID(1);
        inoxTheatre.setScreenList(createScreen());
        inoxTheatre.setCity(City.BANGALORE);
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(1, inoxTheatre.getScreenList().get(0), avengerMovie, 8);
        Show inoxEveningShow = createShows(2, inoxTheatre.getScreenList().get(0), baahubali, 16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShows(inoxShows);


        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheatreID(2);
        pvrTheatre.setScreenList(createScreen());
        pvrTheatre.setCity(City.MUMBAI);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3, pvrTheatre.getScreenList().get(0), avengerMovie, 13);
        Show pvrEveningShow = createShows(4, pvrTheatre.getScreenList().get(0), baahubali, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShows(pvrShows);

        theatreController.addTheatre(inoxTheatre, City.BANGALORE);
        theatreController.addTheatre(pvrTheatre, City.MUMBAI);

    }

    private void createMovies() {
        //create Movies1
        Movie avengers = new Movie("AVENGERS",1,128);
        //create Movies2
        Movie baahubali = new Movie("BAAHUBALI",2,180);
        //add movies against the cities
        movieController.addMovie(avengers, City.BANGALORE);
        movieController.addMovie(avengers, City.MUMBAI);
        movieController.addMovie(baahubali, City.BANGALORE);
        movieController.addMovie(baahubali, City.MUMBAI);

    }

    private Show createShows(int showId, Screen screen, Movie movie, int showStartTime) {
        Show show = new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setStartTime(showStartTime); //24 hrs time ex: 14 means 2pm and 8 means 8AM
        return show;
    }

    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setId(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);
        return screens;
    }

    private List<Seat> createSeats() {

        //creating 100 seats for testing purpose, this can be generalised
        List<Seat> seats = new ArrayList<>();

        //1 to 40 : SILVER
        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat();
            seat.setId(i);
            seat.setSeatType(SeatCategory.SILVER);
            seats.add(seat);
        }

        //41 to 70 : SILVER
        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat();
            seat.setId(i);
            seat.setSeatType(SeatCategory.GOLDEN);
            seats.add(seat);
        }

        //1 to 40 : SILVER
        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat();
            seat.setId(i);
            seat.setSeatType(SeatCategory.PLATINUM);
            seats.add(seat);
        }

        return seats;
    }
}