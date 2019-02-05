// Runtime: 12 ms, faster than 52.31% of Java online submissions for Merge k Sorted Lists.
// Memory Usage: 30.9 MB, less than 19.04% of Java online submissions for Merge k Sorted Lists.
// My Submission: https://leetcode.com/submissions/detail/205766839/
// Official Solution: https://leetcode.com/problems/merge-k-sorted-lists/solution/

/*
 * Merge k sorted linked lists and return it as one sorted list.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        Queue<ListNode> queue = new PriorityQueue<>(lists.length, new ListNodeComparator());

        // Add just the root ListNode for each array in lists
        for (ListNode root : lists) if (root != null) queue.add(root);

        if (queue.isEmpty()) return null;

        // Store the root and add its next node. Note that the inputs come sorted
        // so we only need to add the next node as we go.
        ListNode root = queue.remove();
        if (root.next != null) queue.add(root.next);

        ListNode current = root;

        while (!queue.isEmpty()) {
            ListNode n = queue.remove();
            current.next = n;
            current = n;
            if (n.next != null) queue.add(n.next);
        }

        return root;
    }


    class ListNodeComparator implements Comparator<ListNode> {
        public int compare(ListNode n1, ListNode n2) {
            return Integer.compare(n1.val, n2.val);
        }
    }
}
