// Runtime: 18 ms, faster than 80.73% of Java online submissions for Reverse Integer.
// My submission: https://leetcode.com/submissions/detail/203249297/
// Official Solution: https://leetcode.com/problems/reverse-integer/solution/

/*
 * Given a 32-bit signed integer, reverse digits of an integer.
 */

class Solution {
    public int reverse(int x) {
        Deque<Integer> stack = new ArrayDeque<>();

        int multiplier = x > 0 ? 1 : -1;
        int d;
        while (x != 0) {
            d = x % 10;
            x /= 10;
            stack.addFirst(Math.abs(d));
        }

        int reversed = 0;
        int additional = 0;
        int place = 1;
        while (stack.peekFirst() != null) {
            // Check if greater than 2 billion
            if (place == 1000000000 && stack.peekFirst() > 2) return 0;

            // Check if the add will cause an overflow
            additional = place * stack.removeFirst();
            if (multiplier == 1) {
                if (Integer.MAX_VALUE - additional < reversed) return 0;
            }
            else {
                if (Integer.MIN_VALUE + additional > -1 * reversed) return 0;
            }

            reversed += additional;
            place *= 10;
        }

        return reversed * multiplier;
    }
}
