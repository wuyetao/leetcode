package leetcode.editor.cn;

/**
 * @path: leetcode.editor.cn.TreeNode
 * @author: yetaowu
 * @date: 2025/08/31 14:06
 * @description:
 * @version: v1.0
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
