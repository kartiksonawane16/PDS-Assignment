package Q2;

import java.util.ArrayList;
import java.util.List;

public class StringHandling {

	
	    public static void main(String[] args) {
	        String str = "username1+password1-username2+password2-username3+password3";

	        List<String[]> usernamePasswords = extractUsernamePasswords(str);

	        // Print all username-password pairs
	        for (String[] pair : usernamePasswords) {
	            System.out.println("Username: " + pair[0] + ", Password: " + pair[1]);
	        }
	    }

	    public static List<String[]> extractUsernamePasswords(String str) {
	        List<String[]> usernamePasswords = new ArrayList<>();

	        // Split the string by "-"
	        String[] users = str.split("-");


	        for (String user : users) {
	            // Split each user data by "+"
	            String[] userData = user.split("\\+");

	            // separate (username and password)
	            if (userData.length == 2) {
	                usernamePasswords.add(userData);
	            } else {

	                System.err.println("Invalid format: " + user);
	            }
	        }

	        return usernamePasswords;
	    }
	}


