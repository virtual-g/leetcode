// NOTE: needed help with this one

class Solution {
    List<String> answer = new ArrayList<>();
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder temp = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return answer;
        helper(digits, 0);
        return answer;
    }

    private void helper(String digits, int start) {
        if (start >= digits.length()) {
            answer.add(temp.toString());
            return;
        }

        int digit = digits.charAt(start) - '0';
        for (char val : map[digit].toCharArray()) {
            temp.append(val);
            helper(digits, start + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
