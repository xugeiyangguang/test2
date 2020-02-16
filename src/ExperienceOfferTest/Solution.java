package ExperienceOfferTest;

public class Solution {
    public static void main(String[] args){
        System.out.println(JumpFloorII(3));
    }
    public static int JumpFloorII(int target) {
        if(target<=0){
            return 0;
        }
        return (int)Math.pow(2.0,(double)target-1);
    }
}