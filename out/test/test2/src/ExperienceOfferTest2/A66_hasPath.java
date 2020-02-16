package ExperienceOfferTest2;

public class A66_hasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }
        boolean[] flag = new boolean[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, i, j, str, flag, index)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, boolean[] flag, int index) {
        if (index == str.length) {
            return true;
        }
        boolean re = false;
        if (row < rows && 0 <= row && col < cols && 0 <= col && flag[row * cols + col] == false && matrix[row * cols + col] == str[index]) {
            index++;
            flag[row * cols + col] = true;
            re = hasPathCore(matrix, rows, cols, row + 1, col, str, flag, index) ||
                    hasPathCore(matrix, rows, cols, row - 1, col, str, flag, index) ||
                    hasPathCore(matrix, rows, cols, row, col + 1, str, flag, index) ||
                    hasPathCore(matrix, rows, cols, row, col - 1, str, flag, index);
            if (re == false) {
                index--;
                flag[row * cols + col] = false;
            }
        }
        return re;
    }
}
