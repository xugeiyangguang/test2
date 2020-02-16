package Companies.Else;

import java.util.ArrayList;

public class PrintMatrix {
    static ArrayList<Integer> re = new ArrayList<>();
    public static void main(String[] args) {
        int[][] a = {{1,2},{3,4}};
        re = printMatrix(a);
        for (int i = 0; i < re.size(); i++) {
            System.out.print(re.get(i));
        }

    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        func(matrix,0,0,matrix.length-1,matrix[0].length-1);
        return re;

    }
    public static void func(int[][] matrix,int row,int col,int rows,int cols){
        if(row>rows||col>cols){
            return;
        }
        int i = row;
        int j = col;
        while(j<=cols){
            re.add(matrix[i][j]);
            j++;
        }
        i++;
        while(i<=rows){
            re.add(matrix[i][cols]);
            i++;
        }
        j = cols - 1;
        while(j>=col){
            re.add(matrix[rows][j]);
            j--;
        }
        i = rows - 1;
        while(i>row){
            re.add(matrix[i][col]);
            i--;
        }
        func(matrix,row+1,col+1,rows-1,cols-1);
    }
}
