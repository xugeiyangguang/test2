package ExperienceOfferTest;

public class SerializeBinaryTrees {
    public static void main(String[] args) {
        SerializeBinaryTrees test = new SerializeBinaryTrees();
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
        String re = test.Serialize(a1);
        System.out.println(re);
        TreeNode e = test.Deserialize("8,6,10,#,#,#,#");
        System.out.println(e.val);
        System.out.println();

    }
    String preOrder = "";

    String Serialize(TreeNode root) {
        if (root==null){
            preOrder+="#,";
            return new String();
        }
        preOrder+=root.val+",";
        Serialize(root.left);
        Serialize(root.right);
        return preOrder.substring(0,preOrder.length()-1);
    }

   int index = -1;

    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if(index >= len){
            return null;
        }
        String[] strr = str.split(",");
        TreeNode node = null;
        if(!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }

        return node;
    }





}
