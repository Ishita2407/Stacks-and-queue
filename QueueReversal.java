import java.util.*;
public class QueueReversal{
    // 1 2 3 4 5 --> 5 4 3 2 1 
    // Use stack for Queue reversal --> LIFO
    // Keep removing elements from front of queue & keep adding it to the top of stack until queue is empty 
    // Then pop elements from stack and add them to the queue until stack is empty

    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        // Removing elements from queue and adding them to stack
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        // Removing elements from stack and adding to queue
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void main(String args[]){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        reverse(q);

        // print q
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }


}