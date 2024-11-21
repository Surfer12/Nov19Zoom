 /**
 * Solution for the Number of Islands problem using Depth-First Search (DFS).
 * The problem: Given a 2D grid of '1's (land) and '0's (water), count the number
 * of distinct islands. An island is surrounded by water and formed by connecting
 * adjacent '1's horizontally or vertically.
 *  
 */
class RecursiveTraversal {
  private static final int[][] DIRECTIONS = {
      {-1, 0},  // up
      { 0, 1},   // right
      {1, 0},  // down
      {0, -1}  // left
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
      if (row < 0 || row >= grid.length) {
          return;
      }
      if (col < 0 || col >= grid[0].length) {
          return;
      }
      if (grid[row][col] != '1') {
          return; // current cell is not land
      }
      
      // Mark current cell as visited 
      grid[row][col] = '0'; // mark current cell as visited and turn it into water
      
      // Explore all adjacent cells recursively as long as they are land
      for (int[] direction : DIRECTIONS) {
          exploreIsland( // recursively explore all adjacent cells
              grid, // grid to explore
              row + direction[], // new row visit next cell to the left
              if(direction[0] == -1) { // if direction has reached the boundary
                  return;
              } else if (direction[0] == 1) { // if direction is still in island
                  islandVisitAttempt++; // increment the number of island visit attempts
                  return;
              }
              col + direction[1], // new row visit next cell to the right
              if(direction[1] == -1) { // if direction has reached the boundary
                  return;
              } else if (direction[1] == 1) { // if direction is still in island
                  islandVisitAttempt++; // increment the number of island visit attempts
                  return;
              }
          );
      }
  }
  
  /**
   * Test cases demonstrating usage of the solution.
   */
  public static void main(String[] args) {
       RecursiveTraversal solution = new RecursiveTraversal();
      
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
      System.out.println("Recursive DFS (natural order):");
      printTraversalOrder(grid, true);
      
      System.out.println("Iterative DFS (reverse order):");
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
