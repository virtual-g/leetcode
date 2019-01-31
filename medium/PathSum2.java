// Runtime: 1 ms, faster than 100.00% of Java online submissions for Path Sum II.
// My Submission: https://leetcode.com/submissions/detail/204770653/
// No Official Solution

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
    private List<List<Integer>> paths = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return paths;
        getPath(root, sum, 0);
        return paths;
    }

    private void getPath(TreeNode node, int sum, int currentSum) {
        int newSum = currentSum + node.val;
        temp.add(node.val);
        if (node.left != null) getPath(node.left, sum, newSum);
        if (node.right != null) getPath(node.right, sum, newSum);

        if (node.left == null && node.right == null && newSum == sum) {
            paths.add(new ArrayList<Integer>(temp));
        }
        temp.remove(temp.size() - 1);
    }
}
