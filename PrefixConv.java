import java.io.*;
public class PrefixConv{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();  // Input expression
        Stack<Integer> vs = new Stack<>();  // Value stack
        Stack<Character> is = new Stack<>();  // Infix stack
        Stack<Character> ps = new Stack<>();  // Postfix stack
        for(int i = exp.length()-1 ; i>=0; i--){  // Start traversing from last index
            char ch = exp.charAt(i);
            if(ch == '+' || ch=='-' || ch=='*' || ch=='/'){
                int v1 = vs.pop();
                int v2 = vs.pop();
                int val = operation(v1,v2,ch);  // Perform operation
                vs.push(val);  // push result of operation
                String iv1 = is.pop();
                String iv2 = is.pop();
                String ival = '(' + iv1 + ch + iv2 + ')'; // Infix Notation
                is.push(ival);
                String pv1 = ps.pop();
                String pv2 = ps.pop();
                String pval = pv1 + pv2 + ch;
                ps.push(pval);
            } else {
                vs.push(ch - '0'); 
                is.push(ch + "");
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
           