package Day02.CircularLinkedList;

import java.util.NoSuchElementException;

public class CircularLinkedList {
    private ListNode last;
    private int length;
    
    public static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }
    public CircularLinkedList(){
        this.last = null;
        this.length = 0;
    }
    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void display(){
        if(last == null){
            return;
        }
        ListNode first = last.next;
        while(first != last){
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.println(first.data);
    }
    
    public void insertFirst(int val){
        ListNode node = new ListNode(val);
        if(last == null){
            last = node;
        }else{
            node.next = last.next;
        }
        last.next = node;
        length++;
    }

    public void insertLast(int val){
        ListNode node = new ListNode(val);
        if(last == null){
            last = node;
            last.next = last;
        }else{
            node.next = last.next;
        }
        last.next = node;
        last = node;
        length++;
    }

    public ListNode removeFirst(){
        ListNode first = last.next;
        if(isEmpty()){
            throw new NoSuchElementException("the list is empty");
        }
        if(last.next == last){
            last = null;
        }else{
            last.next = first.next;
        }
        first.next = null;
        length--;
        return first;
    }

    public static void main(String[] args) {
        CircularLinkedList csll = new CircularLinkedList();
        System.out.println("Inserting nodes at the beginning");
        csll.insertFirst(1);
        csll.insertFirst(2);
        csll.insertFirst(3);
        csll.display();
        System.out.println("Length :- " + csll.length());

        // CircularLinkedList csll1 = new CircularLinkedList();
        // System.out.println("Inserting nodes at the end");
        // csll1.insertLast(11);
        // csll1.insertLast(22);
        // csll1.insertLast(33);
        // csll1.display();
        // System.out.println("Length :- " + csll1.length());
        System.out.println("Linked List after deletion :- ");
        csll.removeFirst();
        csll.display();
    }
}