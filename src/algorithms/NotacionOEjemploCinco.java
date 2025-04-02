package algorithms;

public class NotacionOEjemploCinco {

    public static void main(String[] args) {

        int a = 0, b = 0;
        int N = 4, M = 4;

        // Este bucle corre por N tiempos
        for (int i = 0; i < N; i++){
            a = a + 10;
        }

        // este bucle corre por M tiempo
        for (int i = 0; i < M; i++){
            b = b + 40;
        }
        System.out.println(a + " " + b);
    }
}
