package tree.assignment1;

public class SubTreeOfAnotherTree {
	boolean res = false;

	public boolean isSubtree(TreeNode s, TreeNode t) {
		inOrder(s, t);
		return res;
	}

	void inOrder(TreeNode s, TreeNode t) {
		if (s == null)
			return;
		inOrder(s.left, t);
		if (s.val == t.val) {
			boolean flag = isIdentical(s, t);
			if (flag)
				res = true;

		}
		inOrder(s.right, t);
	}

	boolean isIdentical(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		boolean isLeftIdentical = isIdentical(root1.left, root2.left);
		if (!isLeftIdentical)
			return false;
		boolean isRightIdentical = isIdentical(root1.right, root2.right);
		if (!isRightIdentical)
			return false;
		if (root1.val == root2.val)
			return true;
		else
			return false;
	}
}
