package grafos.rottenOrangesMinimumTimeToRotAll;

import java.util.LinkedList;
import java.util.Queue;

public class EjemploTres {

    // Check if i, j is within the array limits of row and column
    static boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

    static int orangesRotting(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // all four directions
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        // queue to store cell position
        Queue<int[]> q = new LinkedList<>();

        // Find all rotten oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }

        // Counter of elapsed time
        int elapsedTime = 0;

        while (!q.isEmpty()) {

            // Increase time by 1
            elapsedTime++;

            int len = q.size();
            while (len -- > 0) {
                int[] cur = q.poll();
                int i = cur[0];
                int j = cur[1];

                // Change 4-directionally connected cells
                for(int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    // if cell is in the matrix and the orange is fresh
                    if (isSafe(x, y, n, m)
                    && mat[x][y] == 1) {
                        mat[x][y] = 2;
                        q.add(new int[] { x, y });
                    }
                }
            }
        }

        // Check if any fresh orange is remaining
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    return -1;
                }
            }
        }

        return Math.max(0, elapsedTime -1);
    }

    public static void main(String[] args) {
        int[][] mat = {{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        System.out.println(orangesRotting(mat));
    }
}
