package algorithms;

public class NotacionOEjemploSiete {

    public static void main(String[] args) {
        int N = 8, k = 0;

        // Primer ciclo corre en N/2 tiempos
        for (int i = N / 2; i <= N ; i++) {
             // Inner loop run log N
            // times for all i
            for (int j = 2; j <= N ; j = j * 2) {
                // Print the value k
                System.out.println(k + " ");
                k = k + N / 2;
            }
        }
    }
}
