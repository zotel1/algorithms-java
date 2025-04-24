package matrices.findTheMissingNumber;

public class EjemploTres {

    public static int missingNum(int[] arr) {
        long n = arr.length + 1;

        // Calculate the sum of array elements
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // Use long for expected sum to avoid overflow
        long expSum = n * (n + 1) / 2;

        // return the missing number
        return (int) (expSum - sum);
    }

    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 5, 3, 7, 1};
        System.out.println(missingNum(arr));
    }
}
