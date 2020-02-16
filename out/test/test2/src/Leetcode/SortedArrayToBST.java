package Leetcode;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        return sortedArrayToBSTCore(num, 0, num.length - 1);
    }

    public TreeNode sortedArrayToBSTCore(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        mid = ((end - start) % 2 == 0) ? mid : mid + 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBSTCore(num, start, mid - 1);
        root.right = sortedArrayToBSTCore(num, mid + 1, end);
        return root;
    }
}
