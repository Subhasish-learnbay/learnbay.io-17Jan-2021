package bst.assignment1;

public class ValidateBST {
	boolean isFirst = true;
	boolean isBST = true;
	boolean resFound = false;
	int num;

	public boolean isValidBST(TreeNode root) {
		inOrder(root);
		return isBST;
	}

	void inOrder(TreeNode root) {
		if (resFound)
			return;
		if (root == null)
			return;
		inOrder(root.left);
		if (isFirst) {
			num = root.val;
			isFirst = false;
		} else {
			if (root.val <= num) {
				isBST = false;
				resFound = true;
			} else {
				num = root.val;
			}
		}
		inOrder(root.right);
	}
}
