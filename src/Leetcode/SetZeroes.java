package Leetcode;

import java.util.HashSet;

public class SetZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 0, 6}};
        new SetZeroes().setZeroes(matrix);
        System.out.println(matrix);
    }
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i:row
             ) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int j : col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }


}
