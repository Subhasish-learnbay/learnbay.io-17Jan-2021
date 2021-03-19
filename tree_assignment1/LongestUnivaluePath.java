package tree.assignment1;

public class LongestUnivaluePath {
	int ans = 0;

	public int longestUnivaluePath(TreeNode root) {
		dfs(root);
		return ans;
	}

	int dfs(TreeNode root) {
		if (root == null)
			return 0;
		int leftDepth = dfs(root.left);
		int rightDepth = dfs(root.right);
		int left = 0, right = 0;
		if (root.left != null && root.val == root.left.val)
			left = leftDepth + 1;
		if (root.right != null && root.val == root.right.val)
			right = rightDepth + 1;
		ans = Math.max(left + right, ans);
		return Math.max(left, right);
	}
}
