package grafos.pacificAtlanticWaterFlow;

/*
* Hay una isla rectangular de N x M que limita tanto con el Océano Pacífico como con el Océano Atlántico.
* El Océano Pacífico toca los bordes izquierdo y superior de la isla,
* y el Océano Atlántico toca los bordes derecho e inferior de la isla.

La isla está dividida en una cuadrícula de celdas cuadradas.
* La isla recibe mucha lluvia y el agua de lluvia puede fluir a las celdas vecinas directamente al norte,
* sur, este y oeste si la altura de la celda vecina es menor o igual a la altura de la celda actual.
* El agua puede fluir desde cualquier célula adyacente a un océano hacia el océano.

Dado un mat[][] de matriz que tiene N filas y M columnas donde mat[x][y]
* representa la altura sobre el nivel del mar de la celda en la coordenada (x, y),
* la tarea es encontrar el número de coordenadas (x, y)
* tal que el agua de lluvia pueda fluir desde la celda (x, y)
* a los océanos Pacífico y Atlántico.
* */

import java.util.LinkedList;
import java.util.Queue;

public class EjemploUno {
    static int x[] = { 0, 0, -1, 1 };
    static int y[] = { 1, -1, 0, 0 };

    static class pair {
        int first, second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // Function to check if coordinate (i, j ) lies inside N x Matrix
    static boolean safe(int i, int j, int N, int M)
    {
        if (i < 0 || j < 0 || i >= N || j >= M)
            return false;
        return true;
    }

    // Function to perform a BFS Traversal and mark visited
    static void BFS(int[][] matrix, int N, int M, Queue<pair> q, boolean [][] vis) {
        // Loop to traverse q
        while (q.isEmpty() == false) {
            // Stores current coordinate
            pair cur = q.peek();
            q.remove();

            // Mark current visited
            vis[cur.first][cur.second] = true;
            for (int i = 0; i < 4; i++) {
                int nx = cur.first + x[i];
                int ny = cur.second + y[i];

                // If coordinate (nx, ny)
                // is inbound and rechable
                if ( safe(nx, ny, N, M) && matrix[nx][ny] >= matrix[cur.first][cur.second] && vis[nx][ny] == false) {
                    // Insert into queue
                    q.add(new pair( nx, ny ));

                    // Mark visited
                    vis[nx][ny] = true;
                }
            }
        }
    }

    // Function to find the count of
    // valid coordinates
    static int countCoordinates(int[][] mat, int N, int M) {
        // Queue to perform BFS
        Queue<pair> q1 = new LinkedList<>();
        Queue<pair> q2 = new LinkedList<>();

        // Stores the visited coordinates
        // during the 1st traversal

        boolean visited1[][] = new boolean[N][M];
        // stores the visited coordinates
        // during the 2nd traversal
        boolean visited2[][] = new boolean[N][M];

        // Insert the coordinates
        // directly connected
        for (int i = 0; i < M; i++) {
            q1.add(new pair(0, i));
            q2.add(new pair( N - 1, i));
        }
        for ( int j = 0; j < N -1; j++) {
            q1.add(new pair( j + 1, 0 ));
            q2.add(new pair( j, M - 1 ));
        }

        // BFS for the 1st ocean
        BFS(mat, N, M, q1, visited1);

        // BFS for the 2nd ocean
        BFS(mat, N, M, q2, visited2);

        // stores the required count
        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // If coordinate (i, j)
                // is reachable from both
                if (visited1[i][j] && visited2[i][j]) {
                    // Update count
                    ans++;
                }
            }
        }

        // Return Answer
        return ans;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] mat
                = {
                { 1, 2, 2, 3, 5 },
                { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 } };
        System.out.println(countCoordinates(mat, mat[0].length, mat[1].length));
    }
}
