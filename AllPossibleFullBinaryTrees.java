// 894. All Possible Full Binary Trees

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
import java.util.*;

class Solution {
    private List<TreeNode>[] memo;
    public List<TreeNode> allPossibleFBT(int n) {
        memo = new List[n + 1];
        return dfs(n);
    }

    private List<TreeNode> dfs(int n) {
        if (memo[n] != null) {
            return memo[n];
        }
      
        if (n == 1) {
            return List.of(new TreeNode());
        }
      
        List<TreeNode> result = new ArrayList<>();
     
        for (int leftNodes = 1; leftNodes < n - 1; leftNodes += 2) {
            int rightNodes = n - 1 - leftNodes;
          
            List<TreeNode> leftSubtrees = dfs(leftNodes);
          
            List<TreeNode> rightSubtrees = dfs(rightNodes);
          
            for (TreeNode leftTree : leftSubtrees) {
                for (TreeNode rightTree : rightSubtrees) {
                    TreeNode root = new TreeNode(0, leftTree, rightTree);
                    result.add(root);
                }
            }
        }
      
        memo[n] = result;
        return result;
    }
}