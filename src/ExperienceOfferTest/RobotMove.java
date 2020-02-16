package ExperienceOfferTest;

public class RobotMove {
    public static void main(String[] args) {

    }
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[] visit = new boolean[rows*cols];
        return movingCountCore(threshold,rows,cols,0,0,visit);
    }
    public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visit){
        int count = 0;
        if (check(threshold,rows,cols,row,col,visit)){
            visit[row* cols + col] = true;

            count = 1 + movingCountCore(threshold,rows,cols,row+1,col,visit)
                    + movingCountCore(threshold,rows,cols,row-1,col,visit)
                    + movingCountCore(threshold,rows,cols,row,col+1,visit)
                    + movingCountCore(threshold,rows,cols,row,col-1,visit);
        }
        return count;
    }
    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visit ){
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visit[row* cols + col]&&
        getDigit(row)+getDigit(col) <= threshold){
            return true;
        }
        return false;
    }
    public int getDigit(int number){
        int sum = 0;
        while (number > 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

}
