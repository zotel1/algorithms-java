package algorithms;

public class NotacionOEjemploCuatro {

    public static int factorial(int n) {
        int i, factorial;
        if (n <= 1) {
            factorial= 1;
        } else {
            factorial = 1;
            for (i = 2; i<=n; i=i +1){
                factorial= factorial*i;
            }
        }
        return factorial;
    }

    public static void main(String[] args) {
        int numero = 5;
        System.out.println("El factorial de " + numero + " es: " + factorial(numero));
    }
}
