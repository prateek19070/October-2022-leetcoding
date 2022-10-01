// Count Good Nodes in Binary Tree

class Solution {
    int good;
    public int goodNodes(TreeNode root) {
        good = 0;
        preOrder(root, Integer.MIN_VALUE);
        return good;
    }
    
    public void preOrder(TreeNode root, int max){
        if(root == null){
            return;
        }
        if(root.val >= max){
            good++;
        }
        
        max = Math.max(max, root.val);
        preOrder(root.left, max);
        preOrder(root.right, max);
    }
}
