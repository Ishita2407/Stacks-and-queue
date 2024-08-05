
import javax.swing.plaf.synth.SynthSpinnerUI;
import java.util.*;
public class Stacks{
    public static void main(String args[]){
        Scanner scn = new Scanner (System.in);
        String str = scn.nextLine();      // Reading/ Inputting string from user
        Stack <Character> st = new Stack<>(); // Creating stack
        for (int i=0; i<str.length(); i++){  // Loop to traverse through the string
            char ch = str.charAt(i);         // Checking the char at ith index in every iteration
            if ( ch=='(' || ch=='{' || ch=='['){
                st.push(ch);       // if opening bracket is encountered, push it onto the stack
            }else if (ch== ')'){
               boolean val = handleClosing(st, '(');
               if(val == false){
                System.out.println(val);
                return;
               }
            } else if ( ch == '}' ){
                boolean val = handleClosing(st, '{');
                if(val == false){
                    System.out.println(val);
                    return;
                }
            }else if (ch == ']'){
                boolean val = handleClosing(st, '[');
                if(val == false){
                    System.out.println(val);
                    return;
                }
            } else {
            }
        }
        if (st.size() == 0){
            System.out.println(true);
        } else{
            System.out.println(false);
        }
    }
    public static boolean handleClosing (Stack<Character> st, char corresoch){  // corresoch - corresponding opening char
        if(st.size() == 0){   // empty stack, everything has been popped already
            return false;
        } else if(st.peek() != corresoch){  // if we don't have corresponding opening character
           return false;
        }else{
            st.pop();
            return true;
        }
    }
}