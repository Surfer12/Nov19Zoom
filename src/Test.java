public class Test {

    public static void main(String[] args) {
        IslandDFSSolutionCurrent solution = new IslandDFSSolutionCurrent();
    
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
