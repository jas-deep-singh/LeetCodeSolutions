class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = null, leftTail = null, rightHead = null, rightTail = null;
        while (head!=null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val<x) {
                if (leftHead==null) {
                    leftHead = leftTail = head;
                } else {
                    leftTail.next = head;
                    leftTail = leftTail.next;
                }
            } else {
                if (rightHead==null) {
                    rightHead = rightTail = head;
                } else {
                    rightTail.next = head;
                    rightTail = rightTail.next;
                }
            }
            head = next;
        }
        if (leftHead==null) {
            return rightHead;
        }
        leftTail.next = rightHead;
        return leftHead;
    }
}