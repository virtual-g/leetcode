// Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
// My Submission: https://leetcode.com/submissions/detail/204353477/
// Official Solution: https://leetcode.com/problems/validate-binary-search-tree/solution/
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValid(root, null, null);
    }

    public boolean isValid(TreeNode node, Integer maxAllowed, Integer minAllowed) {
        if (node.left != null) {
            if (node.left.val >= node.val) return false;
            if (maxAllowed != null && node.left.val >= maxAllowed) return false;
            if (minAllowed != null && node.left.val <= minAllowed) return false;
            if (!isValid(node.left, node.val, minAllowed)) return false;
        }
        if (node.right != null) {
            if (node.right.val <= node.val) return false;
            if (maxAllowed != null && node.right.val >= maxAllowed) return false;
            if (minAllowed != null && node.right.val <= minAllowed) return false;
            if (!isValid(node.right, maxAllowed, node.val)) return false;
        }
        return true;
    }
}
