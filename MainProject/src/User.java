import java.util.ArrayList;

public class User extends Account{
	
	//instance variables
	private ArrayList<Ticket> pastTix; //list of tickets from the past
	private ArrayList<Ticket> currentTix; //list of available tickets
	
	//Constructor
	public User(String username, String password) {
		super(username,password);
		//initializes instance variables
	}
	
	//getters and setters
	
	public ArrayList<Ticket> getPastTix() {
		return pastTix;
	}

	public void setPastTix(ArrayList<Ticket> pastTix) {
		this.pastTix = pastTix;
	}

	public ArrayList<Ticket> getCurrentTix() {
		return currentTix;
	}

	public void setCurrentTix(ArrayList<Ticket> currentTix) {
		this.currentTix = currentTix;
	}

	//other methods
	public String getHistory() {
		//returns all movies watched in readable String format
		return"";
	}
	public void buyTicket(Ticket ticket) {
		//updates currentTix list once user buys Ticket
	}
	
	public String viewTickets(){
		//returns currentTix in readable string format
		return"";
	}
	
	public String browseMovies() {
		//returns list of available movies from Theater class in readable string format
		return"";
	}

}
