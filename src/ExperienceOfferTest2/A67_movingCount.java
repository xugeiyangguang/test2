package ExperienceOfferTest2;

public class A67_movingCount {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 1 || cols < 1) {
            return 0;
        }
        int[] flag = new int[rows * cols];
        return movingCountCore(threshold, rows, cols, 0, 0, flag);
    }

    public int movingCountCore(int threshold, int rows, int cols, int row, int col, int[] flag) {
        int total = 0;
        if (0 <= col && col < cols && 0 <= row && row < rows && flag[row * cols + col] == 0 &&
                (getDigitNumber(col) + getDigitNumber(row) <= threshold)) {
            flag[row * cols + col] = 1;
            total = 1 + movingCountCore(threshold, rows, cols, row + 1, col, flag) +
                    movingCountCore(threshold, rows, cols, row - 1, col, flag) +
                    movingCountCore(threshold, rows, cols, row, col - 1, flag) +
                    movingCountCore(threshold, rows, cols, row, col + 1, flag);
        }
        return total;
    }

    public int getDigitNumber(int num) {
        int re = 0;
        while (num > 0) {
            re += num % 10;
            num /= 10;
        }
        return re;
    }
}
