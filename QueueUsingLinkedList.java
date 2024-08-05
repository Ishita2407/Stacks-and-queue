public class QueueUsingLinkedList{
    // IMPLEMENTATION OF QUEUE USING LINKED LIST
    // Optimized implementation
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = next;
        }
    }
    static class Queue{
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty(){
            return head == null && tail == null;
        }

        // ADD - O(1) constant time - change only at 1 node
        public static void add(int data){
            Node newNode = new Node(data);
            // If Linked list is initially empty 
            // Create new node and head & tail will point to the same node
            if(head == null){
                head = tail = newNode;
                return;
            }
            // Adding new node at the rear i.e at tail
            tail.next = newNode;
            tail = newNode;
        }

        // Remove - O(1)
        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            int front = head.data;
            //Single element is present in Queue
            if(tail == head){
                tail = head = null;
            } else{
                head = head.next;
            }
            return front;
        }

        // Peek - O(1)
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String args[]){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }
}