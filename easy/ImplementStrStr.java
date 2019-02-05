// Runtime: 4 ms, 72.27%
// Memory Usage: 27.6 MB, 4.96%
// https://leetcode.com/submissions/detail/205927872/

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.isEmpty()) return -1;

        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();

        for (int i = 0; i < (hay.length - nee.length + 1); i++) {
            boolean isValid = true;
            for (int j = 0; j < nee.length; j++) {
                if (hay[i + j] != nee[j]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) return i;
        }

        return -1;
    }
}
