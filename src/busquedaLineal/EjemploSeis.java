package busquedaLineal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EjemploSeis {

    static int linearSearchWithHashTable(ArrayList<Integer> arr, int target) {

        // Create a hash table to map each element to its position
        Map<Integer, Integer> hashTable = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.size(); i++) {
            hashTable.put(arr.get(i), i);
        }

        // Search for the target element in the hash table
        if (hashTable.containsKey(target)) {
            return hashTable.get(target);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(5);
        arr.add(3);
        arr.add(9);
        arr.add(2);
        arr.add(7);
        int target = 9;

        int index = linearSearchWithHashTable(arr, target);
        if( index != -1) {
            System.out.println("Found " + target + " at index " + index);
        } else {
            System.out.println(target + " not found in the list");
        }
    }
}
