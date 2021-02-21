package linkedlist.assignment1;

public class RemoveNthNodeFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode temp = head, ref = head;
		for (int i = 1; i <= n + 1; i++) {
			if (temp == null) {
				if (i == n + 1) {
					head = head.next;
					return head;
				}
			}
			temp = temp.next;
		}
		while (temp != null) {
			temp = temp.next;
			ref = ref.next;
		}
		ref.next = ref.next.next;
		return head;
	}
}
