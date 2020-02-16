package ExperienceOfferTest;

import java.util.ArrayList;

public class GetLastCommonParent {
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(9);
        TreeNode a3 = new TreeNode(6);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(6);
        TreeNode a6 = new TreeNode(7);
        TreeNode a7 = new TreeNode(8);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;
        a3.right = a7;
        a5.left = null;a5.right = null;
        a4.left = null;a4.right = null;
        a6.left = null;a6.right = null;
        a7.left = null;a7.right = null;
        GetLastCommonParent test = new GetLastCommonParent();
        TreeNode re = test.getLastCommenParents(a1,a4,null);
        System.out.println(re.val);
        System.out.println();

    }
    //得到根节点到目标节点的路径
    public boolean getPath(TreeNode pRoot,TreeNode target, ArrayList<TreeNode> str){
        if (pRoot == null){
            return false;
        }
        str.add(pRoot);
        if (str.get(str.size()-1).equals(target) ){
            return true;
        }
        if (getPath(pRoot.left,target,str)==true||getPath(pRoot.right,target,str)==true){
            return true;
        }
        else {
            str.remove(str.get(str.size()-1));
            return false;
        }
    }
    //查找两条路径的最后一个公共节点
    public TreeNode getCommentNode(ArrayList<TreeNode> str1, ArrayList<TreeNode> str2){
        if (str1 == null || str1.size() == 0 || str2 == null || str2.size()== 0){
            return null;
        }
        int i = 0;
        while (i < str1.size() && i < str2.size() && str1.get(i) == str2.get(i)){
            i++;
        }
        return str1.get(i-1);

    }
    public TreeNode getLastCommenParents(TreeNode pRoot,TreeNode node1,TreeNode node2){
        if (pRoot == null || node1 == null || node2 == null){
            return null;
        }
        ArrayList<TreeNode> str1 = new ArrayList<>();
        getPath(pRoot,node1,str1);
        ArrayList<TreeNode> str2 = new ArrayList<>();
        getPath(pRoot,node2,str2);
        return getCommentNode(str1,str2);
    }

}
