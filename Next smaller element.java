import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>(A.size());

        // Initialize the result list with the size of A and fill with -1
        for (int i = 0; i < A.size(); i++) {
            arr.add(-1);
        }

        for (int i = 0; i < A.size(); i++) {
            while (!st.isEmpty() && st.peek() >= A.get(i)) {
                st.pop();
            }
            if (!st.isEmpty()) {
                arr.set(i, st.peek());
            }
            st.push(A.get(i));
        }

        return arr;
    }
}
