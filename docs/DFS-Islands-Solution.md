# Solving Number of Islands (LeetCode 200) with Depth-First Search

## Problem Overview
The Number of Islands problem requires counting the number of distinct islands in a 2D grid where:
- `'1'` represents land
- `'0'` represents water
- Islands are formed by connecting adjacent land cells horizontally or vertically

### Problem Examples
1. Single Island Example:


### 2. Object Pooling for Optimization

java
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


## Visualization of DFS Traversal

### Sequence Diagram
![DFS Sequence Diagram](dfs-sequence-diagrams.mermaid)

The sequence diagram illustrates the flow of recursive and iterative DFS, showing:
- Method calls
- Visited cell tracking
- Backtracking mechanism

### State Diagram
![DFS State Diagram](dfs-state-diagrams.mermaid)

The state diagram highlights the key differences between recursive and iterative approaches:
- Recursive: System stack manages state
- Iterative: Explicit stack and manual state tracking

## Performance Considerations

### Time Complexity
- O(m * n), where m is rows and n is columns
- Each cell is visited exactly once

### Space Complexity
- Recursive: O(m * n) worst case (deep recursion)
- Iterative: O(min(m, n)) for stack space

## Optimization Techniques

1. Bit Manipulation for Position Encoding
java
private static int encodePosition(int row, int col, int cols) {
return row cols + col;
}

2. Efficient Visited Tracking

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

This comprehensive markdown document provides an in-depth exploration of solving the Number of Islands problem using Depth-First Search (DFS), incorporating code samples, diagrams, and detailed explanations of various implementation strategies.
The document covers:
Problem description
Recursive and iterative DFS approaches
Advanced optimization techniques
Visualization of traversal methods
Performance considerations
Key takeaways and recommendations