import java.util.ArrayList;

public class Movie
{
    private String title;
    private String genre;
    private Date releaseDate;
    private ArrayList<String> cast;
    private String description;
    private ArrayList<Double> ratings;
    private Boolean isRunning;

    //constructor for movie objects
    public Movie(String title, String genre, Date relDate)
    {

    }

    //generate getters and setters for all instance variables
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public ArrayList<String> getCast()
    {
        return cast;
    }

    public void setCast(ArrayList<String> cast)
    {
        this.cast = cast;
    }

    public Date getReleaseDate()
    {
        return releaseDate;
    }

    public void setDate(Date date)
    {
        this.releaseDate = date;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    //return the average of the arraylist of ratings to give the average rating
    public double getAverageRating()
    {
        return 0.0;
    }

    //allow the user to add a rating of the movie, must be between 0 and 5, add constraints
    public void addRating(Double rating)
    {
        ratings.add(rating);
    }

    //determine whether or not the movie is running
    public Boolean isRunning()
    {
        return isRunning;
    }

    //allow admin to stop running the movie
    public void setRunning(Boolean running)
    {
        isRunning = running;
    }

    //override the toString method to return formatted movie strings
    public String toString()
    {
        return "";
    }
}
