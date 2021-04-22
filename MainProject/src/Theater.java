import java.util.ArrayList;

public class Theater
{
    private ArrayList<Movie> movies;
    private String address;

    public Theater(String address)
    {

        this.address = address;
        movies = new ArrayList<>();
    }

    //return address of theater
    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        //set address of theater
    	this.address = address;
    }



    public void showAvailableMovies()
    {
        //show all movies available to be played
    	System.out.println("Available Movies: ");
    	for(Movie m:movies) { //using toString() method to display available movies
    		System.out.println(m.toString() + "\n");
    	}
    }

}
