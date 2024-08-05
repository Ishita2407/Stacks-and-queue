// PUSH AT THE BOTTOM OF THE STACK
// Using recursion - O(n) and no extra space
import java.util.*;
public class PushBottomStack{
    public static void pushAtBottom(Stack <Integer> s, int data){
        if(s.isEmpty()){
            // When stack is initially empty we can simply push the element
            // The element will be placed at the bottom of stack
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottom(s, 4);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}