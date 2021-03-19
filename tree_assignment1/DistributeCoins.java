package tree.assignment1;

public class DistributeCoins {
	class Return {
		int swap;
		int coin;
	}

	public int distributeCoins(TreeNode root) {
		return distributeCoinsUtil(root).swap;
	}

	public Return distributeCoinsUtil(TreeNode root) {
		Return res = new Return();
		if (root == null) {
			return res;
		}
		Return leftRes = distributeCoinsUtil(root.left);
		Return rightRes = distributeCoinsUtil(root.right);

		res.coin = leftRes.coin + root.val + rightRes.coin - 1;
		res.swap = leftRes.swap + rightRes.swap + Math.abs(res.coin);

		return res;
	}
}
