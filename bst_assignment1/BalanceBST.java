package bst.assignment1;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {
	public TreeNode balanceBST(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		inOrder(root, list);
		return sortedArrayToBST(list, 0, list.size() - 1);
	}

	void inOrder(TreeNode root, List<TreeNode> list) {
		if (root == null)
			return;
		inOrder(root.left, list);
		list.add(root);
		inOrder(root.right, list);
	}

	public TreeNode sortedArrayToBST(List<TreeNode> nums, int low, int high) {
		if (low > high)
			return null;
		int mid = (low + high) / 2;
		TreeNode leftTree = sortedArrayToBST(nums, low, mid - 1);
		TreeNode rightTree = sortedArrayToBST(nums, mid + 1, high);
		TreeNode root = new TreeNode(nums.get(mid).val);
		root.left = leftTree;
		root.right = rightTree;
		return root;
	}
}
