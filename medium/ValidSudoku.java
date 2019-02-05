// Attempt Optimized for Speed and Clarity
// Runtime: 15 ms, faster than 80.00% of Java online submissions for Valid Sudoku.
// Memory Usage: 35.3 MB, less than 28.63% of Java online submissions for Valid Sudoku.
// My submission: https://leetcode.com/submissions/detail/204328209/

/*
 * Determine if a 9x9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 *   Each row must contain the digits 1-9 without repetition.
 *   Each column must contain the digits 1-9 without repetition.
 *   Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer> cache = new HashSet<Integer>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                int input = board[j][i] - '0';
                if (!cache.add(10 * input + i) ||
                    !cache.add(100 * input + j) ||
                    !cache.add(1000 * input + 100 * (i/3) + 10 * (j/3))) return false;
            }
        }

        return true;
    }
}

// Original Attempt
// Runtime: 16 ms, faster than 68.69% of Java online submissions for Valid Sudoku.
// Memory Usage: 30.8 MB, less than 79.28% of Java online submissions for Valid Sudoku.
// My submission: https://leetcode.com/submissions/detail/205793948/
class Solution {
    // Numbers 0-8 represent the rows
    // Numbers 10-18 represent the columns
    // Numbers 20-28 represent the boxes
    Map<Integer, Set<Integer>> map = new HashMap<>();

    public boolean isValidSudoku(char[][] board) {
        for (int i = 1; i < 10; i++) map.put(i, new HashSet<Integer>());

        if (!helper(0, 0, 20, board)) return false;
        if (!helper(0, 3, 21, board)) return false;
        if (!helper(0, 6, 22, board)) return false;
        if (!helper(3, 0, 23, board)) return false;
        if (!helper(3, 3, 24, board)) return false;
        if (!helper(3, 6, 25, board)) return false;
        if (!helper(6, 0, 26, board)) return false;
        if (!helper(6, 3, 27, board)) return false;
        if (!helper(6, 6, 28, board)) return false;

        return true;
    }

    private boolean helper(int x, int y, int box, char[][] board) {
        for (int i = x; i < x+3; i++) {
            for (int j = y; j < y+3; j++) {
                int input = board[j][i] - '0';
                if (input != -2 && !isValid(i, j, box, input)) return false;
            }
        }

        return true;
    }

    private boolean isValid(int row, int column, int box, int input) {
        Set<Integer> inputSet = map.get(input);
        if (inputSet.contains(row) || inputSet.contains(column + 10) || inputSet.contains(box)) {
            return false;
        }
        else {
            inputSet.add(row);
            inputSet.add(column + 10);
            inputSet.add(box);
        }
        return true;
    }
}
