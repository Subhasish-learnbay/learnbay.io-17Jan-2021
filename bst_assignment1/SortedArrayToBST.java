package bst.assignment1;

public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	public TreeNode sortedArrayToBST(int[] nums, int low, int high) {
		if (low > high)
			return null;
		int mid = (low + high) / 2;
		TreeNode leftTree = sortedArrayToBST(nums, low, mid - 1);
		TreeNode rightTree = sortedArrayToBST(nums, mid + 1, high);
		TreeNode root = new TreeNode(nums[mid]);
		root.left = leftTree;
		root.right = rightTree;
		return root;
	}
}
