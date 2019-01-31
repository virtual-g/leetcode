// Runtime: 23 ms, faster than 76.59% of Java online submissions for ZigZag Conversion.
// My Solution: https://leetcode.com/submissions/detail/204932692/
// Offical Solution: https://leetcode.com/problems/zigzag-conversion/solution/

// NOTE: using StringBuilder made an appreciable difference, even though the compiler
// is supposed to optimize to it anyway. 
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int rowIndex = 0;
        boolean isIncrementing = true;

        for (char value : s.toCharArray()) {
            rows[rowIndex].append(value);

            if (isIncrementing) rowIndex++;
            else rowIndex--;

            if (rowIndex == numRows - 1) isIncrementing = false;
            if (rowIndex == 0) isIncrementing = true;
        }

        StringBuilder answer = new StringBuilder();
        for (StringBuilder row : rows) {
            answer.append(row.toString());
        }

        return answer.toString();
    }
}
