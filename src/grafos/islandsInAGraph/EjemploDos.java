package grafos.islandsInAGraph;

public class EjemploDos {

    // A utility function to do DFS for a 2D matrix. It only considers the 8 neighbors as adjacent vertices
    static void dfs(char[][] grid, int r, int c) {

        // These arrays are used to get r and c numbers of 8 neighbours of a given cell
        int row = grid .length;
        int col = grid[0].length;

        if (r < 0 || c < 0 || r >= row || c >= col || grid[r][c] != 'L') {
            return;
        }
        int[] rNbr = { -1, -1, -1, 0, 0, 1, 1, 1};
        int[] cNbr = { -1, 0, 1, -1, 1, -1, 0, 1};

        // MArk this cell as visited by settieng it to 'W'
        grid[r][c] = 'W';

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k) {
            int newR = r + rNbr[k];
            int newC = c + cNbr[k];

            dfs(grid, newR, newC);
        }
    }

    // The main function that returns
    // count of islands in a given matrix
    static int countIslands(char[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;

        // Initialize count as 0 and traverse through
        // all cells of the given matrix
        int count = 0;
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {

                // If a cell with value 'L' (land) is found,
                // then a new island is found
                if (grid[r][c] == 'L') {

                    // Visit all cells in this island.
                    dfs(grid, r, c);

                    // Increment the island count
                    ++count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        char[][] grid = { { 'L', 'L', 'W', 'W', 'W' },
                { 'W', 'L', 'W', 'W', 'L' },
                { 'L', 'W', 'W', 'L', 'L' },
                { 'W', 'W', 'W', 'W', 'W' },
                { 'L', 'W', 'L', 'L', 'W' } };

        System.out.println(countIslands(grid));
    }
}
