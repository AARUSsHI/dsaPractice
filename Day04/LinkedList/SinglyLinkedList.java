package Day04.LinkedList;

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
        ListNode current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertFirst(int val){
        ListNode newNode = new ListNode(val);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int val){
        ListNode newNode = new ListNode(val);
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

    public void insertAtPos(int val, int pos){
        ListNode newNode = new ListNode(val);
        int count = 1;
        ListNode current = head;
        while(current != null && count < pos-1){
            current = current.next;
            count++;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
    
    public ListNode deleteFirst(){
        ListNode current = head;
        if(head == null || head.next == null){
            return head;
        }
        head = head.next;
        return current;
    }

    public ListNode deleteLast(){
        ListNode current = head;
        ListNode temp = null;
        if(head == null || head.next == null){
            return head;
        }
        while(current.next != null){
            temp = current;
            current = current.next;
        }
        temp.next = null;
        return current;
    }

    public void deleteAtPos(int pos){
        ListNode current = head;
        int count = 1;
        while(current != null && count < pos -1){
            current = current.next;
            count++;
        }
        current.next = current.next.next;
    }

    public boolean find(ListNode head, int key){
        ListNode current = head;
        while(current != null){
            if(current.data == key){
                return true;
            }else{
                current = current.next;
            }
        }
        return false;
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

    public ListNode reverse(){
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        {
            while(current != null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
        }
        return prev;
    }

    public ListNode getNodeFromEnd(int n){
        ListNode current = head;
        ListNode nextPtr = head;
        int count = 0;
        while(current != null && count != n){
            current = current.next;
            count++;
        }
        while(current != null){
            current = current.next;
            nextPtr = nextPtr.next;
        }
        return nextPtr;
    }

    public ListNode getNodeFromStart(int n){
        ListNode current = head;
        int count = 1;
        while(current != null && count < n){
            current = current.next;
            count++;
        }
        return current;
    }

    public ListNode middleNode(){
        if(head == null){
            return null;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr;
    }

    public void removeDup(){
        if(head == null){
            return;
        }
        ListNode current = head;
        while(current != null && current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    public ListNode InsertInSortedList(int val){
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
        node.next = current.next;    
        temp.next = node;
        return head;
    }

    public void delete(int key){
        ListNode current = head;
        ListNode temp = null;

        if(current != null && current.data == key){
            head = current.next;
            return;
        }
        while(current != null && current.data != key){
            temp = current;
            current = current.next;
        }
        if(current == null){
            return;
        }
        temp.next = current.next;
    }

    public boolean containLoop(){
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }

    public ListNode getnode(ListNode slowPtr){
        ListNode temp = head;
        while(temp != slowPtr){
            slowPtr = slowPtr.next;
            temp = temp.next;
        }
        return temp;
    }

    public ListNode startNodeInLoop(){
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                return getnode(slowPtr);
            }
        }
        return null;
    }

    public void removenode(ListNode slowPtr){
        ListNode temp = head;
        while(temp.next != slowPtr.next){
            slowPtr = slowPtr.next;
            temp = temp.next;
        }
        slowPtr.next = null;
    }

    public void removeLoop(){
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                removenode(slowPtr);
                return;
            }
        }
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

    public static ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(a != null && b != null){
            if(a.data < b.data){
                tail.next = a;
                a = a.next;
            }
            else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
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
            tail.next = new ListNode(sum%10);
            tail = tail.next;
            if(a != null){
                a = a.next;
            }
            if(b != null){
                b = b.next;
            }
        }
        if(carry != 0){
            tail.next = new ListNode(carry);
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // SinglyLinkedList sll = new SinglyLinkedList();

        // sll.insertLast(1);
        // sll.insertLast(2);
        // sll.insertLast(5);
        // sll.insertLast(11);
        // sll.insertAtPos(4, 3);

        // sll.InsertInSortedList(3);
        // sll.display();
        // sll.delete(11);
        // System.out.println("length of list is:- " + sll.length());
        // sll.display();

        // System.out.println(sll.find(sll.head, 4));

        // ListNode del = sll.deleteFirst();
        // System.out.println(del.data);
        // sll.display();

        // ListNode delLast = sll.deleteLast();
        // System.out.println(delLast.data);
        // sll.display();

        // sll.deleteAtPos(2);
        // sll.display();

        // ListNode rev = sll.reverse();
        // sll.display(rev);

        // System.out.println(sll.getNodeFromEnd(2).data);

        // System.out.println("from start " + sll.getNodeFromStart(2).data);

        // System.out.println("middle node " + sll.middleNode().data);
        
        // sll.removeDup();
        // sll.display();



        // sll.createLoop();
        // System.out.println("Linked list contains loop :- " + sll.containLoop());
        // System.out.println("Starting node of loop :- " + sll.startNodeInLoop().data);
        // sll.removeLoop();
        // System.out.println("Linked list contains loop :- " + sll.containLoop());
        // sll.display();


        SinglyLinkedList sll1 = new SinglyLinkedList();
        sll1.insertLast(7);
        sll1.insertLast(4);
        sll1.insertLast(9);
        System.out.println("List 1 :-");
        sll1.display();

        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.insertLast(5);
        sll2.insertLast(6);
        System.out.println("List 2 :-");
        sll2.display();

        SinglyLinkedList result1 = new SinglyLinkedList();
        result1.head = add(sll1.head, sll2.head);
        System.out.println("List After Addition :- ");
        result1.display();

        SinglyLinkedList result = new SinglyLinkedList();
        result.head = merge(sll1.head,sll2.head);

        System.out.println("Merged List :- ");
        result.display();
    }
}
