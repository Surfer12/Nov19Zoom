/**
 * Demonstrates different stack management patterns and traversal orders
 * for DFS implementations on a grid.
 */
public class DFSPatterns {
    // Direction vectors for 4-directional movement
    private static final int[][] DIRECTIONS = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    
    /**
     * Pattern 1: Basic Position Stack
     * Uses a Position class to store coordinates
     */
    static class BasicPositionStack {
        static class Position {
            int row, col;
            Position(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }
        
        public void exploreIsland(char[][] grid, int startRow, int startCol) {
            Stack<Position> stack = new Stack<>();
            stack.push(new Position(startRow, startCol));
            grid[startRow][startCol] = '0';  // Mark on push
            
            while (!stack.isEmpty()) {
                Position current = stack.pop();
                // Process each direction
                for (int[] dir : DIRECTIONS) {
                    int newRow = current.row + dir[0];
                    int newCol = current.col + dir[1];
                    
                    if (isValid(grid, newRow, newCol)) {
                        stack.push(new Position(newRow, newCol));
                        grid[newRow][newCol] = '0';  // Mark on push
                    }
                }
            }
        }
    }
    
    /**
     * Pattern 2: Encoded Position Stack
     * Encodes position as a single integer to save memory
     */
    static class EncodedPositionStack {
        public void exploreIsland(char[][] grid, int startRow, int startCol) {
            int cols = grid[0].length;
            Stack<Integer> stack = new Stack<>();
            stack.push(encode(startRow, startCol, cols));
            grid[startRow][startCol] = '0';
            
            while (!stack.isEmpty()) {
                int encoded = stack.pop();
                int row = encoded / cols;
                int col = encoded % cols;
                
                for (int[] dir : DIRECTIONS) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    if (isValid(grid, newRow, newCol)) {
                        stack.push(encode(newRow, newCol, cols));
                        grid[newRow][newCol] = '0';
                    }
                }
            }
        }
        
        private int encode(int row, int col, int cols) {
            return row * cols + col;
        }
    }
    
    /**
     * Pattern 3: Delayed Marking Stack
     * Marks cells when processing instead of when pushing
     */
    static class DelayedMarkingStack {
        static class Position {
            int row, col;
            Position(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }
        
        public void exploreIsland(char[][] grid, int startRow, int startCol) {
            Stack<Position> stack = new Stack<>();
            stack.push(new Position(startRow, startCol));
            
            while (!stack.isEmpty()) {
                Position current = stack.pop();
                
                // Check if already visited (necessary with delayed marking)
                if (grid[current.row][current.col] == '0') continue;
                
                // Mark when processing
                grid[current.row][current.col] = '0';
                
                // Push all valid neighbors (will check visited status when processed)
                for (int[] dir : DIRECTIONS) {
                    int newRow = current.row + dir[0];
                    int newCol = current.col + dir[1];
                    
                    if (isValid(grid, newRow, newCol)) {
                        stack.push(new Position(newRow, newCol));
                    }
                }
            }
        }
    }
    
    /**
     * Pattern 4: State Tracking Stack
     * Tracks additional state information during traversal
     */
    static class StateTrackingStack {
        static class PositionState {
            int row, col;
            int directionIndex;  // Tracks which directions have been explored
            
            PositionState(int row, int col) {
                this.row = row;
                this.col = col;
                this.directionIndex = 0;
            }
        }
        
        public void exploreIsland(char[][] grid, int startRow, int startCol) {
            Stack<PositionState> stack = new Stack<>();
            stack.push(new PositionState(startRow, startCol));
            grid[startRow][startCol] = '0';
            
            while (!stack.isEmpty()) {
                PositionState current = stack.peek(); // Peek instead of pop
                
                // If all directions explored, pop and continue
                if (current.directionIndex == DIRECTIONS.length) {
                    stack.pop();
                    continue;
                }
                
                // Get next direction to explore
                int[] dir = DIRECTIONS[current.directionIndex++];
                int newRow = current.row + dir[0];
                int newCol = current.col + dir[1];
                
                if (isValid(grid, newRow, newCol)) {
                    stack.push(new PositionState(newRow, newCol));
                    grid[newRow][newCol] = '0';
                }
            }
        }
    }
    
    // Helper method to check if a position is valid
    private static boolean isValid(char[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && 
               col >= 0 && col < grid[0].length && 
               grid[row][col] == '1';
    }
    
    /**
     * Demonstrates the different traversal orders between recursive and iterative DFS
     */
    public static void main(String[] args) {
        // Example grid
        char[][] grid = {
            {'1', '1', '1', '1'},
            {'1', '1', '0', '1'},
            {'1', '0', '1', '1'},
            {'1', '1', '1', '1'}
        };
        
        System.out.println("Traversal Order Comparison:");
        System.out.println("\nRecursive DFS (natural order):");
        printTraversalOrder(grid, true);
        
        System.out.println("\nIterative DFS (reverse order):");
        printTraversalOrder(grid.clone(), false);
    }
    
    // Helper method to visualize traversal order
    private static void printTraversalOrder(char[][] grid, boolean recursive) {
        int order = 1;
        if (recursive) {
            recursiveTraversal(grid, 0, 0, order);
        } else {
            iterativeTraversal(grid, 0, 0, order);
        }
    }
}
