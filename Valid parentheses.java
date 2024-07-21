Solution 1
public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (char it : s.toCharArray()) {
            if (it == '(' || it == '[' || it == '{')
                st.push(it);
            else {
                if(st.isEmpty()) return false;
                char ch = st.pop(); 
                if((it == ')' && ch == '(') ||  (it == ']' && ch == '[') || (it == '}' && ch == '{')) continue;
                else return false;
            }
        }
        return st.isEmpty();
    }


Solution 2
  class Solution {
    public boolean isValid(String s) {
        // Stack TC: O(n) SC: O(n)
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            } else {
                // check whether the stack is empty/not
                if(st.isEmpty()) return false;
                char top = st.pop();
                if((ch == ')' && top == '(') ||  (ch == ']' && top =='[') || (ch == '}' && top == '{')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
