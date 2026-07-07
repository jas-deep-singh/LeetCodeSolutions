class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) {
            return head;
        }
        int n = 1;
        ListNode tail = head;
        while(tail.next!=null) {
            n+=1;
            tail = tail.next;
        }
        k = k%n;
        if(k==0) {
            return head;
        }
        ListNode newTail = head;
        for(int i=1;i<n-k;i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        return newHead;
    }
}