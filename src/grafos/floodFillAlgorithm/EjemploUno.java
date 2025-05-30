package grafos.floodFillAlgorithm;

/*
* La idea es utilizar la busqueda en profundidad (DFS) para explotar y actualizar
* todos los pixeles conectados que comparten el mismo color original
* (color de la imagen [sr][sc]). A partir del pixel dado, DFS comprueba de forma resurva sus pixel
* adyacentes en las cuatro direccion: arriba, abajo, izquierda y derecha. Si un pixel adyacente coincide con el color original, se actualiza el nuievo color y el DFS continua
* desde ese pixel. De lo contrario. el algoritmo retrocede. Este proceso continua hasta que todo los pixeles
* conectados del mismo colore se rellenan con el nuevo color, actualizando efectivamente todo el componente conecte. */

public class EjemploUno {

    // Helper method for DFS traversal
    static void dfs(int[][] image, int x, int y, int oldColor, int newColor) {

        // Base case: check for out-of- bound indices or mismatheched color
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != oldColor) {
            return; // BAcktrack if invalid
        }

        // Change the color of the current pixel
        image[x][y] = newColor;

        // Recursively call DFS in all four directions
        dfs(image, x + 1, y, oldColor, newColor);
        dfs(image, x - 1, y, oldColor, newColor);
        dfs(image, x, y + 1, oldColor, newColor);
        dfs(image, x, y -1, oldColor, newColor);
    }

    // Main function to perform flood fill
    static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        // If the stating pixel already has the new color, no need to process
        if (image[sr][sc] == newColor) {
            return image;
        }

        // Call DFS with the original color of the starting pixel
        dfs(image, sr, sc, image[sr][sc], newColor);

        // Return the update image
        return image;
    }

    // Driver code to test the flood fill function
    public static void main(String[] args) {

        // Define the image matrix
        int[][] image = {
                {1, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };

        // Starting pixel and the new color
        int sr = 1, sc = 2, newColor = 2;

        // Perform flood fill
        int[][] result = floodFill(image, sr, sc, newColor);

        for (int[] row : result) {
            for (int pixel : row) {
                System.out.println(pixel + " ");
            }
            System.out.println();
        }
    }
}
