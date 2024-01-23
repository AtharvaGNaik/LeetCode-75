class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;

        // Keep track of the frequency of each row.
        Map<String, Integer> rowCounter = new HashMap<>();
        for (int[] row : grid) 
        {
            String rowString = Arrays.toString(row);
            rowCounter.put(rowString, 1 + rowCounter.getOrDefault(rowString, 0));
        }

        // Add up the frequency of each column in the map.
        for (int c = 0; c < n; c++) 
        {
            int[] colArray = new int[n];
            for (int r = 0; r < n; r++) 
            {
                colArray[r] = grid[r][c];
            }
            count += rowCounter.getOrDefault(Arrays.toString(colArray), 0);
        }

        return count;
    }
}



// Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
// A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
// Example 1:
// Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
// Output: 1
// Explanation: There is 1 equal row and column pair:
// - (Row 2, Column 1): [2,7,7]

// Example 2

// Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
// Output: 3
// Explanation: There are 3 equal row and column pairs:
// - (Row 0, Column 0): [3,1,2,2]
// - (Row 2, Column 2): [2,4,2,2]
// - (Row 3, Column 2): [2,4,2,2]



The intuition behind the code is to iterate through each row of the grid and keep track of the frequency of each row using a map. Then, for each column, construct a temporary array by extracting the elements of the column. Convert this array to a string and check its frequency in the row frequency map. Add the frequency to the total count.

Approach
Initialize the count variable to 0 and the size of the grid, n.
Create a map called rowCounter to keep track of the frequency of each row.
Iterate through each row of the grid:
Convert the row array to a string using Arrays.toString().
Increment the frequency of the row string in the rowCounter map.
Iterate through each column of the grid:
Create a temporary array called colArray to store the elements of the column.
Extract the elements of the column by iterating through the rows and accessing the corresponding element.
Convert the colArray to a string using Arrays.toString().
Retrieve the frequency of the column string from the rowCounter map using getOrDefault().
Add the frequency to the count variable.
Return the count.
Complexity
Time complexity:
The time complexity of the solution is O(n^2), where n is the size of the grid. The code iterates through each row and column of the grid once, and the operations performed within the loops are constant time.

Space complexity:
The space complexity of the solution is O(n^2). It uses additional space to store the rowCounter map, which can contain up to n^2 entries in the worst case.
