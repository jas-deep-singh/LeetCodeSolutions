class Solution {
    public void findRightView(TreeNode root, int depth, List<Integer> result) {
        if(root==null) {
            return;
        }
        if(depth==result.size()) {
            result.add(root.val);
        }
        findRightView(root.right, depth+1, result);
        findRightView(root.left, depth+1, result);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) {
            return result;
        }
        findRightView(root, 0, result);
        return result;
    }
}