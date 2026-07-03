class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode evenHead = null, evenTail = null, oddHead = null, oddTail = null;
        ListNode temp = head;
        int cnt = 1;
        while(temp!=null) {
            if(cnt%2!=0) {
                if(oddHead==null) {
                    oddHead = temp;
                    oddTail = temp;
                }
                else {
                    oddTail.next = temp;
                    oddTail = temp;
                }
            }
            else {
                if(evenHead==null) {
                    evenHead = temp;
                    evenTail = temp;
                }
                else {
                    evenTail.next = temp;
                    evenTail = temp;
                }
            }
            temp = temp.next;
            cnt++;
        }
        if(evenHead==null) {
            return oddHead;
        }
        if(oddHead==null) {
            return evenHead;
        }
        oddTail.next = evenHead;
        evenTail.next = null;
        return oddHead;
    }
}