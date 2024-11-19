/* Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

Can you DFS or BFS to solve this problem.

Use a traversal technique to solve this problem.

Mark as visited

If visited before, then know that it is part of an island.

//DFS is usually the 'go to' for matrix problems and traversal problems.
Key Points:

Both approaches work because:

They both fully explore connected land cells
They both mark visited cells to avoid double-counting
They both ensure all cells are checked


DFS Advantages:

More memory efficient (uses recursion stack)
Simpler implementation
Better for long, snake-like islands


BFS Advantages:

Explores cells layer by layer
Better for wide, spread-out islands
No recursion stack overflow risk
Often easier to understand visually


Common Elements:

Both use marking visited cells (changing '1' to '0')
Both explore 4-directionally
Both maintain an island count
Both have O(m×n) time complexity


Choice between DFS/BFS:

For this problem, both are equally valid
Choice might depend on:

Expected island shapes
Memory constraints


Understand DFS in entirety. Will be important for the final and for interviews. 


 */

public class DFSMatrix {
  private static void dfs(int[][] matrix, boolean[][] visited, int row, int col) {
int numRows = matrix.length; 
int numCols = matrix[0].length;

// check if the current position is valid
if (row < 0 || col < 0 || row >= numRows || col >= numCols || visited[row][col] || matrix[row][col] == 0) { // if the position is out of bounds or already visited or is water, then return
  return; 
}

// mark the current position as visited
visited[row][col] = true; 

//process the current cell e.g. print it's value
System.out.println(matrix[row][col]+ " ");

// recursively visit all adjacent positions i.e adjacent cells 
dfs(matrix, visited, row + 1, col);   // down
dfs(matrix, visited, row - 1, col);   // up
dfs(matrix, visited, row, col + 1);   // right
dfs(matrix, visited, row, col - 1);  // left


// Ensure that the number of islands is counted



class Solution {
  private int numOfIslands = 0; 
    public int numIslands(char[][] grid) {
      char[][] islandCharArray = new char
            


      return numOfIslands; 
        }
    };

    