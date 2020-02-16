package ExperienceOfferTest;

public class Solution1 {
    public static void main(String[] args){
        /*从左到右，从上到下的递增数组*/
        int[][] array={{1,3},{2,4}};
        int target=2;
        /*在静态的环境只能引用静态的方法，，返回值为布尔型*/
        /*静态方法不能使用类的非静态变量*/
        boolean r = Find(target,array);
        System.out.println(r);
    }
    public static boolean Find(int target, int [][] array) {
        boolean found = false;
        /*二维数组非空检测，数组的行和列*/
        if(array!=null&&array.length>0&&array[0].length>0){
            int row = 0;
            int column =array[0].length-1;
            /*使用最右上角的和目标数据比较*/
            while(row<array.length&&column>=0){
                if(array[row][column]==target){
                    found=true;
                    break;
                }
                else if(array[row][column]>target){
                    column--;
                }
                else{
                    row++;
                }
            }
        }
        return found;
    }
}