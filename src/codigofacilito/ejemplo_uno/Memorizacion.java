package codigofacilito.ejemplo_uno;

import java.util.Arrays;

public class Memorizacion {

    public static int nthFibonacciUtil(int n,  int[] memo){

        // Base case: if n is 0 or 1,return a
        if(n <= 1){
            return n;
        }

        // check if the result is already in the memo table
        if (memo[n] != -1){
            return memo[n];
        }

        // recursive case: calsulate fibonacci number and store it in memo
        memo[n] = nthFibonacciUtil(n -1, memo) + nthFibonacciUtil(n - 2, memo);
        return memo[n];
    }

    // Wrapper function that handles bothn initialization and Fibonacci calculation
    public static int nthFibonacci(int n){

        // Create a memortization table and initialize with -1
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);


        // Call the utility function
        return nthFibonacciUtil(n, memo);
    }

    public static void main(String[] args) {
        int n = 6;
        int result = nthFibonacci(n);
        System.out.println("La posicion del numero: " + n + " es " + result);
    }
}
