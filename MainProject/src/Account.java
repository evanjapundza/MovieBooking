public class Account {

    //instance variables
    private String username; //username of account
    private String password; //password of account

    //Constructor
    public Account(String username, String password) {
        //all-args constructor
        //initializes instance variables
        this.username = username;
        this.password = password;
    }

    //getters and setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



}
