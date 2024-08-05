import java.util.*;

public class StackInfix {
    // Infix expression - operand operator operand eg: a + b 
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        Stack<Character> optors = new Stack<>();  // Stack of operators
        Stack<Integer> opnds = new Stack<>();   // Stack of operands

        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);   // Extracting the character
            if (ch == '('){   // Opening bracket
                optors.push(ch);    // push in operators
            } 
            else if(Character.isDigit(ch)){
                opnds.push(ch-'0'); // Char to int conversion 0=48
            } 
            else if(ch == ')'){  // closing bracket
                while( optors.size() > 0 && optors.peek() != '('){   // operator
                    
                    int v2 = opnds.pop();     // Perform operation on top 2 elements
                    int v1 = opnds.pop();
                    char optor = optors.pop();   // pop until u reach ( or lower precedence opr
                    int opv = operation(v1,v2, optor); // opv - operation value
                    opnds.push(opv);  // Push value of operation to stack
                }
                optors.pop();  // pop opening bracket
            } 
            else if (ch == '+' || ch == '-' || ch =='*' || ch == '/'){
                // ch wants higher priority operators to solve first
                while(optors.size() > 0 && optors.peek() != '(' && precedence(ch) <= precedence(optors.peek())){
                // Pop till Operators r left , peek doesn't contain (  and precendence of element at 
                // peek is more than or equal to the value of current operator
                int v2 = opnds.pop();
                int v1 = opnds.pop();
                char optor = optors.pop();
                int opv = operation(v1,v2, optor); // opv - operation value
                opnds.push(opv);
                }
                // ch is pushing itself now - at last
                optors.push(ch);
            }        
        }
        while(optors.size() > '0'){
            char optor = optors.pop();
            int v2 = opnds.pop();
            int v1 = opnds.pop();
            int opv = operation(v1,v2, optor); // opv - operation value
            opnds.push(opv);
        }
        System.out.println(opnds.peek());  // Last element left in stack will be our answer
    }
    public static int precedence(char optor){
        if(optor == '+'){
            return 1;
        } else if (optor == '-'){
            return 1;
        } else if (optor == '*'){
            return 2;
        } else{
            return 2;
        }
    }
    public static int operation(int v1, int v2, char optor){ // optor - operator
        if(optor == '+'){
            return v1+v2; // here v2 is top element of stack
            // v1 is the element just below v2
        } else if(optor == '-'){
            return v1-v2;
        } else if (optor == '*'){
            return v1*v2;
        } else{
            return v1/v2;
        }
    } // Time complexity - O(n)  Space complexity : O(n)
}