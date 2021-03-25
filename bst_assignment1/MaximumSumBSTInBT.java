package bst.assignment1;

public class MaximumSumBSTInBT {
	int ans = 0;

	class Result {
		boolean isBST;
		int sum;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
	}

	public int maxSumBST(TreeNode root) {
		maxSumBSTUtil(root);
		return ans;
	}

	public Result maxSumBSTUtil(TreeNode root) {
		Result res = new Result();
		if (root == null) {
			res.isBST = true;
			return res;
		}
		Result leftRes = maxSumBSTUtil(root.left);
		Result rightRes = maxSumBSTUtil(root.right);
		if (leftRes.isBST)
			ans = Math.max(ans, leftRes.sum);
		if (rightRes.isBST)
			ans = Math.max(ans, rightRes.sum);
		if (leftRes.isBST && rightRes.isBST && leftRes.max < root.val && rightRes.min > root.val) {
			ans = Math.max(ans, leftRes.sum + rightRes.sum + root.val);
			res.sum = leftRes.sum + rightRes.sum + root.val;
			res.min = Math.min(leftRes.min, root.val);
			res.max = Math.max(rightRes.max, root.val);
			res.isBST = true;
			return res;
		} else {
			res.isBST = false;
			return res;
		}
	}
}
