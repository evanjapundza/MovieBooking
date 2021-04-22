import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
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
	private static File fileName;
	
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
        populateUsers();
        fileName = new File("MainProject/src/Users.txt");
		System.out.println("Welcome to the Movie Booking Program.");
		boolean keepGoing = true;
		Scanner sysSc = new Scanner (System.in);
		while (keepGoing)
		{
			FileWriter out = new FileWriter (fileName, true);
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
                        creds.remove(currentUsername);
                        File tmpFile = new File("MainProject/src/tmpFile.txt");
                        FileWriter tmpWriter = new FileWriter (tmpFile, true);
                        for(String userName : creds.keySet())
                        {
                            System.out.println(userName + "   " + creds.get(userName));
                            tmpWriter.write(userName + "   " + creds.get(userName));
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
                        //Implement posting new movie
                        if (adminFunc == 1)
                        {

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
