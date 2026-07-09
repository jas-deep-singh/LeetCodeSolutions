class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for(int i=0;i<k-1;i++) {
            fast = fast.next;
        }
        ListNode temp = fast;
        while(fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        int val = temp.val;
        temp.val = slow.val;
        slow.val = val;
        return head;
    }
}