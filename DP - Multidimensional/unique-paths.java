
https://leetcode.com/problems/unique-paths/solutions/4801294/recurrsion-memoization-tabulation-easy-explaination

class Solution {
    
    // Recurrsion
    // This is a reccursive solution and will give TLE with reccursive solution, try these with DP
    // public int uniquePaths(int m, int n) {
    //     return f(m, n, m-1, n-1);
    //     }

    // public int f(int m, int n, int r, int c){
    //     if(r ==  || c == n-1){
    //         return 1;
    //     }
    //     if(r < 0 || c < 0){
    //         return 0;
    //     }
           
    //     int up= f(m, n, r-1, c);
    //     int left= f(m, n, r, c-1);
    //     return up + left;  
    // }

    
    //Memoization
    // public int uniquePaths(int m, int n) {
    //     int[][] dp= new int[m+1][n+1];
    //     for (int[] row : dp) {
    //         Arrays.fill(row, -1); // Initialize each cell of the array individually
    //     }
    //     return f(m, n, m-1, n-1, dp);
    //     }

    // public int f(int m, int n, int r, int c, int[][] dp){
    //     if(r == 0 || c == 0){
    //         return 1;
    //     }
    //     if(r < 0 || c < 0){
    //         return 0;
    //     }

    //     if(dp[r][c] != -1){
    //         return dp[r][c];
    //     }
    //     int up= f(m, n, r-1, c, dp);
    //     int left= f(m, n, r, c-1, dp);
    //     return dp[r][c]= up + left;
    // }


    // Tabulation
    public int uniquePaths(int m, int n) {
        int[][] dp= new int[m+1][n+1];
        dp[0][0]= 1;

        for(int i=0; i< m; i++){
            for(int j=0; j< n; j++){
                if(i==0 && j==0) continue;
                int up= 0;
                int left=0;
                if(i>0) up= dp[i-1][j];
                if(j>0) left= dp[i][j-1];
                dp[i][j]= up + left;            
            }
        }
        return dp[m-1][n-1];
   }
}


Intuition
Recursion:

The "uniquePaths" method calls the "f" method with the dimensions of the grid (m and n) and the index of the destination cell (m-1, n-1).
The "f" method recursively calculates the number of unique paths from the top-left corner (0, 0) to the current cell (r, c).
Base cases:
If the current cell is at the rightmost edge or the bottommost edge of the grid, there is only one possible path to reach it, so return 1.
If the current cell is out of bounds (i.e., r < 0 or c < 0), return 0.
Recursive cases:
Calculate the number of paths by recursively calling "f" for the cell above (r-1, c) and the cell to the left (r, c-1), then return the sum of these paths.
This solution uses pure recursion and may lead to a time limit exceeded (TLE) error for larger grid sizes due to redundant computations.

Memoization (Top-down Dynamic Programming):

The "uniquePaths" method initializes a 2D array "dp" to store the number of paths for each cell.
The "f" method is similar to the recursive approach but with additional memoization. It stores the result of each subproblem in the "dp" array to avoid redundant computations.
Before making a recursive call, it checks if the result for the current cell is already calculated. If yes, it returns the cached result from the "dp" array; otherwise, it calculates it recursively.
This approach optimizes the recursive solution by eliminating redundant computations, leading to improved time complexity.

Tabulation (Bottom-up Dynamic Programming):

The "uniquePaths" method initializes a 2D array "dp" to store the number of paths for each cell.
It iterates over each cell of the grid in a bottom-up manner, starting from (0, 0).
At each cell (i, j), it calculates the number of paths to reach that cell by summing the number of paths from the cell above (i-1, j) and the cell to the left (i, j-1).
The final result is stored in "dp[m-1][n-1]", which represents the number of unique paths to reach the destination cell (m-1, n-1).
This approach fills the "dp" array iteratively, avoiding recursion altogether. It offers the best time complexity among the three solutions, making it suitable for large grid sizes.

Complexity
Recursion:

Time Complexity: Exponential, O(2^(m+n)), where m is the number of rows and n is the number of columns in the grid. This is because the function recursively explores all possible paths in the grid.
Space Complexity: O(m + n) due to the recursion stack. This represents the maximum depth of the recursion stack, which is determined by the dimensions of the grid.

Memoization (Top-down Dynamic Programming):

Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid. This is because each cell in the grid is calculated only once and stored in the memoization table.
Space Complexity: O(m * n) for the memoization table. Additional space complexity of O(m + n) for the recursion stack.

Tabulation (Bottom-up Dynamic Programming):

Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid. This is because we fill in each cell of the memoization table exactly once.
Space Complexity: O(m * n) for the memoization table. No additional space is required for recursion stack as it's an iterative solution.
 
  
  
  
  
  
  
//   here is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

// Example 1:


// Input: m = 3, n = 7
// Output: 28
// Example 2:

// Input: m = 3, n = 2
// Output: 3
// Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
// 1. Right -> Down -> Down
// 2. Down -> Down -> Right
// 3. Down -> Right -> Down
