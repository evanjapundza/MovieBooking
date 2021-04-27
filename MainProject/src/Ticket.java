import java.util.*;

public class Ticket {

    private String location;
    private Movie movie;
    private Date showdate;
    private String showtime;
    private ArrayList<User> viewers;
    private int seatNum;
    //private Boolean userWatched;


    public Ticket(String location, Movie movie, Date showdate, String showtime, int seatNum) {
        this.location = location;
        this.movie = movie;
        this.showdate = showdate;
        this.showtime = showtime;
        this.seatNum = seatNum;
        viewers = new ArrayList<>();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getShowdate() {
        return showdate;
    }

    public void setShowdate(Date showdate) {
        this.showdate = showdate;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    public ArrayList<User> getViewers() {
        return viewers;
    }

    public void setViewers(ArrayList<User> viewers) {
        this.viewers = viewers;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }


    @Override
    public String toString() {
        //generated toString
        return "Ticket{" +
                "location='" + location + '\'' +
                ", movie=" + movie +
                ", showdate=" + showdate +
                ", showtime='" + showtime + '\'' +
                ", viewers=" + viewers +
                ", seatNum=" + seatNum +
                '}';
    }

    public void hasUserWatched() {
        //sets a boolean to keep track whether or not the user has watched a specific movie tied to ticket
    }



}
