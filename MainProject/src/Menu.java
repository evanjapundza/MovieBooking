import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
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
	private static Map<String, String> creds = new HashMap<>();
	//private static File fileName;


	private static void populateMovies(Theater theater) throws FileNotFoundException{
        ArrayList<Movie> movieText = new ArrayList<>();
        File movieData = new File("MainProject/src/movies.txt");
        Scanner movieSc = new Scanner(movieData);
        while(movieSc.hasNextLine()){
            String title = movieSc.next();
            String genre = movieSc.next();
            int dateMo = movieSc.nextInt();
            int dateDay = movieSc.nextInt();
            int dateYear = movieSc.nextInt();
            Date movieDate = new Date(dateYear, dateMo, dateDay);
            Movie newMovie = new Movie(title, genre, movieDate);
            movieText.add(newMovie);
        }
        theater.setMovies(movieText);
    }

	private static void populateUsers()
    {
        try
        {
            File userCred = new File("MainProject/src/Users.txt");
            Scanner in = new Scanner(userCred);
            while(in.hasNextLine())
            {
                String username = in.next();
                String password = in.next();
                creds.put(username, password);
                in.nextLine();
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
	}
	
	public static void main(String [] args) throws IOException
    {
        Theater theTheater = new Theater("100 Main St.");
        populateUsers();
        File userFile = new File("MainProject/src/Users.txt");
        FileWriter out = new FileWriter (userFile, true);
		System.out.println("Welcome to the Movie Booking Program.");
		boolean keepGoing = true;
		Scanner sysSc = new Scanner (System.in);
		while (keepGoing)
		{
			//FileWriter out = new FileWriter (userFile, true);
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
                            populateUsers();
                            System.out.print("Enter your username: ");
                            String userUsername = sysSc.next();
                            currentUsername = userUsername;
                            System.out.print("Enter your password: ");
                            String userPass = sysSc.next();
                            currentPassword = userPass;
                            if (creds.containsKey(userUsername) && creds.containsValue(userPass))
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
                        if(creds.containsKey(newUsername))
                        {
                            System.out.println("Error: That username is taken!");
                        }
                        else
                        {
                            out.write(newUsername + "   " + newPass + "\n");
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
                    System.out.print("What would you like to do today? \n"
                            + "\t (1) View my history \n"
                            + "\t (2) Browse movies \n"
                            + "\t (3) View tickets \n"
                            + "\t (4) Sign out \n"
                            + "\t (5) Delete account");
                    int userAction = sysSc.nextInt();
                    if(userAction == 1)
                    {

                    }
                    else if(userAction == 2)
                    {

                    }
                    else if(userAction == 3)
                    {

                    }
                    else if(userAction == 4)
                    {
                        userMenu = false;
                        keepGoing = false;
                    }
                    else if(userAction == 5)
                    {
                        //how to delete users from the txt file
                        out.flush();
                        out.close();
                        creds.remove(currentUsername);
                        File tmpFile = new File("MainProject/src/tmpFile.txt");
                        FileWriter tmpWriter = new FileWriter (tmpFile, false);
                        for(String userName : creds.keySet())
                        {
                            tmpWriter.write(userName + "   " + creds.get(userName) + "\n");
                        }
                        tmpWriter.flush();
                        tmpWriter.close();

                        try {
                            Files.delete(Path.of("MainProject/src/Users.txt"));
                        } catch (NoSuchFileException x) {
                            System.err.format("%s: no such" + " file or directory%n", Path.of("MainProject/src/Users.txt"));
                        } catch (DirectoryNotEmptyException x) {
                            System.err.format("%s not empty%n", Path.of("MainProject/src/Users.txt"));
                        } catch (IOException x) {
                            // File permission problems are caught here.
                            System.err.println(x);
                        }


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
                            System.out.println(postNewMovie.toString());
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
		out.close();
	    }
	}
}
