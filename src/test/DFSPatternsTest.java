
import static org.junit.Assert.*;

import org.junit.Test;

import DFSPatterns;

public class DFSPatternsTest {

    @Test
    public void testBasicPositionStack() {
        char[][] grid = {
            {'1', '1', '0', '0'},
            {'1', '0', '0', '1'},
            {'0', '0', '1', '1'},
            {'0', '1', '1', '0'}
        };
        DFSPatterns.BasicPositionStack dfs = new DFSPatterns.BasicPositionStack();
        dfs.exploreIsland(grid, 0, 0);
        
        char[][] expectedGrid = {
            {'0', '0', '0', '0'},
            {'0', '0', '0', '1'},
            {'0', '0', '1', '1'},
            {'0', '1', '1', '0'}
        };
        
        assertArrayEquals(expectedGrid, grid);
    }

    @Test
    public void testEncodedPositionStack() {
        char[][] grid = {
            {'1', '1', '0', '0'},
            {'1', '0', '0', '1'},
            {'0', '0', '1', '1'},
            {'0', '1', '1', '0'}
        };
        DFSPatterns.EncodedPositionStack dfs = new DFSPatterns.EncodedPositionStack();
        dfs.exploreIsland(grid, 0, 0);
        
        char[][] expectedGrid = {
            {'0', '0', '0', '0'},
            {'0', '0', '0', '1'},
            {'0', '0', '1', '1'},
            {'0', '1', '1', '0'}
        };
        
        assertArrayEquals(expectedGrid, grid);
    }

    @Test
    public void testDelayedMarkingStack() {
        char[][] grid = {
            {'1', '1', '0', '0'},
            {'1', '0', '0', '1'},
            {'0', '0', '1', '1'},
            {'0', '1', '1', '0'}
        };
        DFSPatterns.DelayedMarkingStack dfs = new DFSPatterns.DelayedMarkingStack();
        dfs.exploreIsland(grid, 0, 0);
        
        char[][] expectedGrid = {
            {'0', '0', '0', '0'},
            {'0', '0', '0', '1'},
            {'0', '0', '1', '1'},
            {'0', '1', '1', '0'}
        };
        
        assertArrayEquals(expectedGrid, grid);
    }

    @Test
    public void testStateTrackingStack() {
        char[][] grid = {
            {'1', '1', '0', '0'},
            {'1', '0', '0', '1'},
            {'0', '0', '1', '1'},
            {'0', '1', '1', '0'}
        };
        DFSPatterns.StateTrackingStack dfs = new DFSPatterns.StateTrackingStack();
        dfs.exploreIsland(grid, 0, 0);
        
        char[][] expectedGrid = {
            {'0', '0', '0', '0'},
            {'0', '0', '0', '1'},
            {'0', '0', '1', '1'},
            {'0', '1', '1', '0'}
        };
        
        assertArrayEquals(expectedGrid, grid);
    }
}