package linkedlist.assignment2;

public class RotateLinkedList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;
		int n = 0;
		ListNode t = head;
		while (t != null) {
			n++;
			t = t.next;
		}
		k = k % n;
		if (k == 0 || k == n)
			return head;
		int count = k + 1;
		ListNode ref = head, temp = head;
		while (count-- > 0) {
			ref = ref.next;
		}
		while (ref != null) {
			temp = temp.next;
			ref = ref.next;
		}
		ListNode res = temp.next;
		temp.next = null;
		temp = res;
		while (temp.next != null)
			temp = temp.next;
		temp.next = head;
		return res;

	}
}
