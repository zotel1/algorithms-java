package grafos.rottenOrangesMinimumTimeToRotAll;

public class EjemploUno {

    // Function to check if the cell is within bounds
    private boolean isSafe(int i, int j, int n, int m) {
        return 0 <= i && i < n && 0 <= j && j <m;
    }

    public int orangesRottin(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // to check if any changes are made
        boolean changed;

        // Counter of elapsed time
        int elapsedTime = 0;

        // all four directions
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // iterate until changes are there
        while(true) {
            changed = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // check if the cell was marked in last iteration
                    if (mat[i][j] == elapsedTime + 2) {
                        // change 4 -directionally connected cells
                        for (int[] dir : directions) {
                            int x = i + dir[0];
                            int y = j + dir[1];

                            // if cell is in the matrix and the orange is fresh
                            if (isSafe(x, y, n, m) && mat[x][y] == 1) {
                                mat[x][y] = mat[i][j] + 1;
                                changed = true;
                            }
                        }

                    }
                }
            }
                // if no changes are done
                if (!changed) {
                    break;
                }
                elapsedTime++;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // if any orange is found not rotten, return -1
                    if( mat[i][j] == 1) {
                        return -1;
                    }
                }
            }
            return elapsedTime;
        }

        public static void main(String[] args) {
        int[][] mat = {{2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
        EjemploUno sol = new EjemploUno();
        System.out.println(sol.orangesRottin(mat));

        }
    }

