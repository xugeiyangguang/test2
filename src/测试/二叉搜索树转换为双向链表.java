package 测试;

public class 二叉搜索树转换为双向链表 {
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(4);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(1);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = null;
        a3.left = null;
        a4.left = null;
        a3.right = null;
        a4.right = null;
        二叉搜索树转换为双向链表 test = new 二叉搜索树转换为双向链表();

        TreeNode re = test.Convert(a1);
        System.out.println();
    }
    public TreeNode last = null;
    public  TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }

        func(pRootOfTree);
        while(last!=null&&last.left!=null){
            last = last.left;
        }
        return last;
    }
    public  void func(TreeNode pRootOfTree){
        if(pRootOfTree==null){
            return;
        }
        TreeNode cur = pRootOfTree;
        if(cur.left!=null){
            func(cur.left);
        }

        cur.left = last;
        if(last!=null){
            last.right = cur;
        }
        last = cur;

        if(cur.right!=null){
            func(cur.right);
        }
        //  return last;
    }
}
