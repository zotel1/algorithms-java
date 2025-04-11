package busquedaLineal;

public class EjemploSiete {

    public static int liner(int arr[], int x){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numeros = {5, 3, 8, 4, 2};
        int buscar = 4;

        int resultado = liner(numeros, buscar);

        if (resultado != -1) {
            System.out.println("Elemento encontrado en el índice: " + resultado);
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }
}
