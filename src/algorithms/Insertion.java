package algorithms;

public class Insertion {
    public static void main(String[] args) {
        int []arr = {5, 3, 4, 8, 7, 5, 1, 2, 3}; // Big O de 1
        for (int j = 1; j < arr.length; j++) { // Big O de n
            int actual = arr[j]; // Big O de n

            int i = j - 1;
            while (i > 0 && arr[i] > actual) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = actual;
        }
    }
}
