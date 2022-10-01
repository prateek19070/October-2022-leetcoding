// Binary Tree Inorder Traversal

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        findTraversal(root,values);
        return values;
    }
    public void findTraversal(TreeNode root, List list){
        if(root == null){
            return;
        }
        if(root.left != null){
            findTraversal(root.left, list);
        }
        list.add(root.val);
        if(root.right != null){
            findTraversal(root.right, list);
        }
    }
}
