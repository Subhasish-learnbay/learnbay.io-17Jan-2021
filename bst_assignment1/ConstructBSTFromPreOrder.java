package bst.assignment1;

public class ConstructBSTFromPreOrder {
	public TreeNode bstFromPreorder(int[] preorder) {
		return bstFromPreorder(preorder, 0, preorder.length - 1);
	}

	public TreeNode bstFromPreorder(int[] preorder, int low, int high) {
		if (low > high) {
			return null;
		}
		if (low == high) {
			return new TreeNode(preorder[low]);
		}
		TreeNode root = new TreeNode(preorder[low]);
		int rightIndex = findRightIndex(preorder, low);
		if (rightIndex == -1) {
			root.left = bstFromPreorder(preorder, low + 1, high);
			return root;
		}
		root.left = bstFromPreorder(preorder, low + 1, rightIndex - 1);
		root.right = bstFromPreorder(preorder, rightIndex, high);
		return root;
	}

	int findRightIndex(int[] preorder, int i) {
		for (int k = i + 1; k < preorder.length; k++) {
			if (preorder[k] > preorder[i])
				return k;
		}
		return -1;
	}
}
