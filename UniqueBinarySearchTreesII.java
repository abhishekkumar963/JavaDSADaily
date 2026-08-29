// 95. Unique Binary Search Trees II

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

    public List<TreeNode> generateTrees(int n) {
        return generateSubtrees(1, n);
    }

    private List<TreeNode> generateSubtrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
      
        if (start > end) {
            result.add(null);
            return result;
        }
      
        for (int rootValue = start; rootValue <= end; rootValue++) {
            List<TreeNode> leftSubtrees = generateSubtrees(start, rootValue - 1);
          
            List<TreeNode> rightSubtrees = generateSubtrees(rootValue + 1, end);
          
            for (TreeNode leftSubtree : leftSubtrees) {
                for (TreeNode rightSubtree : rightSubtrees) {
                    TreeNode root = new TreeNode(rootValue, leftSubtree, rightSubtree);
                    result.add(root);
                }
            }
        }
      
        return result;
    }
}