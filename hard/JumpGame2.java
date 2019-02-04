// Runtime: 111 ms, faster than 40.63% of Java online submissions for Jump Game II.

class Solution {
    public int jump(int[] nums) {
        int lastIndex = nums.length - 1;
        int currentJumps = 0;

        while (lastIndex != 0) {
            for (int i = 0; i < lastIndex; i++) {
                if (nums[i] >= (lastIndex - i)) {
                    currentJumps++;
                    lastIndex = i;
                    break;
                }
            }
        }

        return currentJumps;
    }
}

// Runtime: 128 ms, faster than 40.34% of Java online submissions for Jump Game II.
class Solution {
    int minimum = 0;

    public int jump(int[] nums) {
        helper(nums, nums.length - 1, 1);
        return minimum;
    }

    private void helper(int[] nums, int index, int currentJumps) {
        for (int i = 0; i < index; i++) {
            if (nums[i] >= (index - i)) {
                if (i == 0) minimum = currentJumps;
                else helper(nums, i, currentJumps + 1);
                return;
            }
        }
    }
}
