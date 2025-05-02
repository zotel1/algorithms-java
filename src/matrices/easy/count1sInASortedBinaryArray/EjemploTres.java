package matrices.easy.count1sInASortedBinaryArray;

import java.util.Arrays;

public class EjemploTres {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 0, 0, 0, 0, 0};

        // fin the first ocurrence of 0 using binary search
        int index = Arrays.binarySearch(arr, 0);

        // If 0 is found, count of 1s is its index; else, all are 1s
        int countOnes = (index >= 0) ? index : -(index + 1);

        System.out.println(countOnes);
    }
}
