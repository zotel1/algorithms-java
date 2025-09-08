package codigofacilito.ejemplo_uno;
/*Fibonacci: [0, 1, 1, 2, 3, 5, 8, 13...]
*posiciones:  0, 1, 2, 3, 4, 5, 6, 7...*/
public class Recursion {

    public static int fibonacci(int n){
        if ( n <= 1){
            return n;
        }

        return fibonacci(n -1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 6;
        int result = fibonacci(n);
        System.out.println("El Fibonacci de: " + n + " es " + result);
    }
}
