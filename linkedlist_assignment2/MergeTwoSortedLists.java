package linkedlist.assignment2;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode head = null;
		ListNode l3 = null;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				if (head == null) {
					l3 = new ListNode(l1.val);
					head = l3;
				} else {
					l3.next = new ListNode(l1.val);
					l3 = l3.next;
				}
				l1 = l1.next;
			} else {
				if (head == null) {
					l3 = new ListNode(l2.val);
					head = l3;
				} else {
					l3.next = new ListNode(l2.val);
					l3 = l3.next;
				}
				l2 = l2.next;
			}
		}
		if (l1 == null) {
			l3.next = l2;
		}
		if (l2 == null) {
			l3.next = l1;
		}
		return head;
	}
}
