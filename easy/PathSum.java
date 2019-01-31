// Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
// My Submission: https://leetcode.com/submissions/detail/204718667/

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return hasPathSum(root, sum, 0);
    }

    private boolean hasPathSum(TreeNode node, int sum, int currentSum) {
        int newSum = currentSum + node.val;
        if (node.left != null && hasPathSum(node.left, sum, newSum)) return true;
        if (node.right != null && hasPathSum(node.right, sum, newSum)) return true;
        if (node.left == null && node.right == null) return newSum == sum;
        return false;
    }
}

/*
// Official Solution: https://leetcode.com/problems/path-sum/solution/
class Solution {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null)
      return false;

    sum -= root.val;
    if ((root.left == null) && (root.right == null))
      return (sum == 0);
    return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
  }
}
*/
