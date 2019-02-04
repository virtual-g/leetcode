// Runtime: 2 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
// Memory Usage: 26 MB
// My submission: https://leetcode.com/submissions/detail/205742560/
// No Official Solution

/*
 * Given a linked list, swap every two adjacent nodes and return its head.
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
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode newRoot = head.next;
        swap(head, null);
        return newRoot;
    }

    private void swap(ListNode first, ListNode previous) {
        if (first == null || first.next == null) return;
        ListNode second = first.next;
        ListNode third = second.next;
        second.next = first;
        first.next = third;
        if (previous != null) previous.next = second;
        swap(third, first);
    }
}
