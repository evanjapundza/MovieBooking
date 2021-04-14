import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {
	private String adminUser = "ADMIN1";
	private String adminPass = "password";
	
	private static void populateUsers() {
		System.out.println("read all users");
	}
	
	public static void main(String [] args) throws IOException {
		populateUsers();
		
		System.out.println("Welcome to the Movie Booking Program.");
		boolean keepGoing = true;
		Scanner sysSc = new Scanner (System.in);
		while (keepGoing) {
			FileWriter out = new FileWriter (new File("MainProject/src/Users.txt"), true);
			out.write("new stuff" + "\n");
		System.out.print("Please specify which type of account you are: \n"
				+ "\t (1) User \n"
				+ "\t (2) Admin    ");
		int userType = sysSc.nextInt();
		if (userType ==1) {
			boolean stayInUser = true;
			while (stayInUser) {
			
			System.out.print("Welcome! Do you already have an account?\n"
					+ "\t(1) Yes, log me in. \n"
					+ "\t(2) No, I would like to make an account.");
			int userAcctChoice = sysSc.nextInt();
			if (userAcctChoice == 1) {
				System.out.print("Enter your username: ");
				String userUsername = sysSc.next();
				System.out.println("Enter your password: ");
				String userPass = sysSc.next();
			}
			if (userAcctChoice == 2) {
				System.out.print("Enter your new username: ");
				String newUsername = sysSc.next();
				System.out.print("Enter your new password: ");
				String newPass = sysSc.next();
				out.write(newUsername + "   " + newPass + "\n");
				
			}
			else {
				System.out.println("Please enter a valid command. \n");
			}
			}
		}
		else if (userType == 2) {
			boolean stayInAdmin = true;
			while (stayInAdmin) {
				System.out.print("USERNAME: ");
				String enteredUsername = sysSc.next();
				System.out.print("PASSWORD: ");
				String enteredPass = sysSc.next();
				if (enteredUsername.equals("ADMIN1") && enteredPass.equals("password")) {
					System.out.println("Select Command you wish to perform: \n"
							+ "\t(1) Post new movie \n"
							+ "\t(2) Edit details of existing movie \n"
							+ "\t(3) Sign Out");
					int adminFunc = sysSc.nextInt();
					//Implement posting new movie
					if (adminFunc == 1) {
						
					}
					//Implement editing details of movie
					else if (adminFunc==2) {
						
					}
					else if (adminFunc == 3) {
						System.out.println("Signing Out.\n");
						System.out.println("______________________________________");
						stayInAdmin = false;
					}
					else {
						System.out.println("Please enter a valid command.");
					}
				}
				else {
					System.out.println("Error: Incorrect Admin username or password.");
				}
			}
		}
		out.close();
	}
	}
}
