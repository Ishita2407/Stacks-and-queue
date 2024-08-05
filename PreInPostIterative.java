import java.util.*;
import java.util.Stack;
// Time complexity - O(n) , Space complexity - O(n)
public class PreInPostIterative{
    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void traversal(Node node){
        Stack<Pair> st = new Stack<>();
        Pair root_pair = new Pair(node, 1);

        st.push(root_pair);
        String pre = " ";
        String in = " ";
        String post = " ";

        while(st.size() > 0){
            Pair top = st.peek();
            if(top.state == 1){  // pre, state++, 
                pre += top.node.data + " ";
                top.state++;

                if(top.node.left != null){
                    Pair left_pair = new Pair(top.node.left, 1);
                    st.push(left_pair);
                }
            }
            else if(top.state == 2){
                in += top.node.data + " ";
                top.state++;

                if(top.node.right != null){
                    Pair right_pair = new Pair(top.node.right, 1);
                    st.push(right_pair);
                }
            } else{
                post += top.node.data + " ";
                st.pop();
            }
            System.out.println(pre);
            System.out.println(in);
            System.out.println(post);
        }
    }
}