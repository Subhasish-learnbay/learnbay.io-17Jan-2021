package linkedlist.assignment2;

public class SwapNodeInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode res = null, resTemp = null, temp = head;
		while (temp != null && temp.next != null) {
			if (res == null) {
				resTemp = new ListNode(temp.next.val);
				res = resTemp;
			} else {
				resTemp.next = new ListNode(temp.next.val);
				resTemp = resTemp.next;
			}
			temp = temp.next.next;
		}
		temp = head;
		resTemp = res;
		while (temp != null && temp.next != null) {
			ListNode node = new ListNode(temp.val);
			node.next = resTemp.next;
			resTemp.next = node;
			if (node.next != null)
				resTemp = node.next;
			else
				resTemp = node;
			temp = temp.next.next;
		}
		resTemp.next = temp;
		return res;
	}
}
