import java.util.*;
public class StackUsing2Queue{
    // Intuit
    // We have to push in the queue which is non-empty queue
    // Push /add - O(1)
    // pop - shift all the elements from q1 to q2 till q1 is empty
    // topmost element/ last element will be returned
    // next time we have to pop , we'll see the queue which is non-empty
    // last element again will be returned 
    // repeat till both the queues r empty

    static class Stack{
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data){ // O(1)
            if(!q1.isEmpty()){
                q1.add(data);
            } else{
                q2.add(data);
            }
        }
        public static int pop(){   // O(n)
            if(isEmpty()){
                System.out.println("Empty stack");
                return -1;
            }
            int top = -1;

            // case1
            if(!q1.isEmpty()){
                // q1 has all the elements
                while(!q1.isEmpty()){
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            } else{
                // case 2
                // q2 has all the elements
                while(!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }
        public static int peek(){   // O(n)
            if(isEmpty()){
                System.out.println("Empty stack");
                return -1;
            }
            int top = -1;

            // case1
            if(!q1.isEmpty()){
                // q1 has all the elements
                while(!q1.isEmpty()){
                    top = q1.remove();
                    q2.add(top);
                }
            } else{
                // case 2
                // q2 has all the elements
                while(!q2.isEmpty()){
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
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