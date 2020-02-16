package Leetcode;

public class MinPath {
    public static void main(String[] args) {
        int[][] grid = {{1, 2}, {1, 1}};
        MinPath test = new MinPath();
        int re = test.minPathSum(grid);
        System.out.println();

    }
    private int max = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        int sum = grid[0][0];
        func(grid,0,0,sum);
        return max;
    }
    public void func(int[][] grid,int i,int j,int sum){
        if(i==grid.length-1&&j==grid[0].length-1){
            max = Math.min(sum,max);
            return;
            // return 0;
        }
        //向左走
        if(j<grid[0].length-1){
            func(grid,i,j+1,sum+grid[i][j+1]);
        }
        //向右走
        if(i<grid.length-1){
            func(grid,i+1,j,sum+grid[i+1][j]);
        }
    }
}
