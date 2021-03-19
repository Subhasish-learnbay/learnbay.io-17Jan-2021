package tree.assignment1;

public class MinDepth {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int leftMinDepth = minDepth(root.left);
		int rightMinDepth = minDepth(root.right);
		if (leftMinDepth == 0 || rightMinDepth == 0) {
			return leftMinDepth == 0 ? rightMinDepth + 1 : leftMinDepth + 1;
		}
		return Math.min(leftMinDepth, rightMinDepth) + 1;
	}
}
