package tree.assignment1;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null)
			return false;
		if (root.val == targetSum && root.left == null && root.right == null)
			return true;
		boolean hasLeftPathSum = hasPathSum(root.left, targetSum - root.val);
		if (hasLeftPathSum)
			return true;
		boolean hasRightPathSum = hasPathSum(root.right, targetSum - root.val);
		return hasRightPathSum;
	}
}
