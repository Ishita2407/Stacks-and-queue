import java.util.ArrayList;

public class StacksUsingArrayList{
    // To implement stacks using arraylists
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            // Returns true when stack is empty else false
            return list.size() == 0; 
        }

        // push
        public static void push(int data){
            // .add() function automatically adds the element to the last of the list
            // adds data to top of stack
            list.add(data);
        }

        // pop
        public static int pop(){
            // if stack is initially empty - return -1
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1); // .get() fn has time complexity - O(n)
            list.remove(list.size()-1);
            return top;
        }

        // peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }

    }
    public static void main(String args[]){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();  // 3 2 1 - LIFO
        }
    }
}

/*
    private int data;
    private int topIndex;

    public stackUsingArray(){
        data = new int[10];
        topIndex == -1;
    }

    public stackUsingArray(int size){
        data = new int[size];
        topIndex = -1;
    }

    // O(1)
    public int size(){
        return topIndex + 1;
    }

    // O(1)
    public boolean isEmpty(){
        if(topIndex == -1){
            return true;
        } else{
            return false;
        }
         or u can do topIndex == -1;
    }

    // o(1)
    public void push(int element){
        if(topIndex == data.length - 1){
            throw StackFullException();
            doubleCapacity();
        }
        data[++topIndex == elem;
    }

    private void doubleCapacity(){
        System.out.println("Double capacity");
        int temp[] = data;
        data = new int[2 * temp.length];

        for(int i=0; i<temp.length; i++){
            data[i] = temp[i];
        }
    }
    public int top() throw StackEmptyException{
        if(topIndex == -1){
            throw new StackEmptyException();
        }
        return data[topIndex];
    }




 */