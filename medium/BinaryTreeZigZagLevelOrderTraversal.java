// Runtime: 1 ms, faster than 85.94% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
// My submission: https://leetcode.com/submissions/detail/204328209/
// No Official Solution

/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 */
 
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> currentLevel = new ArrayDeque<>();
        Deque<TreeNode> nextLevel = new ArrayDeque<>();

        List<List<Integer>> zigzag = new ArrayList<List<Integer>>();
        if (root == null) return zigzag;

        boolean isLeftToRight = true;
        currentLevel.addLast(root);

        while(true) {
            if (currentLevel.isEmpty()) break;
            List<Integer> orderedValues = processCurrentLevel(currentLevel, nextLevel, isLeftToRight);
            zigzag.add(orderedValues);
            isLeftToRight = !isLeftToRight;
            currentLevel = nextLevel;
            nextLevel = new ArrayDeque<>();
        }

        return zigzag;
    }

    private List<Integer> processCurrentLevel(Deque<TreeNode> currentLevel, Deque<TreeNode> nextLevel, boolean isLeftToRight) {
        List<Integer> orderedValues = new ArrayList<>();
        TreeNode node = null;
        while (!currentLevel.isEmpty()) {
            node = currentLevel.removeFirst();
            orderedValues.add(node.val);
            if (isLeftToRight) {
                if (node.left != null) nextLevel.addFirst(node.left);
                if (node.right != null) nextLevel.addFirst(node.right);
            }
            else {
                if (node.right != null) nextLevel.addFirst(node.right);
                if (node.left != null) nextLevel.addFirst(node.left);
            }
        }
        return orderedValues;
    }
}
