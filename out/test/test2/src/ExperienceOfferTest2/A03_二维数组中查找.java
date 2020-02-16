package ExperienceOfferTest2;

public class A03_二维数组中查找 {
    public static void main(String[] args) {
        A03_二维数组中查找 test = new A03_二维数组中查找();
        int[][] array = {{2}};
        boolean re = test.Find(2, array);
        System.out.println();

    }
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {

            return false;
        }
        return findCore(target, array, 0, array.length-1, array[0].length - 1);
    }

    public boolean findCore(int target, int[][] array,int row, int row1, int col) {
        if (row > row1 || col < 0) {
            return false;
        }
        if (array[row][col] > target) {
            return findCore(target, array, row, row1, col - 1);
        }
        if (array[row][col] < target) {
            return findCore(target, array, row + 1, row1, col);
        }
        return true;
    }
}
