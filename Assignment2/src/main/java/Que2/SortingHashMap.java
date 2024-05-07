package Que2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortingHashMap {
	 public static void main(String[] args) {
	        // Creating a HashMap
	        HashMap<String, Integer> hashMap = new HashMap<>();
	        
	        // Adding elements to the HashMap
	        hashMap.put("Kartik", 25);
	        hashMap.put("Rama", 26);
	        hashMap.put("Nilesh", 24);
	        hashMap.put("Lokesh", 22);
	        
	        // Sorting the HashMap Using TreeMap
	        TreeMap<String, Integer> sortedMap = new TreeMap<>(hashMap);
	        

	        System.out.println("Sorted HashMap:");
	        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
	            System.out.println(entry.getKey() + " : " + entry.getValue());
	        }
	    }
}
