/**
 * Solution for the Number of Islands problem using Depth-First Search (DFS).
 * The problem: Given a 2D grid of '1's (land) and '0's (water), count the number
 * of distinct islands. An island is surrounded by water and formed by connecting
 * adjacent '1's horizontally or vertically.
 */
class IslandDFSSolutionCurrent {
    private static final int[][] DIRECTIONS = {
        {-1, 0},  // up
        {1, 0},   // down
        {0, -1},  // left
        {0, 1}    // right
    };
    
    /**
     * Counts the number of islands in the grid using DFS.
     * Time Complexity: O(m * n) where m is rows and n is columns
     * Space Complexity: O(m * n) in worst case for recursion stack
     *
     * @param grid 2D char array representing the map
     * @return number of islands found
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Iterate through each cell in the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    islands++;  // Found a new island
                    exploreIsland(grid, row, col);
                }
            }
        }
        
        return islands;
    }
    
    /**
     * Explores an island using DFS and marks visited cells.
     * Modifies the grid by changing visited land cells ('1') to water ('0').
     *
     * @param grid The 2D grid being explored
     * @param row Current row position
     * @param col Current column position
     */
    private void exploreIsland(char[][] grid, int row, int col) {
        // Check boundary conditions and if current cell is land
        if (row < 0 || row >= grid.length || 
            col < 0 || col >= grid[0].length || 
            grid[row][col] != '1') {
            return;
        }
        
        // Mark current cell as visited by changing it to water
        grid[row][col] = '0';
        
        // Explore all adjacent cells
        for (int[] direction : DIRECTIONS) {
            exploreIsland(
                grid,
                row + direction[0],
                col + direction[1]
            );
        }
    }
    
    /**
     * Test cases demonstrating usage of the solution.
     */
    public static void main(String[] args) {
        IslandDFSSolutionCurrent solution = new IslandDFSSolutionCurrent();
        
        // Test Case 1: Single island
        char[][] grid1 = {
            {'1', '1', '1'},
            {'0', '1', '0'},
            {'1', '1', '1'}
        };
        assert solution.numIslands(grid1) == 1 : "Test case 1 failed";
        
        // Test Case 2: Multiple islands
        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        assert solution.numIslands(grid2) == 3 : "Test case 2 failed";
        
        // Test Case 3: No islands
        char[][] grid3 = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        assert solution.numIslands(grid3) == 0 : "Test case 3 failed";
        
        // Test Case 4: All islands
        char[][] grid4 = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        assert solution.numIslands(grid4) == 1 : "Test case 4 failed";
        
        System.out.println("All test cases passed!");
    }
}
