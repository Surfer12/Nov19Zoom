// DFS Solution         
class SolutionDFSRecursiveBackTrack {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    numIslands++;
                    dfs(grid, row, col);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Check boundaries and if cell is land
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] != '1') {
            return;
        }

        // Mark as visited by changing to '0'
        grid[row][col] = '0';

        // Explore all 4 directions
        dfs(grid, row + 1, col); // down
        dfs(grid, row - 1, col); // up
        dfs(grid, row, col + 1); // right
        dfs(grid, row, col - 1); // left
    }
}
