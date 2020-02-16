package ExperienceOfferTest;

import java.util.ArrayList;

public class PrintMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        ArrayList<Integer> newList = printMatrix(matrix);

        for (int i:newList
        ) {
            System.out.println(i);
        }
    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
            return null;
        }
        int start = 0;
        ArrayList<Integer> newList = new ArrayList<>();
        while (matrix.length > start * 2 && matrix[0].length > start *2){
            PrintMatrixInCircle(matrix,start,newList);
            ++start;
        }
        return  newList;


    }
    public static void PrintMatrixInCircle(int[][] matrix,int start,ArrayList<Integer> newList){
        int endX = matrix[0].length-1-start;
        int endY = matrix.length-1-start;
        /*从左到右打印*/
        for(int i = start; i<=endX; i++){
            newList.add(matrix[start][i]);
        }
        /*从上到下打印*/
        if(start < endY){
            for(int i = start + 1; i < endY+1; i++){
                newList.add(matrix[i][endX]);
            }
        }
        /*从右到左的打印*/
        if(start < endY && start < endX){
            for(int i = endX -1; i >= start ; i--){
                newList.add(matrix[endY][i]);
            }
        }
        /*从下到上*/
        if(start < endX && start < endY -1){
            for(int i = endY - 1; i>start; i--){
                newList.add(matrix[i][start]);
            }
        }
    }
}
