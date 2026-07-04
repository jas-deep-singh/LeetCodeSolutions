class Solution {
    public Node copyRandomList(Node head1) {
        Node head2 = new Node(-1);
        Node temp1 = head1;
        Node temp2 = head2;
        while(temp1!=null) {
            Node t = new Node(temp1.val);
            temp2.next = t;
            temp2 = t;
            temp1 = temp1.next;
        }
        head2 = head2.next;
        Node t = new Node(-1);
        temp1 = head1;
        temp2 = head2;
        while(temp1!=null && temp2!=null) {
            t.next = temp1;
            temp1 = temp1.next;
            t = t.next;
            t.next = temp2;
            temp2 = temp2.next;
            t = t.next;
        }
        temp1 = head1;
        temp2 = head2;
        while(temp1!=null && temp2!=null) {
            if(temp1.random==null) {
                temp2.random = null;
            }
            else {
                temp2.random = temp1.random.next;
            }
            temp1 = temp2.next;
            if(temp1!=null) {
                temp2 = temp1.next;
            }
        }
        temp1 = head1;
        temp2 = head2;
        while(temp1!=null) {
            temp1.next = temp2.next;
            temp1 = temp1.next;
            if(temp1==null) {
                break;
            }
            temp2.next = temp1.next;
            if(temp2.next==null) {
                break;
            }
            temp2 = temp2.next;
        }
        return head2;
    }
}