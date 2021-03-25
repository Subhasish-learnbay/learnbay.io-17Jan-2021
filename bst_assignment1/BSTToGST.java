package bst.assignment1;

public class BSTToGST {
	int sum = 0;

	public TreeNode bstToGst(TreeNode root) {
		postOrder(root);
		return root;
	}

	void postOrder(TreeNode root) {
		if (root == null)
			return;
		postOrder(root.right);
		sum += root.val;
		root.val = sum;
		postOrder(root.left);
	}
}
