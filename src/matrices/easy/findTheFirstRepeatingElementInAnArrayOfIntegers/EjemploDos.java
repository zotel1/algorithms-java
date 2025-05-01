package matrices.easy.findTheFirstRepeatingElementInAnArrayOfIntegers;

import java.util.HashSet;

public class EjemploDos {

    static int firstRepeatingElement(int[] arr) {
        HashSet<Integer> s = new HashSet<>();

        // If an element is already present, return it
        // else insert it
        int minEle = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (s.contains(arr[i])) {
                minEle = Math.min(minEle, i);
            }
            s.add(arr[i]);
        }

        // If no element repeats
        return minEle == Integer.MAX_VALUE ? -1 : minEle;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 4, 3, 5, 6};
        int index = firstRepeatingElement(arr);
        if (index == -1)
            System.out.println("No repeating found!");
        else
            System.out.println("First repeating is " + arr[index]);
    }
    }