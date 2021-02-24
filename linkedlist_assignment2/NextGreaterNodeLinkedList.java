package linkedlist.assignment2;

public class NextGreaterNodeLinkedList {
	public int[] nextLargerNodes(ListNode head) {
		if (head == null)
			return new int[] {};
		ListNode temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		temp = head;
		int[] res = new int[count];
		int index = 0;
		while (temp != null) {
			ListNode ref = temp.next;
			while (ref != null) {
				if (ref.val > temp.val) {
					res[index++] = ref.val;
					break;
				}
				ref = ref.next;
			}
			if (ref == null)
				res[index++] = 0;
			temp = temp.next;
		}
		return res;
	}
}
