https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/solutions/4678097/simple-and-quick-dfs-solution-explained
class Solution {
    int maxZigZag = 0;

    public int longestZigZag(TreeNode root) {
        longestZigZag(root, 0, 0);
        return maxZigZag;
    }

    private void longestZigZag(TreeNode root, int currZigZag, int direction) {

        if (root == null) {
            return;
        }
        maxZigZag = Math.max(currZigZag, maxZigZag);
        
        if (direction == 0) {
            longestZigZag(root.left, currZigZag + 1, 1);
            longestZigZag(root.right, currZigZag + 1, -1);
        } else if (direction == -1) {
            longestZigZag(root.left, currZigZag + 1, 1);
            longestZigZag(root.right, 1, -1);
        } else {
            longestZigZag(root.left, 1, 1);
            longestZigZag(root.right, currZigZag + 1, -1);
        }
    }
}


Idea
The core idea behind this solution is to recursively traverse the binary tree while keeping track of the current ZigZag path length and the direction of movement (left or right). By exploring all possible ZigZag paths starting from each node, the algorithm can determine the maximum ZigZag length encountered during the traversal.

Approach
Recursive Function: The solution defines a recursive helper function, longestZigZag, which takes three arguments: the current node (root), the current ZigZag path length (currZigZag), and the direction of the last move (direction). The direction is indicated by an integer, where 0 is used for the initial call to indicate no direction, 1 for a move to the left, and -1 for a move to the right.
Base Case: The recursion terminates when a null node is encountered, indicating the end of a path. This is a base case where the function simply returns without making further recursive calls.
Updating Maximum Length: At each step, the algorithm updates the global variable maxZigZag if the current ZigZag path length is greater than the previously recorded maximum length. This ensures that the maximum length is always kept updated with the longest path found so far.
Recursive Calls: The function makes recursive calls to explore both the left and right children of the current node, with adjustments to the path length and direction based on the current direction:
If the direction is 0 (initial call), it explores both directions from the current node, incrementing the path length for both left and right moves.
If the direction is -1 (last move was right), it continues the ZigZag path to the left (incrementing the path length) and starts a new path to the right.
If the direction is 1 (last move was left), it starts a new path to the left and continues the ZigZag path to the right (incrementing the path length).
Handling Directions: The direction handling ensures that the path alternates between left and right moves, fulfilling the ZigZag criteria. By resetting the path length to 1 when changing directions, the algorithm correctly accounts for the start of a new ZigZag sequence from the current node in the specified direction.
Conclusion
This approach effectively explores all possible ZigZag paths in the binary tree by leveraging depth-first search (DFS). By maintaining a global variable to track the maximum path length and using a recursive strategy to explore all paths, the solution efficiently identifies the longest ZigZag path in the tree.

Complexity
Time complexity: O(n), where n is the total number of nodes in the binary tree.

Space complexity: The space complexity is O(h), where h is the height of the binary tree. This simplifies to O(n) in the worst case (for a skewed tree) and O(log n) for a balanced tree.



  You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follow:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
Change the direction from right to left or from left to right.
Repeat the second and third steps until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.

 

Example 1:


Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
Example 2:


Input: root = [1,1,1,null,1,null,null,1,1,null,1]
Output: 4
Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
Example 3:

Input: root = [1]
Output: 0
