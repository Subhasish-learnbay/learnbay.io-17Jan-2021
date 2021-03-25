package bst.assignment1;

public class SearchInBST {
	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null)
			return null;
		if (root.val == val)
			return root;
		TreeNode leftNode = searchBST(root.left, val);
		if (leftNode != null)
			return leftNode;
		TreeNode rightNode = searchBST(root.right, val);
		return rightNode;
	}
}
