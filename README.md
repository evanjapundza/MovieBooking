# c212-Spring-2021
Hello, this is the ReadMe for Group 27 final C212 Project. We decided to build the movie booking application. 
The necessary files as well as directories should be available to you as soon as you pull this repository. Throughout your 
testing of our program there are a few things to keep in mind. First and most importantly is the somewhat clunky mechanics of state 
persistence with text files. When keeping state persistence with text files, the program must be terminated in order for the file modification
to go into effect. For example, when creating an account, the text file that holds the users information is not created until the program is terminated
and re-run. This we have done for the user. However, when performing actions such as buying a ticket, the ticket will not appear in the "view tickets" section
until the user logs out. Similarly, when an admin edits the information of a movie, the edited information will not be visible in a log out and re-run. Please refer to our
video demo of the program for examples. We wish this process was more intuitive, but unfortunately that is what is needed.
