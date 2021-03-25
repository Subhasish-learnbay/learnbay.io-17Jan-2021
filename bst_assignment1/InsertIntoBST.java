package bst.assignment1;

public class InsertIntoBST {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		TreeNode current = root;
		while (true) {
			if (current.left == null && val < current.val) {
				current.left = new TreeNode(val);
				break;
			}
			if (current.right == null && val > current.val) {
				current.right = new TreeNode(val);
				break;
			}
			if (val < current.val)
				current = current.left;
			else
				current = current.right;
		}
		return root;
	}
}
