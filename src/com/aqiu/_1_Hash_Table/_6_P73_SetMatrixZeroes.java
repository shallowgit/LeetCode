package com.aqiu._1_Hash_Table;

/**
 * @author Aqiu
 */
public class _6_P73_SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new _6_P73_SetMatrixZeroes().new Solution();
        solution.setZeroes(new int[][]{{1, 2, 3}});
    }

    class Solution {
        //使用两个标记变量
        //思路和算法
        //我们可以用矩阵的第一行和第一列代替方法一中的两个标记数组，以达到O(1)的额外空间。但这样会导致原数组的第一行和第一列被修改，无法记录它们是否原本包含0。因此我们需要额外使用两个标记变量分别记录第一行和第一列是否原本包含0。
        //在实际代码中，我们首先预处理出两个标记变量，接着使用其他行与列去处理第一行与第一列，然后反过来使用第一行与第一列去更新其他行与列，最后使用两个标记变量更新第一行与第一列即可。
        public void setZeroes(int[][] matrix) {
            int rowLength = matrix.length;
            int columnLength = matrix[0].length;
            boolean row = false;
            boolean column = false;
            for (int i = 0; i < rowLength; i++) {
                if (matrix[i][0] == 0) {
                    column = true;
                }
            }
            for (int i = 0; i < columnLength; i++) {
                if (matrix[0][i] == 0) {
                    row = true;
                }
            }
            for (int i = 1; i < rowLength; i++) {
                for (int j = 1; j < columnLength; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            for (int i = 1; i < rowLength; i++) {
                for (int j = 1; j < columnLength; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (column) {
                for (int i = 0; i < rowLength; i++) {
                    matrix[i][0] = 0;
                }
            }
            if (row) {
                for (int i = 0; i < columnLength; i++) {
                    matrix[0][i] = 0;
                }
            }
        }
    }

    class Solution2 {
        //方法三：使用一个标记变量
        //思路和算法
        //我们可以对方法二进一步优化，只使用一个标记变量记录第一列是否原本存在0。这样，第一列的第一个元素即可以标记第一行是否出现0。但为了防止每一列的第一个元素被提前更新，我们需要从最后一行开始，倒序地处理矩阵元素。
        public void setZeroes(int[][] matrix) {
            int rowLength = matrix.length;
            int columnLength = matrix[0].length;
            boolean flag = false;
            for (int i = 0; i < rowLength; i++) {
                if (matrix[i][0] == 0) {
                    flag = true;
                }
                //设置标兵是从前往后设
                for (int j = 1; j < columnLength; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            //根据标兵设0是从后往前设，因为如果是从前往后，那么如果第一排被设为0了，会影响后面排的设0，让本不应该是0的变为了0
            for (int i = rowLength - 1; i >= 0; i--) {
                for (int j = 1; j < columnLength; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
                if (flag) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}