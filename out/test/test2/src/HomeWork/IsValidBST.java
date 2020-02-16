package HomeWork;

import java.util.ArrayList;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Serialize(root);
        System.out.println(list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    ArrayList<Integer> list = new ArrayList<>();
    public void Serialize(TreeNode root) {
        if (root == null) {
            return;
        }
        Serialize(root.left);
        list.add(root.val);
        Serialize(root.right);
    }
}
