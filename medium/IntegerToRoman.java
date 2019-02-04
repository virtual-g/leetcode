// Runtime: 37 ms, faster than 75.65% of Java online submissions for Integer to Roman.
// My Submission: https://leetcode.com/submissions/detail/204966101/
// No Official Solution

// Given an integer, convert it to a roman numeral.
// Input is guaranteed to be within the range from 1 to 3999.
class Solution {
    public String intToRoman(int num) {
        StringBuilder answer = new StringBuilder();

        while (num > 0) {
            if (num >= 1000) { num -= 1000; answer.append("M"); }
            else if (num >= 900) { num -= 900; answer.append("CM"); }
            else if (num >= 500) { num -= 500; answer.append("D"); }
            else if (num >= 400) { num -= 400; answer.append("CD"); }
            else if (num >= 100) { num -= 100; answer.append("C"); }
            else if (num >= 90) { num -= 90; answer.append("XC"); }
            else if (num >= 50) { num -= 50; answer.append("L"); }
            else if (num >= 40) { num -= 40; answer.append("XL"); }
            else if (num >= 10) { num -= 10; answer.append("X"); }
            else if (num >= 9) { num -= 9; answer.append("IX"); }
            else if (num >= 5) { num -= 5; answer.append("V"); }
            else if (num >= 4) { num -= 4; answer.append("IV"); }
            else { num -= 1; answer.append("I"); }
        }

        return answer.toString();
    }
}


// Very cool solution:
/*
public static String intToRoman(int num) {
    String M[] = {"", "M", "MM", "MMM"};
    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
}
*/
