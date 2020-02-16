package Leetcode;

public class 快速查找矩阵元素 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        boolean re = searchMatrix(matrix, 20);
        System.out.println(re);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        return func(matrix,0,matrix.length-1,target);
    }
    public static boolean func(int[][] matrix,int start,int end,int target){
        if(start>end){
            return false;
        }
        if(start==end){
            for(int i=0;i<matrix[0].length;i++){
                if(matrix[start][i]==target){
                    return true;
                }
            }
            return false;
        }
        if(matrix[start][matrix[0].length-1]<target){
            return func(matrix,start+1,end,target);
        }else if(matrix[start][matrix[0].length-1]>target){
            return func(matrix,start,end-1,target);
        }else{
            return true;
        }
    }
}
