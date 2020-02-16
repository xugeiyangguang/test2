package ExperienceOfferTest2;

public class A24_二叉搜索树的后序遍历 {
    public static void main(String[] args) {
        A24_二叉搜索树的后序遍历 test = new A24_二叉搜索树的后序遍历();
        int[] sequence = {2, 3, 6, 3, 7, 4};
        boolean re = test.VerifySquenceOfBST(sequence);
        System.out.println();
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return VerifySquenceOfBSTCore(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBSTCore(int[] sequence, int start, int end) {
        if (end <= start) {
            return true;
        }
        int i = start;
        //找到节点中的左子树范围
        for (; i < end && sequence[i] < sequence[end]; i++);
        //检测右子树
        for (; i < end; i++) {
            if (sequence[i] < sequence[end]) {
                return false;
            }
        }
        return VerifySquenceOfBSTCore(sequence,start,i-1)&&VerifySquenceOfBSTCore(sequence,i,end);
    }
}
