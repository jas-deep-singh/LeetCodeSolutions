class Solution {
    public int[] findCountSum(TreeNode root) {
        if(root==null) {
            return new int[]{0, 0, 0};
        }
        int []left = findCountSum(root.left);
        int []right = findCountSum(root.right);
        int count = 1+left[0]+right[0];
        int sum = root.val+left[1]+right[1];
        int ans = left[2]+right[2];
        if(sum/count==root.val) {
            ans+=1;
        }
        return new int[]{count, sum, ans};
    }
    public int averageOfSubtree(TreeNode root) {
        return findCountSum(root)[2];
    }
}