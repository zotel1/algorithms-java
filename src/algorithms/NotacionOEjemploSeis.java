package algorithms;

public class NotacionOEjemploSeis {

    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int M = 4;
        int N = 5;

        // Nested loops
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a = a + j;

                //Print the current
                // value of a
                System.out.println(a + " ");
            }
            System.out.println();

        }
    }
}
