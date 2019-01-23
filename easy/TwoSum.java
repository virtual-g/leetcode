class Solution {
    // O(2n)
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
