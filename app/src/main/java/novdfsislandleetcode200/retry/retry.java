package novdfsislandleetcode200.retry;
package Nov21AttemptRetry.retry;
package Nov21AttemptRetry.retry;
/* package nov21attemptretry.retry; 

Starting at (0,0):
- Visits current node
- Recursively visits all neighbors depth-first
- Natural order: typically explores in direction order (up, right, down, left)

Example path: Grid is 3x3
(0,0) → (0,1) → (0,2) → (1,2) → (2,2) → backtrack → (1,1) ...   

Starting at (0,0):
- Pushes current node to stack
- Pops node and visits all neighbors
- Reverse order: explores last pushed neighbor first (LIFO property)

Example path:
(0,0) → (0,1) → (1,0) → (1,1) → (2,0) → (2,1) ... */

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
