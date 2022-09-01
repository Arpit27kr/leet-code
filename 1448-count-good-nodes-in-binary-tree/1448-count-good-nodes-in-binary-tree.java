/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public int goodNodes(TreeNode root) {
    return goodNodesRecursive(root, Integer.MIN_VALUE);
  }
  
  private int goodNodesRecursive(TreeNode root, int maxEl) {
    if (root == null) {
      return 0;
    }

    var newMax = Math.max(maxEl, root.val);

    return (maxEl <= root.val ? 1 : 0)
        + goodNodesRecursive(root.left, newMax)
        + goodNodesRecursive(root.right, newMax);
  }  
}
