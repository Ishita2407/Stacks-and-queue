import java.util.*;
public class PostfixConv{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        Stack< Integer> vs = new Stack< >();    // Value stack
        Stack< String> is = new Stack< >();    // Infix stack
        Stack< String> ps = new Stack< >();    // Prefix Stack

        for (int i = 0; i < exp.length(); i++) {
        char ch = exp.charAt(i);   

        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') { // Operator is encountered
            int v2 = vs.pop();
            int v1 = vs.pop();
            int val = operation(v1, v2, ch); // Performing operation
            vs.push(val);   // Pushing result of operation on stack

            String iv2 = is.pop();     
            String iv1 = is.pop();
            String ival = "(" + iv1 + ch + iv2 + ")";  // Infix notation
            is.push(ival);   // Push value on infix stack

            String pv2 = ps.pop(); 
            String pv1 = ps.pop();
            String pval = ch + pv1 + pv2;  // Prefix Notation
            ps.push(pval);   // Push value on prefix stack
        } else {
            vs.push(ch - '0');  // Converting to integer
            is.push(ch + "");  // Converting to string
            ps.push(ch + "");
        }
        }
        System.out.println(vs.pop());    
        System.out.println(is.pop());
        System.out.println(ps.pop());
    }
    public static int operation (int v1, int v2, char op) {  
        if (op == '+') {
        return v1 + v2;
        } else if (op == '-') {
        return v1 - v2;
        } else if (op == '*') {
        return v1 * v2;
        } else {
        return v1 / v2;
        }
    }
}
