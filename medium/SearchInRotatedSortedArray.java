// Runtime: 5 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
// My Submission: https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/

/* Problem:
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
Your algorithm's runtime complexity must be in the order of O(log n)
 */

/* Explanation:
The pivot point doesn't really matter that much. We can still do binary search to find
the target value. We simply need to check to see if the left side or right side has the pivot,
and then see if the target value is present in the non-pivot side. That then determines
whether we want to search left or right.
*/

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return search(0, nums.length - 1, nums, target);
    }

    public int search(int left, int right, int[] nums, int target) {
        if (right < left) return -1;
        int middle = (right + left)/2;
        int value = nums[middle];
        if (value == target) return middle;
        if (value >= nums[left]) {
            // Pivot not to the left, so check there.
            if (target >= nums[left] && target < value) {
                return search(left, middle - 1, nums, target);
            }
            return search(middle + 1, right, nums, target);
        }
        else {
            // Pivot not to the right, so check there.
            if (target <= nums[right] && target > value) {
                return search(middle + 1, right, nums, target);
            }
            return search(left, middle - 1, nums, target);
        }
    }
}
