// Runtime: 73 ms, faster than 97.04% of Java online submissions for Palindrome Number.
// My Submission: https://leetcode.com/submissions/detail/204976880/
// Official Solution: https://leetcode.com/problems/palindrome-number/solution/

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        return getReverse(x) == x;
    }

    private int getReverse(int x) {
        // Determine digits in x
        int x2 = x;
        int place = 1;
        while (x2 > 9) { place *= 10; x2 /= 10; }

        // Reverse the digits
        int y = 0;
        int d = 0;

        while (x > 0) {
            d = x % 10;
            y += (d * place);
            x /= 10;
            place /= 10;
        }

        return y;
    }
}
