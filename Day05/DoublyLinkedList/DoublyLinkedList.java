package Day05.DoublyLinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;

    public static class ListNode{
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data){
            this.data = data;
        }
    }
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    public boolean isEmpty(){
        return length == 0;
    }

    public int length(){
        return length;
    }

    public void displayForward(){
        if(head == null){
            return;
        }
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void displayBackwards(){
        if(tail == null){
            return;
        }
        ListNode current = tail;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.previous;
        }
        System.out.println("null");
    }

    public void insertFirst(int val){
        ListNode node = new ListNode(val);
        if(isEmpty()){
            tail = node;
        }else{
            head.previous = node;
        }
        node.next = head;
        head = node;
        length++;
    }

    public void insertLast(int val){
        ListNode node = new ListNode(val);
        if(head == null){
            head = node;
        }else{
            tail.next = node;
        }
        node.previous = tail;
        tail = node;
        length++;
    }

    public ListNode deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode current = head;
        if(head == tail){
            tail = null;
        }else{
            head.next.previous = null;
        }
        head = current.next;
        current.next = null;
        length--;
        return current;
    }

    public ListNode deleteLast(){
        ListNode current = tail;
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(head == tail){
            head = null;
        }else{
            tail.previous.next = null;
        }
        tail = tail.previous;
        current.previous = null;
        length--;
        return current; 
    }

    public ListNode delete(int position){
        if(position <= 0 || position > length){
            throw new IndexOutOfBoundsException("Invalid Position.");
        }
        if(position == 1){
            return deleteFirst();
        }
        if(position == length){
            return deleteLast();
        }
        ListNode current = head;
        int count = 1;
        while(count < position){
            current = current.next;
            count++;
        }
        current.previous.next = current.next;
        current.next.previous = current.previous;
        current.previous = null;
        current.next = null;
        length--;
        return current;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll1 = new DoublyLinkedList();
        dll1.insertFirst(1);
        dll1.insertFirst(2);
        dll1.insertFirst(3);
        System.out.println("Display forward");
        dll1.displayForward();
        System.out.println("Display Backwards");
        dll1.displayBackwards();

        dll1.deleteFirst();
        System.out.println("Linked list after Deletion of first element :- ");
        dll1.displayForward();

        System.out.println();

        DoublyLinkedList dll2 = new DoublyLinkedList();
        dll2.insertLast(11);
        dll2.insertLast(22);
        dll2.insertLast(33);
        dll2.insertLast(44);
        dll2.insertLast(55);

        System.out.println("Display forward");
        dll2.displayForward();
        System.out.println("Display Backwards");
        dll2.displayBackwards();

        dll2.deleteLast();
        System.out.println("Linked list after Deletion of last element :- ");
        dll2.displayForward();
        System.out.println("Linked list after Deletion :- ");
        dll2.delete(3);
        dll2.displayForward();
    }
}

