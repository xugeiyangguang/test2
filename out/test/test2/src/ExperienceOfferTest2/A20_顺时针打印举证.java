package ExperienceOfferTest2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class A20_顺时针打印举证 {
    ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        return printMatrix(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);

    }

    public ArrayList<Integer> printMatrix(int[][] matrix, int row_start, int row_end, int col_start, int col_end) {
        //从左到右
        for (int i = col_start; i <= col_end; i++) {
            arrayList.add(matrix[row_start][i]);
        }
        //从上到下
        for (int i = row_start + 1; i <= row_end; i++) {
            arrayList.add(matrix[i][col_end]);
        }
        //从右到左
        for (int i = col_end - 1; i >= col_start && row_end != row_start; i--) {
            arrayList.add(matrix[row_end][i]);
        }
        //从下到上
        for (int i = row_end - 1; i >= row_start + 1 && col_end != col_start; i--) {
            arrayList.add(matrix[i][col_start]);
        }
        if (row_end - row_start <= 1 || col_end - col_start <= 1) {
            return arrayList;
        }
        return printMatrix(matrix, row_start + 1, row_end - 1, col_start + 1, col_end - 1);
    }
}
