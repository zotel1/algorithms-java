package busquedaLineal;

public class Ejemplotres {

    public static int busquedaLineal(int[] arreglo, int elemento) {

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == elemento) {
                return i;
            }
        }

        return 0;
    }

        public static void main (String[]args){

            int[] numeros = {1, 3, 5, 7, 9, 11};

            int miElemento = 7;

            System.out.println("Elemento " + miElemento + " se encuentra en el indice: " + busquedaLineal(numeros, miElemento));
        }
    }

