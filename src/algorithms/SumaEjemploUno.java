package algorithms;

public class SumaEjemploUno {
    // Método para sumar los elementos de un arreglo
    public static int suma_arreglo(int arreglo[], int tam_arreglo){

        int i;
        int suma = 0;

        for (i=0; i < tam_arreglo; i = i+1){
            suma = suma + arreglo[i];
        }

        return suma;
    }


    public static void main(String[] args) {

        int[] numeros = {1,2,3,4,5}; // Arreglo de prueba
        int resultado = suma_arreglo(numeros, numeros.length); // Llamamos al método
        System.out.println("La suma del arreglo es: " + resultado);

    }
}
