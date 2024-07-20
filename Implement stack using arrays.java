Solution 1
  // Time complexity - O(N)
  // Space complexity - O(N)
  import java.util.*;

public class tuf {

    public static void main(String[] args) {

        stack s = new stack();
        s.push(6);
        s.push(3);
        s.push(7);
        System.out.println("Top of the stack before deleting any element " + s.top());
        System.out.println("Size of the stack before deleting any element " + s.size());
        System.out.println("The element deleted is " + s.pop());
        System.out.println("Size of the stack after deleting an element " + s.size());
        System.out.println("Top of the stack after deleting an element " + s.top());
    }
}
class stack {
    int size = 10000;
    int arr[] = new int[size];
    int top = -1;
    void push(int x) {
        top++;
        arr[top] = x;
    }
    int pop() {
        int x = arr[top];
        top--;
        return x;
    }
    int top() {
        return arr[top];
    }
    int size() {
        return top + 1;
    }
}

solution 2
  Class stack{
  int size = 10000;
  int top = -1;
  int arr[] = new int[size];

  public void push(int x){
    if(top == arr.length - 1){
    return;
  }
  else{
    arr[++top] = x;
  }

  public int pop(){
    if(top == -1) return -1;
    else{
      return arr[top--];
    }
  }
  }
