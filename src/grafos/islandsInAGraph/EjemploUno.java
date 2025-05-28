package grafos.islandsInAGraph;

public class EjemploUno {

    // A function to check if a given cell (r, c) can be included in DFS
    static boolean isSafe(char[][] grid, int r, int c, boolean[][] visited) {
        int row = grid.length;
        int col = grid[0].length;

        // r is in orange, c is in range, value is 'L' (land) and not yet visited
        return (r >= 0) && (r < row) && (c >= 0) && (c < col) && (grid[r][c] == 'L' && !visited[r][c]);
    }

    // A utility function to do DFS for a 2D boolean matrix. It only considers the 8 neighbours as adjacent vertices
    static void dfs(char[][] grid, int r, int c, boolean[][] visited) {
        // These arrays are used to get r and c numbers of 8 neighbours of a given cell
        int[] rNbr = { -1, -1, -1, 0, 0, 1, 1, 1};
        int[] cNbr = { -1, 0, 1, -1, 1, -1, 0, 1};

        // Mark this cell as visited
        visited[r][c] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k) {
            int newR = r + rNbr[k];
            int newC = c + cNbr[k];
            if ( isSafe(grid, newR, newC, visited)) {
                dfs(grid, newR, newC, visited);
            }
        }
    }

    // THe main function returns count of islands in a given boolean 2D matrix
    static  int countIsIsland(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // make a bool array to mark visited cells.
        // Initialize all cells are unvisited
        boolean[][] visited = new boolean[row][col];

        // Initialize count as 0 and traverse through
        // all cells of the given matrix
        int count = 0;
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c <  col; ++c) {
                // If a cell with value 'L' (land) is not visited yet, then a new island is found
                if (grid[r][c] == 'L' && !visited[r][c]) {
                    // visit all cells in this island.
                    dfs(grid, r, c, visited);

                    // Increment the island count
                    ++count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
                { 'L', 'L', 'W', 'W', 'W' },
                { 'W', 'L', 'W', 'W', 'L' },
                { 'L', 'W', 'W', 'L', 'L' },
                { 'W', 'W', 'W', 'W', 'W' },
                { 'L', 'W', 'L', 'L', 'W' }
        };

        System.out.println(countIsIsland(grid));
    }
 }
