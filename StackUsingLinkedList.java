import java.util.*;
public class StackUsingLinkedList{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public class Stack{
        static Node head = null;

        public static boolean isEmpty(){
            // Returns true if LL is initially empty else false
            return head == null;
        }
        // push
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                // If stack is initially empty we'll simply add a node
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // pop
        public static int pop(){
            // If stack is empty initially return -1
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }

    }
    public static void main(String args[]){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}