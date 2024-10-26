package Day02.DoublyLinkedList;

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

    public void displayForward() {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        if (tail == null) {
            return;
        }
        ListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
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
        if(isEmpty()){
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
        ListNode temp = head;
        if(head == tail){
            tail = null;
        }else{
            head.next.previous = null;
        }
        head = head.next;        
        temp.next = null;
        length--;
        return temp;
    }

    public ListNode deleteLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = tail;
        if(head == tail){
            head = null;
        }else{
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }

    public ListNode deletePos(int pos){
        if(pos == 0 ||pos > length){
            throw new IndexOutOfBoundsException();
        }
        if(pos == 1){
            deleteFirst();
        }
        if(pos == length){
            deleteLast();
        }
        ListNode current = head;
        int count = 1;
        while(current != null && count < pos){
            current = current.next;
            count++;
        }
        current.previous.next = current.next;
        current.next.previous = current.previous;
        current.next = null;
        current.previous = null;
        length--;
        return current;
    }

    public static void main(String[] args) {
        // DoublyLinkedList dll = new DoublyLinkedList();
        // System.out.println("Inserting node at beginning");
        // dll.insertFirst(1);
        // dll.insertFirst(2);
        // dll.insertFirst(3);
        // System.out.println("Printing forward :- ");
        // dll.displayForward();
        // System.out.println("Printing backward :- ");
        // dll.displayBackward();
        // System.out.println("Length :- " + dll.length());

        // System.out.println();

        DoublyLinkedList dll = new DoublyLinkedList();
        System.out.println("Inserting node at end");
        dll.insertLast(11);
        dll.insertLast(22);
        dll.insertLast(33);
        dll.insertLast(44);
        System.out.println("Printing forward :- ");
        dll.displayForward();
        // System.out.println("Printing backward :- ");
        // dll1.displayBackward();
        
        // dll.deleteFirst();
        // System.out.println("Linked list after Deletion of first element :- ");
        // dll.displayForward();

        // dll.deleteLast();
        // System.out.println("Linked list after Deletion of last element :- ");
        // dll.displayForward();

        System.out.println("Linked list after Deletion :- ");
        dll.deletePos(3);
        dll.displayForward();
    }
}
