package Que2;

public class ReverseString {
	 public static void main(String[] args) {
	        String originalString = "Hello World";
	        String reversedString = reverseString(originalString);
	        System.out.println("Original String: " + originalString);
	        System.out.println("Reversed String: " + reversedString);
	    }

	    public static String reverseString(String str) {
	        String[] words = str.split(" "); // Split the string by whitespace

	        StringBuilder reversedString = new StringBuilder();
	        for (String word : words) {
	            StringBuilder reversedWord = new StringBuilder(word);
	            reversedWord.reverse(); // Reverse each word
	            reversedString.append(reversedWord).append(" "); // Append reversed word with space
	        }

	        return reversedString.toString().trim();
	    }
	
}

