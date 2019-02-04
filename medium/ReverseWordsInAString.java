// Runtime: 3 ms, faster than 81.40% of Java online submissions for Reverse Words in a String.
// My Submission: https://leetcode.com/submissions/detail/204936007/
// No Official Solution 

public class Solution {
    public String reverseWords(String s) {
        String trimmedInput = s.trim();
        if (trimmedInput.length() == 0) return "";

        Deque<String> words = new ArrayDeque<>();
        StringBuilder currentWord = new StringBuilder();

        // Push the words onto the deque
        for (char value : trimmedInput.toCharArray()) {
            if (value == ' ') {
                if (currentWord.length() == 0) continue;

                words.addFirst(currentWord.toString());
                currentWord = new StringBuilder();
            }
            else currentWord.append(value);
        }

        // Append the last word
        words.addFirst(currentWord.toString());

        StringBuilder answer = new StringBuilder();
        answer.append(words.removeFirst());

        while (!words.isEmpty()) {
            answer.append(" ");
            answer.append(words.removeFirst());
        }

        return answer.toString();
    }
}
