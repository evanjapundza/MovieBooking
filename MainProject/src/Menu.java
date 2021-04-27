import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu
{
	private String adminUser = "ADMIN1";
	private String adminPass = "password";
	private static String currentUsername;
	private static String currentPassword;
	private static User currentUser;
	private static Map<String, String> creds = new HashMap<>();
	private static File fileName;


	private static void populateMovies(Theater theater) throws FileNotFoundException{
        ArrayList<Movie> movieText = new ArrayList<>();
        File movieData = new File("MainProject/src/movies.txt");
        Scanner movieSc = new Scanner(movieData);
        while(movieSc.hasNextLine()){
            String title = movieSc.nextLine();
            String genre = movieSc.next();
            int dateMo = movieSc.nextInt();
            int dateDay = movieSc.nextInt();
            int dateYear = movieSc.nextInt();
            Date movieDate = new Date(dateYear, dateMo, dateDay);
            Movie newMovie = new Movie(title, genre, movieDate);
            movieText.add(newMovie);
            movieSc.nextLine();
        }
        theater.setMovies(movieText);
    }

	private static void createUserObject(){
        //creating user object
        currentUser = new User(currentUsername,currentPassword);
    }
	
	public static void main(String [] args) throws IOException, FileAlreadyExistsException {
        Theater theTheater = new Theater("100 Main St.");
        populateMovies(theTheater);
		System.out.println("Welcome to the Movie Booking Program.");
		boolean keepGoing = true;
		Scanner sysSc = new Scanner (System.in);
		while (keepGoing)
		{
		    System.out.print("Please specify which type of account you are: \n"
				+ "\t (1) User \n"
				+ "\t (2) Admin    ");
            int userType = sysSc.nextInt();
            if (userType ==1)
            {
                boolean stayInUser = true;
                while (stayInUser)
                {
                    System.out.print("Welcome! Do you already have an account?\n"
                            + "\t(1) Yes, log me in. \n"
                            + "\t(2) No, I would like to make an account.");
                    int userAcctChoice = sysSc.nextInt();
                    if (userAcctChoice == 1)
                    {
                        boolean loggingIn = true;
                        while(loggingIn)
                        {
                            System.out.print("Enter your username: ");
                            String userUsername = sysSc.next();
                            currentUsername = userUsername;
                            System.out.print("Enter your password: ");
                            String userPass = sysSc.next();
                            currentPassword = userPass;
                            File toDeleteFile = new File("MainProject/UserFolder/" + userUsername + userPass + ".txt");
                            fileName = toDeleteFile;

                            if(fileName.exists())
                            {
                                stayInUser = false;
                                loggingIn = false;
                            }
                            else
                            {
                                System.out.println("Error: Invalid username or password.");
                            }
                        }
                    }
                    else if (userAcctChoice == 2)
                    {
                        System.out.print("Enter your new username: ");
                        String newUsername = sysSc.next();
                        System.out.print("Enter your new password: ");
                        String newPass = sysSc.next();
                        File userFile = new File("MainProject/UserFolder/" + newUsername + newPass + ".txt");
                        FileWriter userWriter = new FileWriter(userFile, true);
                        fileName = userFile;
                        if(creds.containsKey(newUsername))
                        {
                            System.out.println("Error: That username is taken!");
                        }
                        else
                        {
                            userWriter.write(newUsername + "   " + newPass + "\n");
                            userWriter.close();
                            stayInUser = false;
                        }
                    }
                    else
                    {
                        System.out.println("Please enter a valid command. \n");
                    }
                }
                boolean userMenu = true;
                while(userMenu)
                {
                    //creating user object
                    createUserObject();
                    System.out.print("What would you like to do today? \n"
                            + "\t (1) View my history \n"
                            + "\t (2) Browse movies \n"
                            + "\t (3) View tickets \n"
                            + "\t (4) Sign out \n"
                            + "\t (5) Delete account");
                    int userAction = sysSc.nextInt();
                    if(userAction == 1)
                    {
                        if(currentUser.getPastTix().size()==0){
                            System.out.println("No history available");
                        }
                        else{
                            System.out.println("Ticket History: \n");
                            for(Ticket t: currentUser.getPastTix()){
                                System.out.println(t.toString());
                            }
                        }
                    }
                    else if(userAction == 2)
                    {
                        boolean stayInMovieList = true;
                        while(stayInMovieList) {
                            System.out.println();
                            for (int i = 0; i < theTheater.getMovies().size(); i++){
                                System.out.println("(" + theTheater.getMovies().get(i).getID() + ") Title: " +
                                        theTheater.getMovies().get(i).getTitle());
                            }
                            System.out.print("\n Enter the corresponding number to the movie you wish to view more of.\n\t" +
                                    "Or, enter -1 to search for a movie, or -2 to quit:  ");
                            int browseAction = sysSc.nextInt();
                            if (browseAction <0){
                                if (browseAction == -1){
                                    //SEARCH
                                    System.out.println("IN SEARCH :)))");
                                    int searchOption = 0;
                                    //TODO make sure to add ratings as a search option when that is finished
                                    System.out.println("What would you like to search by?" +
                                            "\n (1) Title" +
                                            "\n (2) Genre");
                                    searchOption = sysSc.nextInt();
                                    sysSc.nextLine();
                                    if (searchOption == 1) {
                                        System.out.print("Enter the title you would like to search for: ");
                                        String userSearchTitle = sysSc.nextLine();

                                        for (int c = 0; c < theTheater.getMovies().size(); c++) {
                                            if (theTheater.getMovies().get(c).getTitle().equals(userSearchTitle)) {
                                                System.out.println(theTheater.getMovies().get(c).toString());
                                            }
                                        }

                                    }
                                    else if (searchOption == 2) {
                                        System.out.print("Enter the title you would like to search for: ");
                                        String userSearchGenre = sysSc.nextLine();

                                        for (int c = 0; c < theTheater.getMovies().size(); c++) {
                                            if (theTheater.getMovies().get(c).getGenre().equals(userSearchGenre)) {
                                                System.out.println(theTheater.getMovies().get(c).toString());
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                for (int j = 0; j < theTheater.getMovies().size(); j++){
                                    if (browseAction == theTheater.getMovies().get(j).getID()){
                                        System.out.println("\n"+theTheater.getMovies().get(j).toString() + "\n");
                                    }
                                }
                            }
                            stayInMovieList = false;
                        }
                    }
                    else if(userAction == 3)
                    {
                        if(currentUser.getCurrentTix().size()==0){
                            System.out.println("You have no tickets");
                        }
                        else{
                            System.out.println("Tickets: \n");
                            for(Ticket t: currentUser.getCurrentTix()){
                                System.out.println(t.toString());
                            }
                        }
                    }
                    else if(userAction == 4)
                    {
                        userMenu = false;
                        keepGoing = false;
                    }
                    else if(userAction == 5)
                    {
                        fileName.delete();
                        System.out.println("Deleted account!");
                        userMenu = false;
                        keepGoing = false;
                    }
                }
            }
            else if (userType == 2)
            {
                boolean stayInAdmin = true;
                while (stayInAdmin)
                {
                    System.out.print("USERNAME: ");
                    String enteredUsername = sysSc.next();
                    System.out.print("PASSWORD: ");
                    String enteredPass = sysSc.next();
                    if (enteredUsername.equals("ADMIN1") && enteredPass.equals("password"))
                    {
                        System.out.println("Select Command you wish to perform: \n"
                                + "\t(1) Post new movie \n"
                                + "\t(2) Edit details of existing movie \n"
                                + "\t(3) Sign Out");
                        int adminFunc = sysSc.nextInt();
                        sysSc.nextLine();
                        //Implement posting new movie
                        if (adminFunc == 1)
                        {
                            System.out.println("What is the title of the movie you would like to input?");
                            String movieTitle = sysSc.next();
                            System.out.println("What is the genre of the movie you would like to input?");
                            String movieGenre = sysSc.next();
                            System.out.println("What is the release date of the movie you would like to input? (Enter month, then day, then year)");
                            int movieMonth = sysSc.nextInt();
                            int movieDay = sysSc.nextInt();
                            int movieYear = sysSc.nextInt();

                            Date releaseDate = new Date(movieYear, movieMonth, movieDay);

                            Movie postNewMovie = new Movie(movieTitle, movieGenre, releaseDate);
                            //System.out.println(postNewMovie.toString());
                            theTheater.addMovie(postNewMovie);
                        }
                        //Implement editing details of movie
                        else if (adminFunc==2)
                        {

                        }
                        else if (adminFunc == 3)
                        {
                            System.out.println("Signing Out.\n");
                            System.out.println("______________________________________\n");
                            stayInAdmin = false;
                            keepGoing = false;
                        }
                        else
                        {
                            System.out.println("Please enter a valid command.");
                        }
                    }
                    else
                    {
                        System.out.println("Error: Incorrect Admin username or password.");
                    }
                }
		    }
	    }
	}
}
