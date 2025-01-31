import java.util.*;
// Time complexity - O(n)
public class ValidParentheses{
    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch =='(' || ch =='{' || ch=='['){
                // opening bracket is encountered
                s.push(ch);
            } else{
                // closing brackets
                if(s.isEmpty()){
                    return false;
                }
                // Checking the pair forming condition
                if((s.peek() == '(' && ch == ')' )  // ()
                   || s.peek() == '{' && ch == '}'  // {}
                   || s.peek() == '[' && ch == ']' ){ // []
                    s.pop();
                } else{
                    return false;
                }   
            }
        }
        if(s.isEmpty()){
            return true;
        } else{
            return false;
        }
    }
    public static void main(String args[]){
        String str = "({})[]";  // true
        System.out.println(isValid(str));
    }
}