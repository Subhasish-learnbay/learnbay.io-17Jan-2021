package linkedlist.assignment2;

public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return null;
		ListNode evenHead = head, even = head;
		ListNode oddHead = head.next, odd = head.next;
		while (odd != null && odd.next != null) {
			even.next = odd.next;
			even = even.next;
			odd.next = even.next;
			odd = odd.next;
		}
		even.next = oddHead;
		return evenHead;
	}
}
