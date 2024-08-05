import java.util.io;
// Next greater element to the right
public class StackNxtGrt{
    public void display(int[] a){
        StringBuilder sb = new StringBuilder();
        for(int val: a){
            sb.append(val + '\n');
        }
        System.out.println(sb);
    }
    public static void main(String[] args){
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i=0; i,n; i++){
            a[i] = scn.nextInt();
        }
        // Defining an answer array nge of same length of input array arr
        int[] nge = new int[arr.length];  // nge- next greater element
        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length-1]); // Last element is pushed onto the stack
        nge[arr.length-1] = -1; // Last elements' nge= -1 as no element is on RHS
        for(int i=arr.length-2; i>=0; i--){
           // -,a,+ = pop, ans, push 
           while(st.size() >0 && arr[i] >= st.peek()){ 
        // pop till the stack isn't empty+ element at ith index is greater than element at top of stack
                st.pop();
           }
           if (st.size() == 0){  // stack is empty - all elements have been popped
            // this was the greatest element
                nge[i] = -1;
           } else{    // element greater than present element is encountered
                nge[i] = st.peek();  // topmost element of stack will be its ans
           }
           st.push(arr[i]);
        }
        return nge;
    }
}