// Runtime: 21 ms, faster than 93.90% of Java online submissions for Add Two Numbers.
// My submission: https://leetcode.com/submissions/detail/203227704/
// Official Solution: https://leetcode.com/problems/add-two-numbers/solution/

/*
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = l1.val + l2.val;
        int addOne = 0;
        if (sum > 9) {
            addOne = 1;
            sum -= 10;
        }
        ListNode root = new ListNode(sum);
        ListNode current = root;

        int l1Value;
        int l2Value;

        while (true) {
            l1Value = 0;
            l2Value = 0;

            if (l1 != null) {
                l1 = l1.next;
                if (l1 != null) { l1Value = l1.val; }
            }

            if (l2 != null) {
                l2 = l2.next;
                if (l2 != null) { l2Value = l2.val; }
            }

            if (l1 == null && l2 == null) {
                if (addOne > 0) {
                    current.next = new ListNode(1);
                }
                break;
            }

            sum = l1Value + l2Value + addOne;
            addOne = 0;
            if (sum > 9) {
                addOne = 1;
                sum -= 10;
            }
            current.next = new ListNode(sum);
            current = current.next;
        }

        return root;
    }
}
