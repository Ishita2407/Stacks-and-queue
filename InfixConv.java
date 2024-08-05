import java.util.*;
public class InfixConv{
    public static void main(String[] args){
        Scanner scn = new Scanner (System.in);
        String exp = scn.nextLine();
        Stack <String> postfix = new Stack<>();   // Postfix stack
        Stack <String> prefix = new Stack<>();    // Prefix stack
        Stack <Character> operators = new Stack<>();  // operators stack
        for (int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);
            if (ch == '('){  // Opening bracket is encountered
                operators.push(ch);
            } else if ((ch >= '0' && ch <= '9') ||
                      (ch >= 'a' && ch <= 'z')  || 
                      (ch >= 'A' && ch <= 'Z')) {  
                postfix.push(ch + "");  // Operand is converted to string
                prefix.push(ch + "");   // ch + "" = String
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {   // Operator is encountered
                while (operators.size() > 0 && operators.peek() != '(' && precedence(ch) <= precedence(operators.peek())) {
                char op = operators.pop();
        
                String postval2 = postfix.pop();
                String postval1 = postfix.pop();
                postfix.push(postval1 + postval2 + op);
        
                String preval2 = prefix.pop();
                String preval1 = prefix.pop();
                prefix.push(op + preval1 + preval2);
                }
                operators.push(ch);  // Pushing current operator
            } else if (ch == ')') {  // Closing bracket is encountered
                while (operators.size() > 0 && operators.peek() != '(') {
                char op = operators.pop();  // Pop till size>0 , ( is encountered , lower priority op)
        
                String postval2 = postfix.pop();
                String postval1 = postfix.pop();
                postfix.push(postval1 + postval2 + op);  // Postfix notation
        
                String preval2 = prefix.pop();
                String preval1 = prefix.pop();
                prefix.push(op + preval1 + preval2);  // Prefix notation
                }
                if (operators.size() > 0) {
                operators.pop();  // pop the opening bracket finally
                }
            }
        }
        while (operators.size() > 0) {  // Case when stack is still not empty eg: a+b
          char op = operators.pop();
          String postval2 = postfix.pop();
          String postval1 = postfix.pop();
          postfix.push(postval1 + postval2 + op);
    
          String preval2 = prefix.pop();
          String preval1 = prefix.pop();
          prefix.push(op + preval1 + preval2);
        }
        System.out.println(postfix.peek());
        System.out.println(prefix.peek());
    }
    public static int precedence(char op){
        if(op == '+' || op == '-'){   // + and - have equal priority
            return 1;
        } else if (op == '*' || op =='/'){   // * and / have equal priority
            return 2;           // priority of * and / is greater than + and -
        } else {   // Any other operator is input by the user except + - * /
            return 0;
        }
    }
}