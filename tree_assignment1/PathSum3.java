package tree.assignment1;

public class PathSum3 {
	public int pathSum(TreeNode root, int sum) {
		return pathSumUtil(root, sum);
	}

	public int pathSumUtil(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		// if(root.val == sum)
		// return 1;
		int leftCount1 = pathSumUtil(root.left, sum);
		int leftCount2 = pathSumFromRootUtil(root.left, sum - root.val);
		int rightCount1 = pathSumUtil(root.right, sum);
		int rightCount2 = pathSumFromRootUtil(root.right, sum - root.val);
		int res = leftCount1 + leftCount2 + rightCount1 + rightCount2;
		if (root.val == sum)
			return res + 1;
		return res;
	}

	public int pathSumFromRootUtil(TreeNode root, int sum) {
		if (root == null)
			return 0;

		int lc = pathSumFromRootUtil(root.left, sum - root.val);
		int rc = pathSumFromRootUtil(root.right, sum - root.val);
		int res = lc + rc;
		if (root.val == sum)
			return res + 1;
		else
			return res;
	}
}
