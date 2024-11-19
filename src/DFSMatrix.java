
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
  
    }  
}

    // Ensure that the number of islands is counted
  
  