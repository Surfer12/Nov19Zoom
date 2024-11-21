/**
 * Optimized DFS implementations with efficient state management
 */
class OptimizedDFS {
    // Optimize memory usage by encoding positions into a single integer
    private static class CompactState {
        final int encoded;  // row and col packed into single int
        final byte dirIndex;  // use byte instead of int for direction
        
        CompactState(int row, int col, byte dirIndex) {
            this.encoded = (row << 16) | col;  // bit shifting for packing
            this.dirIndex = dirIndex;
        }
        
        int row() { return encoded >>> 16; }
        int col() { return encoded & 0xFFFF; }
    }
    
    // Object pooling for frequently created objects
    private static class StatePool {
        private final Queue<CompactState> pool;
        private final int maxSize;
        
        StatePool(int maxSize) {
            this.maxSize = maxSize;
            this.pool = new ArrayDeque<>(maxSize);
        }
        
        CompactState acquire(int row, int col, byte dirIndex) {
            CompactState state = pool.poll();
            return state != null ? state : new CompactState(row, col, dirIndex);
        }
        
        void release(CompactState state) {
            if (pool.size() < maxSize) {
                pool.offer(state);
            }
        }
    }
    
    // Optimized iterative DFS with state management
    public void optimizedDFS(char[][] grid) {
        if (grid == null || grid.length == 0) return;
        
        int rows = grid.length;
        int cols = grid[0].length;
        StatePool statePool = new StatePool(Math.min(rows * cols, 1000));
        
        // Use ArrayDeque instead of Stack for better performance
        Deque<CompactState> stack = new ArrayDeque<>();
        BitSet visited = new BitSet(rows * cols);  // Memory efficient visited tracking
        
        // Initial state
        stack.push(statePool.acquire(0, 0, (byte)0));
        visited.set(encodePosition(0, 0, cols));
        
        while (!stack.isEmpty()) {
            CompactState current = stack.peek();
            int row = current.row();
            int col = current.col();
            
            if (current.dirIndex >= 4) {  // All directions explored
                statePool.release(stack.pop());
                continue;
            }
            
            // Get next direction to explore
            int nextRow = row + DX[current.dirIndex];
            int nextCol = col + DY[current.dirIndex];
            current.dirIndex++;
            
            if (isValid(nextRow, nextCol, grid)) {
                int encodedPos = encodePosition(nextRow, nextCol, cols);
                if (!visited.get(encodedPos)) {
                    visited.set(encodedPos);
                    stack.push(statePool.acquire(nextRow, nextCol, (byte)0));
                }
            }
        }
    }
    
    // Reuse direction arrays
    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};
    
    // Encode position into single integer
    private static int encodePosition(int row, int col, int cols) {
        return row * cols + col;
    }
    
    private static boolean isValid(int row, int col, char[][] grid) {
        return row >= 0 && row < grid.length && 
               col >= 0 && col < grid[0].length && 
               grid[row][col] == '1';
    }
}
