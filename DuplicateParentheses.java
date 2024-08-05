import java.util.*;
public class DuplicateParentheses{
    // Time complexity - O(n)
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            //closing
            if(ch == ')'){
                int count = 0;
                while(s.pop() != '('){
                    count++;
                }
                if(count < 1){
                    return true;
                } 
            } else{
                // opening
                // Whenever opening parentheses or operand / operator is encountered simply push onto stack
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String args[]){
        // Valid string will be input
        String str = "((a+b))"; // true
        String str1 = "(a-b)"; // false
        System.out.println(isDuplicate(str));
        System.out.println(isDuplicate(str1));
    }
}