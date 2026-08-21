class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        second = reverseList(second);
        ListNode newHead = head;
        while (second!=null) {
            ListNode temp1 = newHead.next;
            ListNode temp2 = second.next;
            newHead.next = second;
            second.next = temp1;
            newHead = temp1;
            second = temp2;
        }
    }
}