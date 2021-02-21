package linkedlist.assignment1;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		if (head.next == null && head.val == val)
			return null;
		ListNode temp = head;
		while (temp != null && temp.next != null) {
			if (temp.val == val) {
				head = head.next;
				temp = temp.next;
				continue;
			}
			while (temp != null && temp.next != null && temp.next.val == val)
				temp.next = temp.next.next;
			temp = temp.next;
		}
		while (temp != null && temp.val == val) {
			head = head.next;
			temp = temp.next;
		}
		return head;
	}
}
