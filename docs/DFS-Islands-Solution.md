

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

### 2. Iterative DFS Approach
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