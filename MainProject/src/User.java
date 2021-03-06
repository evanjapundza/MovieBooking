/*
 *  Class: C212 Introduction to Software Systems
 *  Assignment: Project(Movie Booking Application)
 *  Group Number: 27
 *  Group Members: Collin Rassel, Evan Japundza, Maouloune Goumballe, and Spencer Chambers
 *  Due Date: April 30, 2021
 */

import java.util.ArrayList;

public class User extends Account{
	
	//instance variables
	private ArrayList<Ticket> pastTix; //list of tickets from the past
	private ArrayList<Ticket> currentTix; //list of available tickets user has
	
	//Constructor
	public User(String username, String password)
	{
		super(username,password);
		//initializes instance variables
		this.pastTix = new ArrayList<>();
		this.currentTix = new ArrayList<>();
	}
	
	//getters and setters
	public ArrayList<Ticket> getPastTix()
	{
		return pastTix;
	}

	public void setPastTix(ArrayList<Ticket> pastTix)
	{
		this.pastTix = pastTix;
	}

	public ArrayList<Ticket> getCurrentTix()
	{
		return currentTix;
	}

	public void setCurrentTix(ArrayList<Ticket> currentTix)
	{
		this.currentTix = currentTix;
	}

	//other methods
	public String getHistory()
	{
		//returns all movies watched in readable String format
		String ret = "";
		for(Ticket t: pastTix) //prints all movies from pastTix
		{
			ret += t.getMovie().toString() + "\n";
		}
		return ret;
	}

	public void buyTicket(Ticket ticket)
	{
		//updates currentTix list once user buys Ticket
		currentTix.add(ticket);
	}
	
	public String viewTickets()
	{
		//returns currentTix in readable string format
		String ret = "";
		for(Ticket t: currentTix)
		{
			ret += t.toString() + "\n";
		}
		return ret;
	}
}
