package matrices.easy.findTheMissingNumber;

// Encuentra el numero que falta
public class EjemploUno {

    static int missingNum(int[] arr) {
        int n = arr.length + 1;

        // Iterate from 1 to n and check if the current number us present
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            for ( int j = 0; j < n - 1; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }

            // if the current number is not present
            if (!found)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 5, 3, 7, 1};
        System.out.println(missingNum(arr));
    }
}
