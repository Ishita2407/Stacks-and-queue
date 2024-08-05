import java.util.*;
public class QueueUsingDeque{
    // add - addLast() ; remove - removeFirst() peek --> getFirst()
    // addition is through rear , remove operation is done from first , element remove is peeked

    static class Queue{
        Deque<Integer> deque = new ArrayDeque<>();
        public void add(int data){
            deque.addLast(data);
        }
        public int remove(){
            return deque.removeFirst();
        }
        public int peek(){
            return deque.getFirst();
        }
    }
    
    public static void main(String args[]){
        Queue q = new Queue();  // calling constructor
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("peek : " + q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());

    }
}