/*
 *  Class: C212 Introduction to Software Systems
 *  Assignment: Project(Movie Booking Application)
 *  Group Number: 27
 *  Group Members: Collin Rassel, Evan Japundza, Maouloune Goumballe, and Spencer Chambers
 *  Due Date: April 30, 2021
 */

import java.util.ArrayList;

public class Theater
{
    private ArrayList<Movie> movies;
    private String address;

    public Theater(String address)
    {
        this.address = address;
        this.movies = new ArrayList<>();
    }

    //return address of theater
    public String getAddress()
    {
        return address;
    }

    public void setMovies(ArrayList<Movie> newList)
    {
        this.movies = newList;
    }

    public ArrayList<Movie> getMovies()
    {
        return this.movies;
    }

    public void setAddress(String address)
    {
        //set address of theater
    	this.address = address;
    }

    public void addMovie(Movie movie)
    {
        movies.add(movie);
    }

    public void showAvailableMovies()
    {
        //show all movies available to be played
    	System.out.println("Available Movies: ");
    	for(Movie m:movies)
    	{
    		System.out.println(m.toString() + "\n");
    	}
    }

}
