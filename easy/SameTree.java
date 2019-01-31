// Second Attempt: Runtime: 3 ms, faster than 35.64% of Java online submissions for Same Tree.
// My Solution: https://leetcode.com/submissions/detail/204347108/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Check root nodes
        if (!isSame(p, q)) return false;
        if (p == null && q == null) return true;

        // Traverse the trees
        return traverse(p, q);
    }

    private boolean traverse(TreeNode p, TreeNode q) {
        if (!isSame(p.left, q.left)) return false;
        if (!isSame(p.right, q.right)) return false;

        if (p.left != null && !traverse(p.left, q.left)) return false;
        if (p.right != null && !traverse(p.right, q.right)) return false;
        return true;
    }

    public static boolean isSame(TreeNode first, TreeNode second) {
        if (first == null && second != null || first != null && second == null) return false;
        if (first == null && second == null) return true;
        return first.val == second.val;
    }
}


// First Attempt: Runtime: 3 ms, faster than 35.64% of Java online submissions for Same Tree.

/*class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> firstTree = new ArrayList<>();
        List<Integer> secondTree = new ArrayList<>();

        if (p != null) traverse(p, firstTree);
        if (q != null) traverse(q, secondTree);

        if (firstTree.size() != secondTree.size()) return false;

        for (int i = 0; i < firstTree.size(); i++) {
            if (!firstTree.get(i).equals(secondTree.get(i))) return false;
        }

        return true;
    }

    private void traverse(TreeNode node, List<Integer> list) {
        list.add(node.val);

        if (node.left == null) { list.add(0); }
        else { traverse(node.left, list); }

        if (node.right == null) { list.add(0); }
        else { traverse(node.right, list); }
    }
}*/
