package algorithms;

public class NotacionOEjemploTres {

    public static int miFuncion(int N){
        int a = 0; // =(!)
        int i,j;

        for (i = 1; i <= N; i++) { // O(N)
            for (j =1; j <= N; j++) { // O(N)
                a = a + i + j; // O(1)
            }
        }

        return a; // O(1)
    }

    public static void main(String[] args) {
        int resultado = miFuncion(5);
        System.out.println("Resultado: " + resultado);
    }
}
