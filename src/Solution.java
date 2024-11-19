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


class Solution {
  private int numOfIslands = 0; 
    public int numIslands(char[][] grid) {
      char[][] islandCharArray = new char
            


      return numOfIslands; 
        }
    };

    