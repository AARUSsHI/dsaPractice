package Day02.SinglyLinkedList;

public class SinglyLinkedList {
    private ListNode head;
    public static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void display(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int length(){
        if(head == null){
            return 0;
        }

        ListNode current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertFirst(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void insert(int position, int data){
        ListNode node = new ListNode(data);
        if(position <= 0){
            throw new IllegalArgumentException("Invalid Input");
        }
        if(position == 1){
            node.next = head;
            head = node;
        }else{
            int count  = 1;
            ListNode current = head;
            while(count < position-1){
                current = current.next;
                count++;
            }
            node.next = current.next;
            current.next = node;
        }
    }

    public ListNode deleteFirst(){
        if(head == null){
            return null;
        }
        ListNode current = head;
        head = current.next;
        current.next = null;
        
        return current;
    }    

    public ListNode deleteLast(){
        if(head == null){
            return null;
        }
        ListNode current = head;
        while(current.next.next != null){
            current = current.next;
        }
        ListNode temp = current.next;
        current.next = null;
        return temp;
    }

    public ListNode delete(int pos){
        if(head == null){
            return null;
        }
        int count = 1;
        ListNode current = head;
        while(count < pos-1){
            current = current.next;
            count++;
        }
        ListNode temp = current.next;
        current.next = temp.next;
        return temp;
    }

    public boolean find(ListNode head, int key){
        if(head == null){
            return false;
        }
        ListNode current = head;
        while(current != null){
            if(current.data == key){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public void display(ListNode head){
        ListNode current = head;
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public ListNode getNthNodeFromEnd(int n){
        ListNode current = head;
        ListNode nextptr = head;
        int count = 0;
        while(count < n){
            if(nextptr == null){
                throw new IllegalArgumentException();
            }
            nextptr = nextptr.next;
            count++;
        }
        while(nextptr != null){
            nextptr = nextptr.next;
            current = current.next;
        }
        return current;
    }

    public ListNode getNodeFromStart(int n){
        if(head == null){
            return null;
        }
        int count = 1;
        ListNode current = head;
        while(count < n && current != null){
            current = current.next;
            count++;
        }
        return current;
    }

    public ListNode getMiddleNode(){
        ListNode ptr = head;
        ListNode nextPtr = head;
        while(nextPtr != null && nextPtr.next != null){
            ptr = ptr.next;
            nextPtr = nextPtr.next.next;
        }
        return ptr;
    }

    public void removeDuplicates(){
        if(head == null){
            return;
        }
        ListNode current = head;
        while(current != null && current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
    }

    public ListNode insertInSortedList(int val){
        ListNode node = new ListNode(val);

        if(head == null){
            head = node;
            return head;
        }

        if(node.data < head.data){
            node.next = head;
            head = node;
            return head;
        }

        ListNode current = head;
        ListNode temp = null;
        while(current != null && current.data < node.data){
            temp = current;
            current = current.next;
        }
        node.next = current;
        temp.next = node;
        return head;
    }

    public void deleteNode(int val){
        ListNode current = head;
        ListNode temp = null;

        if(current != null && current.data == val){
            head = current.next;
            return;
        }
        while(current != null && current.data != val){
            temp = current;
            current = current.next;
        }
        if(current == null){
            return;
        }
        temp.next = current.next;   
    }

    public boolean containsLoop(){
        ListNode ptrslow = head;
        ListNode ptrFast = head;

        while(ptrFast != null && ptrFast.next != null){
            ptrFast = ptrFast.next.next;
            ptrslow = ptrslow.next;
            if(ptrslow == ptrFast){
                return true;
            }
        }
        return false;
    }
    public void createLoop(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;
    }

    public ListNode getNode(ListNode ptrslow){
        ListNode temp = head;
        while(temp != ptrslow){
            temp = temp.next;
            ptrslow = ptrslow.next;
        }
        return temp;
    }
    public ListNode startingNodeInALoop(){
        ListNode ptrslow = head;
        ListNode ptrFast = head;

        while(ptrFast != null && ptrFast.next != null){
            ptrFast = ptrFast.next.next;
            ptrslow = ptrslow.next;
            if(ptrslow == ptrFast){
                return getNode(ptrslow);
            }
        }
        return null;
    }

    public void removeLoop(){
        ListNode ptrslow = head;
        ListNode ptrFast = head;

        while(ptrFast != null && ptrFast.next != null){
            ptrFast = ptrFast.next.next;
            ptrslow = ptrslow.next;
            if(ptrslow == ptrFast){
                removeLoop(ptrslow);
                return;
            }
        }
    }
    public void removeLoop(ListNode ptrslow){
        ListNode temp = head;
        while(temp.next != ptrslow.next){
            temp = temp.next;
            ptrslow = ptrslow.next;
        }
        ptrslow.next = null;
    }

    public static ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(a != null && b != null){
            if(a.data < b.data){
                tail.next = a;
                a = a.next;
            }else{
                tail.next = b;
                b = b.next;
            }
        }
        if(a == null){
            tail.next = b;
        }else{
            tail.next = a;
        }
        return dummy.next;
    }

    public static ListNode add(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while(a != null || b != null){
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;
            int sum = x + y + carry;
            carry = sum/10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if(a != null){
                a = a.next;
            }
            if(b != null){
                b = b.next;
            }           
        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        SinglyLinkedList sll1 = new SinglyLinkedList();
        sll1.insertLast(7);
        sll1.insertLast(4);
        sll1.insertLast(9);
        System.out.println("Linked List 1 :");
        sll1.display();

        SinglyLinkedList sll2 = new SinglyLinkedList();
        // sll2.insertLast(3);
        sll2.insertLast(5);
        sll2.insertLast(6);
        // sll2.insertLast(9);
        // sll2.insertLast(14);
        // sll2.insertLast(18);
        System.out.println("Linked List 2 :");
        sll2.display();

        SinglyLinkedList result = new SinglyLinkedList();
        // result.head = merge(sll1.head,sll2.head);
        result.head = add(sll1.head, sll2.head);

        System.out.println("Merged List :");
        result.display();

        // sll.insertLast(1);
        // sll.insertLast(2);
        // sll.insertLast(3);
        // sll.insertLast(5);
        // sll.insert(2,4);

        // sll.display();
        // System.out.println("lenght is:- " + sll.length());
        // System.out.println("deleted node is: " + sll.delete(3).data);
        // System.out.println("node for earch key: " + sll.find(sll.head, 11));
        // ListNode rev =  sll.reverse(sll.head);
        // sll.display(rev);
        // System.out.println("node from last is: " + sll.getNthNodeFromEnd(2).data);
        // System.out.println("node from first is: " + sll.getNodeFromStart(5).data);
        // System.out.println("node from the middle is: " + sll.getMiddleNode().data);
        // sll.removeDuplicates();
        // sll.insertInSortedList(4);
        // sll.deleteNode(1);
        // sll.createLoop();
        // System.out.println(sll.containsLoop());
        // System.out.println("Starting node of loop :- " + sll.startingNodeInALoop().data);
        // sll.removeLoop();
        // System.out.println(sll.containsLoop());
        // sll.display();
    }
}
