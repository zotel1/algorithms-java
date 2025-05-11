package matrices.easy.pairWithTheGivenDifference;

public class EjemploUno {
    static boolean findPair(int[] arr, int x) {
        int n = arr.length;

        // Compare each element with every other element
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // Check if absolute difference matches target
                if (Math.abs(arr[i] - arr[j]) == x) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {5, 20, 3, 2, 50, 80};
        int x = 78;
        if (findPair(arr, x)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
