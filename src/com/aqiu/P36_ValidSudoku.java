package com.aqiu;

public class P36_ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new P36_ValidSudoku().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //链接：https://leetcode.cn/problems/valid-sudoku/solution/36-jiu-an-zhao-cong-zuo-wang-you-cong-shang-wang-x/
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int[][] row = new int[9][10];   //在第 i 个行中是否出现过
            int[][] column = new int[9][10];    //在第 j 个列中是否出现过
            int[][] box = new int[9][10];   //在第 j/3 + (i/3)*3个box中是否出现过

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.')
                        continue;
                    int index = board[i][j] - '0';
                    if (row[i][index] != 0)
                        return false;
                    if (column[j][index] != 0)
                        return false;
                    if (box[i / 3 + j / 3 * 3][index] != 0)
                        return false;
                    row[i][index] = 1;
                    column[j][index] = 1;
                    box[i / 3 + j / 3 * 3][index] = 1;
                }
            }
            return true;
        }
    }

    class Solution2 {
        public boolean isValidSudoku(char[][] board) {
            // 记录某行，某位数字是否已经被摆放
            boolean[][] row = new boolean[9][9];
            // 记录某列，某位数字是否已经被摆放
            boolean[][] column = new boolean[9][9];
            // 记录某 3x3 宫格内，某位数字是否已经被摆放
            boolean[][] box = new boolean[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.'){
                        int index = board[i][j] - '1';
                        int num = i / 3 + j / 3 * 3;
                        if (row[i][index] || column[j][index] || box[num][index])
                            return false;
                        row[i][index] = true;
                        column[j][index] = true;
                        box[num][index] = true;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}