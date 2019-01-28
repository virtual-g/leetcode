// Runtime: 8 ms, faster than 46.30% of Java online submissions for Two Sum.
// My submission: https://leetcode.com/submissions/detail/201781910/
// Offical Solution: https://leetcode.com/problems/two-sum/solution/

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */

// NOTE: can be improved by using just one for loop.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Number, Index
        Map<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            cache.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (cache.containsKey(complement)) {
                int complementIndex = cache.get(complement);
                if (complementIndex == i) continue;
                int[] ans = {i, complementIndex};
                return ans;
            }
        }
        return null;
    }
}
