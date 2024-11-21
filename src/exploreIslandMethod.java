public class exploreIslandMethod {    
private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
private void exploreIsland(char[][] grid, int row, int col) {
// Check boundary and land conditions
if (row < 0 || row >= grid.length ||
col < 0 || col >= grid[0].length ||
grid[row][col] != '1') {
return;
}
// Mark current cell as visited
grid[row][col] = '0';
// Recursively explore adjacent cells
for (int[] direction : DIRECTIONS) {
exploreIsland(
grid,
row + direction[0],
col + direction[1]
);
    }
}
}
