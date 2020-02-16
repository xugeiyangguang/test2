package ExperienceOfferTest;

public class RectCover {
    public static void main(String[] args){
        for(int i=0; i<=8; i++){
            System.out.print(fRectCover(i)+"\t");
        }

    }
    public static int fRectCover(int target) {
        int[] num = {1,1};
        int result = 0;
        if(target<=0){
            return -1;
        }
        if(target==1){
            return target;
        }
        for(int i=2; i<=target; i++){
            result = num[0] + num[1];
            num[0] = num[1];
            num[1] = result;
        }
        return result;
    }
}
