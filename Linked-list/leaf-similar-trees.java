https://leetcode.com/problems/leaf-similar-trees/solutions/4532191/beats-99-98-users-c-java-python-javascript-with-explanation
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> nodeList1 = new ArrayList<>();
        List<Integer> nodeList2 = new ArrayList<>();
        findLeafDfs(root1, nodeList1);
        findLeafDfs(root2, nodeList2);
        return nodeList1.equals(nodeList2);
    }

    private void findLeafDfs(TreeNode node, List<Integer> nodeList) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            nodeList.add(node.val);
        } else {
            findLeafDfs(node.left, nodeList);
            findLeafDfs(node.right, nodeList);
        }
    }
}


// Approach
// 1. Recursive Leaf Collection:

// The findLeaf_dfs function traverses the given tree recursively, collecting leaf node values in a vector.
// It stops when a node has no children (a leaf node) and adds its value to the vector.
// 2. Separate Traversals for Comparison:

// The leafSimilar function calls findLeaf_dfs twice, once for each tree, to get separate lists of leaf node values.
// 3. Direct List Comparison:

// The function directly compares the two lists of leaf node values using the == operator.
// This efficiently checks if the leaf nodes have the same values in the same order.
// 4. Return Similarity Verdict:

// The function returns true if the lists are identical, indicating leaf similarity, and false otherwise.
// Time Complexity:

// O(N), where N is the number of nodes in the larger tree.
// The traversal visits each node once, and the comparison of leaf node lists takes linear time.
// Space Complexity:

// O(N) in the worst case
// The nodeList vectors can potentially hold up to N values in case of a skewed tree.
// The recursion calls also use additional space on the call stack, proportional to the tree's height.


Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence
For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
Two binary trees are considered leaf-similar if their leaf value sequence is the same.
Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

Example 1:
Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true
  
Example 2:
Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false
 
