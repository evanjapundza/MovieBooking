/*
 *  Class: C212 Introduction to Software Systems
 *  Assignment: Project(Movie Booking Application)
 *  Group Number: 27
 *  Group Members: Collin Rassel, Evan Japundza, Maouloune Goumballe, and Spencer Chambers
 *  Due Date: April 30, 2021
 */

import java.util.*;

public class Ticket
{

    private String location;
    private Movie movie;
    private Date showdate;
    private String showtime;
    private ArrayList<User> viewers;
    private int seatNum;

    public Ticket(String location, Movie movie, Date showdate, String showtime, int seatNum)
    {
        this.location = location;
        this.movie = movie;
        this.showdate = showdate;
        this.showtime = showtime;
        this.seatNum = seatNum;
        viewers = new ArrayList<>();
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public Movie getMovie()
    {
        return movie;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }

    public Date getShowdate()
    {
        return showdate;
    }

    public void setShowdate(Date showdate)
    {
        this.showdate = showdate;
    }

    public String getShowtime()
    {
        return showtime;
    }

    public void setShowtime(String showtime)
    {
        this.showtime = showtime;
    }

    public ArrayList<User> getViewers()
    {
        return viewers;
    }

    public void setViewers(ArrayList<User> viewers)
    {
        this.viewers = viewers;
    }

    public int getSeatNum()
    {
        return seatNum;
    }

    public void setSeatNum(int seatNum)
    {
        this.seatNum = seatNum;
    }

    @Override
    public String toString()
    {
        return this.movie.getTitle() + "\n" + this.movie.getGenre() + "\n" + this.movie.getReleaseDate().getMonth() + " " + this.movie.getReleaseDate().getDay()
                + " " + this.movie.getReleaseDate().getYear() +"\n"
                + this.showtime + "\n" + showdate.getMonth() + " " + showdate.getDay() + " " + showdate.getYear()
                + "\n" + seatNum;
    }

    public String formattedToString()
    {
        return "Movie : " + this.movie.getTitle() + " Show Date: " + this.showdate.getMonth() + "/" + this.showdate.getDay()
                 + "/" + this.showdate.getYear() + " Show Time: " + this.showtime + " Seat Number: " + this.seatNum;
    }
}
