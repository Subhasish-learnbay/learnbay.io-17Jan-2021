package linkedlist.assignment2;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null, current = head, next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
}
