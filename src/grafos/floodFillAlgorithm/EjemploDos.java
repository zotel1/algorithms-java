package grafos.floodFillAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

/*
* La idea es usar la busqueda de amplitud primero (BFS) para cambiar todos los pixeles conectados con el color
* original (color de la imagen [sr][sc]) a un nuevo color (newColor). BFS utiliza una cola para explorar todos los pixeles
* alcanzables nivel por nivel (horizontal y verticalmente). Para cada pixel, verifica sus pixeles adyacentes y, si coinciden
* con el color original, cambia su color y los agrega a la cola para una mayore exploración.  Este proceso garantiza que todos los pixeles conectados se rellenen con el nuevo color.*/

public class EjemploDos {

    // Directions for traversing in 4-neighbor cells
    private static final int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        // If starting pixel already has the new color
        if (image[sr][sc] == newColor) {
            return image;
        }

        int oldColor = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});

        // Change the color of the starting pixel
        image[sr][sc] = newColor;

        while (!q.isEmpty()) {
            int[] front = q.poll();
            int x = front[0], y = front[1];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                // Check boundary conditions and color match
                if (nx >= 0 && nx < image.length && ny >= 0 && ny < image[0].length && image[nx][ny] == oldColor) {

                    // Change the color and enqueue
                    image[nx][ny] = newColor;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {

        // Define the input 2D image as a matrix where each element represents a pixel's color
        int[][] image = {
                {1, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };

        // sr: starting row index, sc: starting column index for the flood fill
        int sr = 1, sc = 2;

        // newColor: the color that we want to fill the connected computed with
        int newColor = 2;

        // Call the floodFill function to apply the newColor starting from (sr, sc)
        int[][] result = floodFill(image, sr, sc, newColor);

        // Print the updated image after flood fill
        for (int[] row: result) {
            for (int pixel : row) {
                System.out.println(pixel + " ");
            }
            // Move to the next line after each row
            System.out.println();
        }
    }
}
