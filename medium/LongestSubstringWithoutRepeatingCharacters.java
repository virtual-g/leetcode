// Runtime: 26 ms, faster than 71.44% of Java online submissions for Longest Substring Without Repeating Characters.
// My Solution: https://leetcode.com/submissions/detail/204756990/
// Offical Solution: https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;

        int maximumLength = 0;
        Set<Character> set = new HashSet<>();
        Deque<Character> queue = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        for (char value : chars) {
            queue.addLast(value);
            if (set.contains(value)) {
                while (true) {
                    Character last = queue.removeFirst();
                    if (last.equals(value)) { break; }
                    else set.remove(last);
                }
            }
            else set.add(value);
            maximumLength = Math.max(maximumLength, queue.size());
        }

        return maximumLength;
    }
}
