import java.util.*;
public class DequeUsingJCF{
    // Double ended queue
    // Addition & deletion can be done at both the ends
    // Methods of deque - addFirst(), addLast() , removeFirst(), removeLast() , getFirst() , getLast()
    
    public static void main(String args[]){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        System.out.println(deque);
        deque.removeFirst();
        deque.removeLast();
        System.out.println(deque);
        System.out.println("First element: " + deque.getFirst());
        System.out.println("Last element: " + deque.getLast());
        
    }
}