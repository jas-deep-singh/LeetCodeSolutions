class Solution {
    public TreeNode buildBST(int[] nums, int low, int high) {
        if(low>high) {
            return null;
        }
        int mid = low+(high-low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, low, mid-1);
        root.right = buildBST(nums, mid+1, high);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length-1);
    }
}