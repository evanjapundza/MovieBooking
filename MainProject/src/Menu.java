import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Menu
{
	private static final String adminUser = "a";
	private static final String adminPass = "p";
	private static String currentUsername;
	private static String currentPassword;
	private static User currentUser;
	private static Map<String, String> creds = new HashMap<>();
	private static File fileName;
	private static File movieFileToDelete;


//	private static void populateMovies(Theater theater) throws FileNotFoundException{
//        ArrayList<Movie> movieText = new ArrayList<>();
//        File movieData = new File("MainProject/src/movies.txt");
//        Scanner movieSc = new Scanner(movieData);
//        while(movieSc.hasNextLine()){
//            String title = movieSc.nextLine();
//            String genre = movieSc.next();
//            int dateMo = movieSc.nextInt();
//            int dateDay = movieSc.nextInt();
//            int dateYear = movieSc.nextInt();
//            Date movieDate = new Date(dateYear, dateMo, dateDay);
//            Movie newMovie = new Movie(title, genre, movieDate);
//            movieText.add(newMovie);
//            movieSc.nextLine();
//        }
//        theater.setMovies(movieText);
//    }

    public static String getAdminUser(){
        return adminUser;
    }

    public static String getAdminPass(){
        return adminPass;
    }

    public static void populateUserTix (User user) throws FileNotFoundException{
       String fileName = user.getUsername() + user.getPassword();
       File file = new File("MainProject/UserFolder/" + fileName + ".txt");
       Scanner userSc = new Scanner(file);
       int i = 0;
       while (userSc.hasNextLine()){
           if (i > 0){
               userSc.nextLine();
           }
           String tixTitle = userSc.nextLine();
           System.out.println("tixTitle = " + tixTitle);
           String tixGenre = userSc.nextLine();
           System.out.println(tixGenre);
           int tixMovMonth = userSc.nextInt();
           System.out.println(tixMovMonth);
           int tixMovDay = userSc.nextInt();
           System.out.println(tixMovDay);
           int tixMovYear = userSc.nextInt();
           System.out.println(tixMovDay);
           userSc.nextLine();
           String tixTime = userSc.nextLine();
           System.out.println(tixTime);
           int tixMonth = userSc.nextInt();
           System.out.println(tixMonth);
           int tixDay = userSc.nextInt();
           System.out.println(tixDay);
           int tixYear = userSc.nextInt();
           System.out.println(tixYear);
           int tixSeatNum = userSc.nextInt();
           System.out.println(tixSeatNum);
           userSc.nextLine();
           String isCurrent = userSc.next();
           System.out.println(isCurrent);
           if (isCurrent.equals("1")){
               Date movieRelDate = new Date(tixMovMonth, tixMovDay, tixMovYear);
               Date showDate = new Date(tixMonth, tixDay, tixYear);
               Movie newMovie = new Movie(tixTitle, tixGenre, movieRelDate);
               Ticket newTix = new Ticket("The Theater", newMovie, showDate, tixTime, tixSeatNum);
               user.getCurrentTix().add(newTix);
           }
           i++;
       }


    }


    private static void populateMovies(Theater theater) throws FileNotFoundException {
        ArrayList<Movie> movieList = new ArrayList<>();
        Scanner movieListSc = new Scanner(new File("MainProject/src/movieList.txt"));
        while (movieListSc.hasNextLine()){
            String rawTitle = movieListSc.nextLine();
            String strippedTitle = rawTitle.replaceAll("\\s", "");
            File filePath = new File("MainProject/MoviesFolder/" + strippedTitle);
            if (filePath.exists()){
                Scanner movieSc = new Scanner(filePath);
                String title = movieSc.nextLine();
                String genre = movieSc.nextLine();
                int dateMo = movieSc.nextInt();
                int dateDay = movieSc.nextInt();
                int dateYear = movieSc.nextInt();
                Date movieDate = new Date(dateYear, dateMo, dateDay);
                Movie newMovie = new Movie(title, genre, movieDate);
                int counter = 0;
                double total = 0;
                while(movieSc.hasNextDouble())
                {
                    total += movieSc.nextDouble();
                    counter++;
                }
                double result = total/counter;
                newMovie.setRating(result);
                movieList.add(newMovie);
            }
        }
        theater.setMovies(movieList);
        System.out.println(movieList);
    }

	private static void createUserObject()
    {
        //creating user object using key and value from ma
        currentUser = new User(currentUsername, currentPassword);
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
                            createUserObject();
                            File toDeleteFile = new File("MainProject/UserFolder/" + userUsername + ".txt");
                            fileName = toDeleteFile;
                            if(fileName.exists())
                            {
                                Scanner readCreds = new Scanner(fileName);
                                readCreds.next();
                                String password = readCreds.next();
                                if(currentPassword.equals(password))
                                {
                                    stayInUser = false;
                                    loggingIn = false;
                                }
                                else
                                {
                                    System.out.println("Error: Invalid username or password");
                                }
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
                        createUserObject();
                        File userFile = new File("MainProject/UserFolder/" + newUsername + ".txt");
                        fileName = userFile;
                        if(userFile.exists())
                        {
                            System.out.println("Error: That username is taken!");
                        }
                        else
                        {
                            FileWriter userWriter = new FileWriter(userFile, true);
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
                        while(stayInMovieList)
                        {
                            System.out.println();
                            for (int i = 0; i < theTheater.getMovies().size(); i++)
                            {

                                //System.out.println(theTheater.getMovies().get(i).getRating());
                                System.out.print("(" + theTheater.getMovies().get(i).getID() + ") Title: " +
                                        theTheater.getMovies().get(i).getTitle());
                                if(Double.isNaN(theTheater.getMovies().get(i).getRating())) {
                                    System.out.print(" | No ratings available");
                                } else {
                                    System.out.printf(" | Rating: %.2f out of 5", theTheater.getMovies().get(i).getRating());
                                }
                                System.out.println();
                            }
                            System.out.print("\n Enter the corresponding number to the movie you wish to view more of.\n\t" +
                                    "Or, enter -1 to search for a movie, -2 to buy a ticket, or -3 to quit:  ");
                            int browseAction = sysSc.nextInt();
                            if (browseAction <0)
                            {
                                if (browseAction == -1)
                                {
                                    //SEARCH
                                    //System.out.println("IN SEARCH :)))");
                                    int searchOption = 0;
                                    //TODO make sure to add ratings as a search option when that is finished
                                    System.out.println("What would you like to search by?" +
                                            "\n (1) Title" +
                                            "\n (2) Genre" +
                                            "\n (3) Ratings");
                                    searchOption = sysSc.nextInt();
                                    sysSc.nextLine();
                                    if (searchOption == 1)
                                    {
                                        System.out.print("Enter the title you would like to search for: ");
                                        String userSearchTitle = sysSc.nextLine();

                                        for (int c = 0; c < theTheater.getMovies().size(); c++)
                                        {
                                            if (theTheater.getMovies().get(c).getTitle().equals(userSearchTitle))
                                            {
                                                System.out.println(theTheater.getMovies().get(c).toString());
                                            }
                                        }

                                    }
                                    else if (searchOption == 2)
                                    {
                                        System.out.print("Enter the genre you would like to search for: ");
                                        String userSearchGenre = sysSc.nextLine();

                                        for (int c = 0; c < theTheater.getMovies().size(); c++)
                                        {
                                            if (theTheater.getMovies().get(c).getGenre().equals(userSearchGenre))
                                            {
                                                System.out.println(theTheater.getMovies().get(c).toString());
                                            }
                                        }
                                    }
                                    else if(searchOption == 3)
                                    {
                                        System.out.println("What is your minimum rating?");
                                        double minRating = sysSc.nextDouble();
                                        for(int i = 0; i < theTheater.getMovies().size(); i++)
                                        {
                                            if(theTheater.getMovies().get(i).getRating() >= minRating)
                                            {
                                                System.out.println(theTheater.getMovies().get(i).toString());
                                            }
                                        }
                                    }
                                }
                                else if(browseAction == -3)
                                {
                                    stayInMovieList = false;
                                }
                                else if(browseAction == -2)
                                {
                                    System.out.println("What movie would you like to purchase a ticket for?");
                                    for (int i = 0; i < theTheater.getMovies().size(); i++)
                                    {
                                        System.out.println("(" + theTheater.getMovies().get(i).getID() + ") Title: " +
                                                theTheater.getMovies().get(i).getTitle());
                                    }
                                    int movieChoice = sysSc.nextInt();
                                    for (int j = 0; j < theTheater.getMovies().size(); j++) {
                                        if (movieChoice == theTheater.getMovies().get(j).getID()) {
                                            // display a handful of dates / times
                                            Random rn = new Random();
                                            System.out.println("Pick a date and time.");
                                            ArrayList<Date> dates = new ArrayList<>();
                                            ArrayList<String> times = new ArrayList<>();
                                            int month = 0;
                                            int day = 0;
                                            int year = 0;
                                            String showTime = "";
                                            for (int i = 0; i < 5; i++) {
                                                month = (1 + rn.nextInt(13));
                                                day = (1 + rn.nextInt(30));
                                                year = 2021;
                                                Date newDate = new Date(year, month, day);
                                                showTime = (1 + rn.nextInt(12)) + ":" + (10 + rn.nextInt(60));
                                                dates.add(newDate);
                                                times.add(showTime);
                                                System.out.println("(" + i + ") " + (1 + rn.nextInt(13)) + "/" + (1 + rn.nextInt(30)) + "/" + 2021 + "   " + showTime);
                                            }
                                            int dateTimeChoice = sysSc.nextInt();
                                            Date ticketDate = new Date(year, month, day);
                                            Ticket newTicket = new Ticket(theTheater.getAddress(), theTheater.getMovies().get(j), dates.get(dateTimeChoice), times.get(dateTimeChoice), 1);
                                            newTicket.setSeatNum(rn.nextInt(80) + 1);
                                            currentUser.buyTicket(newTicket);
                                            FileWriter tmpWriter = new FileWriter(fileName, true);
                                            //TODO modify toString
                                            tmpWriter.write("\n" + newTicket.toString());
                                            tmpWriter.write("\n" + "1");
                                            tmpWriter.close();
                                            System.out.println("Added movie: " + newTicket.toString());
                                        }
                                    }
                                }
                            }
                            else {
                                for (int j = 0; j < theTheater.getMovies().size(); j++)
                                {
                                    if (browseAction == theTheater.getMovies().get(j).getID())
                                    {
                                        System.out.println("\n"+theTheater.getMovies().get(j).toString() + "\n");
                                    }
                                }
                            }
                            stayInMovieList = false;
                        }
                    }
                    else if(userAction == 3)
                    {
                        Menu.populateUserTix(currentUser);
                        if(currentUser.getCurrentTix().size()==0)
                        {
                            System.out.println("You have no tickets");
                        }
                        else {
                            System.out.println("Tickets: \n");
                            for(Ticket t: currentUser.getCurrentTix())
                            {
                                System.out.println(t.formattedToString());
                                System.out.println("--------------------");
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
                System.out.print("USERNAME: ");
                String enteredUsername = sysSc.next();
                System.out.print("PASSWORD: ");
                String enteredPass = sysSc.next();
                File movieList = new File("MainProject/src/movieList.txt");
                while (stayInAdmin)
                {

                    if (enteredUsername.equals(Menu.getAdminUser()) && enteredPass.equals(Menu.getAdminPass()))
                    {
                        System.out.println("Select Command you wish to perform: \n"
                                + "\t(1) Post new movie \n"
                                + "\t(2) Edit details of existing movie \n"
                                + "\t(3) Delete Movie \n"
                                + "\t(4) Sign Out");
                        int adminFunc = sysSc.nextInt();
                        sysSc.nextLine();
                        //Implement posting new movie
                        if (adminFunc == 1)
                        {
                            System.out.println("What is the title of the movie you would like to input?");
                            String movieTitle = sysSc.nextLine();
                            String titleNoSpace = movieTitle.replaceAll("\\s", "");;
                            System.out.println("What is the genre of the movie you would like to input?");
                            String movieGenre = sysSc.next();
                            System.out.println("What is the release date of the movie you would like to input? (Enter month, then day, then year)");
                            int movieMonth = sysSc.nextInt();
                            int movieDay = sysSc.nextInt();
                            int movieYear = sysSc.nextInt();

                            Date releaseDate = new Date(movieYear, movieMonth, movieDay);


                            File moviesFile = new File("MainProject/MoviesFolder/" + titleNoSpace + ".txt");
                            FileWriter movieWriter = new FileWriter(moviesFile, true);
                            FileWriter movieListWriter = new FileWriter(movieList, true);
                            movieListWriter.write(titleNoSpace+ ".txt\n");
                            movieWriter.write(movieTitle + "\n" + movieGenre +  "\n" + movieMonth + " " + movieDay + " " + movieYear);
                            movieWriter.close();
                            movieListWriter.close();

                        }
                        //Implement editing details of movie
                        else if (adminFunc==2)
                        {
                            Scanner sc = new Scanner(System.in);
                            System.out.print("Enter the exact name of the movie you wish to edit: ");
                            String rawTitle = sc.nextLine();
                            String strippedTitle = rawTitle.replaceAll("\\s", "");
                            FileWriter titleWrite = new FileWriter(new File("MainProject/MoviesFolder/" + strippedTitle + ".txt"), false);
                            FileWriter detailWrite = new FileWriter(new File("MainProject/MoviesFolder/" + strippedTitle + ".txt"), true);
                            titleWrite.write(rawTitle);
                            System.out.print("Enter the new genre of this movie: ");
                            String genre = sc.nextLine();
                            System.out.print("Enter the new date of the movie (Month, day, year): ");
                            int month = sc.nextInt();
                            int day = sc.nextInt();
                            int year = sc.nextInt();
                            detailWrite.write("\n" + genre +"\n" + month + " " + day + " " + year);
                            titleWrite.close();
                            detailWrite.close();
                        }
                        //TODO DELETE MOVIE FUNCTION NOT DELETING MOVIE??
                        else if (adminFunc == 3){
                            Scanner sc = new Scanner(System.in);
                            System.out.print("Enter the exact name of the movie you wish to delete: ");
                            String rawTitle = sc.nextLine();
                            String stripped = rawTitle.replaceAll("\\s", "");
                            System.out.println("MainProject/MoviesFolder/" + stripped + ".txt");
                            File del = new File("MainProject/MoviesFolder/" + stripped + ".txt");
                            movieFileToDelete = del;
                            if(movieFileToDelete.exists())
                            {
                                movieFileToDelete.delete();
                                System.out.println(rawTitle + " deleted.");
                            }
                            else
                            {
                                System.out.println("Couldnt delete");
                            }
                        }
                        else if (adminFunc == 4)
                        {
                            System.out.println("Signing Out.\n");
                            System.out.println("______________________________________\n");
                            stayInAdmin = false;
                            keepGoing = false;
                            break;
                        }
                        else
                        {
                            System.out.println("Please enter a valid command.");
                        }
                    }
                    else
                    {
                        System.out.println("Error: Incorrect Admin username or password.");
                        stayInAdmin = false;
                    }
                }
		    }
	    }
	}
}
