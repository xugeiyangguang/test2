package Companies.Else;

public class Serialize {
    public static void main(String[] args) {
        Serialize test = new Serialize();

        TreeNode a = test.Deserialize("1,2,4,$,$,$,3,5,$,$,6,$,$");
        String re = test.Serialize(a);
        System.out.println();

    }
    StringBuffer s = new StringBuffer();
    String Serialize(TreeNode root) {
        if(root==null){
            s.append("$");
            s.append(",");
            return "";
        }
        s.append(root.val);
        s.append(",");
        Serialize(root.left);
        Serialize(root.right);
        //s.deleteCharAt(s.length()-1);
        return s.toString().substring(0,s.length()-1);
    }
    int index = 0;
    TreeNode Deserialize(String str) {
        String[] strs  = str.split(",");
        if (index > strs.length) {
            return null;
        }
        if(!strs[index].equals("$")){
            TreeNode a = new TreeNode(Integer.valueOf(strs[index]));
            index++;
            a.left = Deserialize(str);
            a.right = Deserialize(str);
            return(a);
        }else{
            index++;
            return null;
        }

    }
}
