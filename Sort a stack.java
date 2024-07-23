public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		// Sort the stack in descending order using recursion
		if(stack.isEmpty()) return;
		int top = stack.pop();
		sortStack(stack);
		if(stack.isEmpty()){
			stack.push(top);
		}else{
			Stack<Integer> temp = new Stack<>();
			while(!stack.isEmpty() && stack.peek() > top){
				temp.push(stack.pop());
			}
			stack.push(top);
			while(!temp.isEmpty()){
				stack.push(temp.pop());
			}
		}
	}
}
