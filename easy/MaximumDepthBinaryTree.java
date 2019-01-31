// Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
// My Submission: https://leetcode.com/submissions/detail/204524644/
// Official Solution: https://leetcode.com/problems/maximum-depth-of-binary-tree/solution/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        traverse(root, 0);
        return maxDepth;
    }

    private void traverse(TreeNode node, int depth) {
        int currentDepth = depth + 1;
        if (node.left == null && node.right == null) {
            if (currentDepth > maxDepth) maxDepth = currentDepth;
            return;
        }
        if (node.left != null) traverse(node.left, currentDepth);
        if (node.right != null) traverse(node.right, currentDepth);
        return;
    }
}
