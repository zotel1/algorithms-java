package algorithms;

public class NotacionOEjemploOcho {

    public static void main(String[] args) {
        int N = 18;
        int i = N, a = 0;

        // Iterate until i is greater
        // than 0
        while (i > 0) {

            // Print the value of a
            System.out.println(a + " ");
            a = a + i;

            // Update i
            i = i / 2;
        }
    }
}
