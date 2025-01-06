package Day08.SinglyLinkedList;

public class singlyLinkedList {
    private ListNode head;

    public static class ListNode{
        public int data;
        public ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void display(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");
    }

    public int length(ListNode head){
        if(head == null){
            return 0;
        }
        int length = 0;
        ListNode current = head;
        while(current != null){
            length++;
            current = current.next;
        }
        return length;
    }

    public void insertFirst(int value){
        ListNode node = new ListNode(value);
        node.next = head;
        head = node;
    }

    public void insertLast(int value){
        ListNode node = new ListNode(value);
        ListNode current = head;
        if(head == null){
            head = node;
            return;
        }
        while(current.next != null){
            current = current.next;
        }
        current.next = node;
    }

    public void insert(int value, int pos){
        ListNode node = new ListNode(value);
        ListNode previous = head;
        int count = 1;
        if(pos == 1){
            node.next = head;
            head = node;
            return;
        }
        while(previous.next != null && count < pos-1){
            previous = previous.next;
            count++;
        }
        ListNode current = previous.next;
        previous.next = node;
        node.next = current;
    }

    public ListNode deleteFirst(){
        if(head == null){
            return null;
        }
        ListNode current = head;
        head = head.next;
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
        ListNode del = current.next;
        current.next = null;
        return del;
    }

    public void delete(int pos){
        ListNode previous = head;
        int count = 1;
        if(pos == 1){
            head = head.next;
        }
        while(previous.next != null && count < pos-1){
            previous = previous.next;
            count++;
        }
        ListNode current = previous.next;
        previous.next = current.next;
    }

    public boolean find(ListNode head, int val){
        ListNode current = head;
        while (current != null) {
            if (current.data == val){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public void display(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        singlyLinkedList sll = new singlyLinkedList();
        sll.insertFirst(11);
        sll.insertFirst(8);
        sll.insertFirst(1);
        sll.insertFirst(10);
        sll.display();

        System.out.println("Linked list after insertion : ");
        sll.insert(16,3);

        sll.display();

        // System.out.println("Deleted node: " + sll.deleteFirst().data);
        // System.out.println("Deleted node: " + sll.deleteLast().data);

        // sll.delete(2);
        // sll.display();

        if(sll.find(sll.head,8)){
            System.out.println("Search Key found");
        }else{
            System.out.println("Search key not found");
        }

        ListNode reverseListHead = sll.reverse(sll.head);
        sll.display(reverseListHead);

    }
}
