# DFS-Islands-Solution

## Current Solution
```java
class IslandDFSSolutionCurrent {
    private static final int[][] DIRECTIONS = {
        {-1, 0},  // up. In a 2D array, this is the row above the current position.
        {1, 0},   // down. In a 2D array, this is the row below the current position.
        {0, -1},  // left. In a 2D array, this is the column to the left of the current position.
        {0, 1}    // right. In a 2D array, this is the column to the right of the current position.

        // 0 indicates that the column or row index is not changing.
    };
    /**
     * 
     * Counts the number of islands in the grid using DFS.
     * Time Complexity: O(m * n) where m is rows and n is columns
     * Space Complexity: O(m * n) in worst case for recursion stack
     *
     * @param grid 2D char array representing the map
     * @return number of islands found
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) { // If the grid is null or empty, there are no islands.
            return 0;
        }
        
        int islands = 0; 
        int numRows = grid.length; // The number of rows in the grid. i.e Grid Height
        int numCols = grid[0].length; // Retrives the length of the first row in the grid, which indicates the number of columns. i.e Grid Width
        
        // Iterate through each cell in the grid
        for (int row = 0; row < numRows; row++) { // Places constraints on the number of rows that will be iterated over.
            for (int col = 0; col < numCols; col++) { // Places constraints on the number of columns that will be iterated over.
                if (grid[row][col] == '1') { // If the current cell is land ('1'), then we have found a new island.
                    islands++;  // Found a new island so we increment the island counter.
                    exploreIsland(grid, row, col); // Recursively explore the island to mark all connected land cells as visited.
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
        // Check boundary conditions and if current cell is land as well as not off the island boundary, and not beyond the grid boundaries.
        if (row < 0 || row >= grid.length || 
            col < 0 || col >= grid[0].length || 
            grid[row][col] != '1') {
            return;
        }
        
        // Mark current cell as visited by changing it to water ('0') to prevent it from being visited again.
        grid[row][col] = '0';
        
        // Explore all adjacent cells 
        for (int[] direction : DIRECTIONS) {
            exploreIsland(
                grid,
                row + direction[0], // The row index of the current cell plus the row index of the direction. This is the new row index moving 'up' and 'down'
                // Once it has moved up it will then move right or left.
                col + direction[1] // The column index of the current cell plus the column index of the direction. This is the new column index moving 'right' and 'left'
                row + direction[2], // The row index of the current cell plus the row index of the direction. This is the new row index moving 'up' and 'down'
                col + direction[3] // The column index of the current cell plus the column index of the direction. This is the new column index moving 'right' and 'left'
            );
        }
    }
}

```java
public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
return 0;
}
    int islands = 0;
    for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[0].length; col++) {
            if (grid[row][col] == '1') {
islands++;
exploreIsland(grid, row, col);  
        }
    }
}
return islands;
}
```

#### Recursive DFS Characteristics
- Uses system call stack for traversal
- Natural depth-first progression
- Implicit backtracking
- Potential stack overflow for large grids

### 2. Iterative DFS Approach (Stack)a
```java
public int numIslands(char[][] grid) {
int islands = 0;
Stack<Position> stack = new Stack<>();
for (int row = 0; row < grid.length; row++) {
for (int col = 0; col < grid[0].length; col++) {
if (grid[row][col] == '1') {
islands++;
stack.push(new Position(row, col));
grid[row][col] = '0';
while (!stack.isEmpty()) {
Position current = stack.pop();
for (int[] direction : DIRECTIONS) {
int newRow = current.row + direction[0];
int newCol = current.col + direction[1];
if (isValidLandCell(grid, newRow, newCol)) {
stack.push(new Position(newRow, newCol));
grid[newRow][newCol] = '0';
}
}
}
}
}
}
return islands;
}
```

#### Iterative DFS Characteristics
- Explicit stack management
- More control over traversal
- Avoids potential stack overflow
- Slightly more complex implementation

## Advanced DFS Patterns

### 1. Compact State Management
```java
private static class CompactState {
final int encoded; // row and col packed into single int
final byte dirIndex; // use byte instead of int for direction
CompactState(int row, int col, byte dirIndex) {
this.encoded = (row << 16) | col; // bit shifting for packing
this.dirIndex = dirIndex;
}
int row() { return encoded >>> 16; }
int col() { return encoded & 0xFFFF; }
}

### 2. Object Pooling for Optimization
```java
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
}
```

## Performance Considerations

### Time Complexity
- O(m * n), where m is rows and n is columns
- Each cell is visited exactly once

### Space Complexity
- Recursive: O(m * n) worst case (deep recursion)
- Iterative: O(min(m, n)) for stack space

## Optimization Techniques

1. Bit Manipulation for Position Encoding
```java
private static int encodePosition(int row, int col, int cols) {
return row cols + col;
}

2. Efficient Visited Tracking
```java
BitSet visited = new BitSet(rows cols); // Memory efficient visited tracking
```

## Conclusion
Both recursive and iterative DFS solve the Number of Islands problem effectively. The choice depends on:
- Grid size
- Memory constraints
- Performance requirements

Recommended approach:
- Small to medium grids: Recursive DFS
- Large grids: Iterative DFS

## Key Takeaways
- DFS is powerful for grid traversal
- Marking visited cells prevents redundant exploration
- Multiple implementation strategies exist
- Consider space and time complexity

## Additional Considerations
- Always validate input grid
- Handle edge cases (null or empty grid)
- Consider memory constraints for large grids
- Potential for in-place modification of input grid

## Recommended Practice
1. Implement both recursive and iterative solutions
2. Analyze performance with different grid sizes
3. Experiment with optimization techniques
4. Understand trade-offs between approaches