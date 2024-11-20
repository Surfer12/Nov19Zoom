/**
 * Solution for the Number of Islands problem using iterative Depth-First Search.
 * This approach eliminates recursion by explicitly managing a stack.
 */
class Solution {
    // Represents a position in the grid
    private static class Position {
        int row, col;
        
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    // Direction vectors for moving up, right, down, left
    private static final int[][] DIRECTIONS = {
        {-1, 0},  // up
        {0, 1},   // right
        {1, 0},   // down
        {0, -1}   // left
    };
    
    /**
     * Counts the number of islands using iterative DFS.
     * Time Complexity: O(m * n)
     * Space Complexity: O(min(m,n)) for the stack in worst case
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Stack<Position> stack = new Stack<>();
        
        // Iterate through each cell in the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    islands++; // Found a new island
                    
                    // Start DFS from this cell
                    stack.push(new Position(row, col));
                    grid[row][col] = '0'; // Mark as visited
                    
                    // Process all connected land cells
                    while (!stack.isEmpty()) {
                        Position current = stack.pop();
                        
                        // Check all four directions
                        for (int[] direction : DIRECTIONS) {
                            int newRow = current.row + direction[0];
                            int newCol = current.col + direction[1];
                            
                            // If valid land cell, add to stack and mark as visited
                            if (isValidLandCell(grid, newRow, newCol)) {
                                stack.push(new Position(newRow, newCol));
                                grid[newRow][newCol] = '0'; // Mark as visited
                            }
                        }
                    }
                }
            }
        }
        
        return islands;
    }
    
    /**
     * Checks if the given position is within bounds and is a land cell.
     */
    private boolean isValidLandCell(char[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && 
               col >= 0 && col < grid[0].length && 
               grid[row][col] == '1';
    }
    
    /**
     * Comprehensive test cases for the iterative DFS solution.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1: Single island
        char[][] grid1 = {
            {'1', '1', '1'},
            {'0', '1', '0'},
            {'1', '1', '1'}
        };
        assert solution.numIslands(grid1) == 1 : "Test case 1 failed";
        
        // Test Case 2: Multiple separate islands
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
        
        // Test Case 4: All cells are land
        char[][] grid4 = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        assert solution.numIslands(grid4) == 1 : "Test case 4 failed";
        
        // Test Case 5: Alternating pattern
        char[][] grid5 = {
            {'1', '0', '1'},
            {'0', '1', '0'},
            {'1', '0', '1'}
        };
        assert solution.numIslands(grid5) == 5 : "Test case 5 failed";
        
        // Test Case 6: Single cell
        char[][] grid6 = {{'1'}};
        assert solution.numIslands(grid6) == 1 : "Test case 6 failed";
        
        // Test Case 7: Long snake-like island
        char[][] grid7 = {
            {'1', '1', '1'},
            {'0', '0', '1'},
            {'1', '1', '1'}
        };
        assert solution.numIslands(grid7) == 1 : "Test case 7 failed";
        
        System.out.println("All test cases passed!");
    }
}
