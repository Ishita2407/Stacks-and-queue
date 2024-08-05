import java.util.*;
public class NextGreaterElement{
// Important question
// Time complexity - O(n)
// 4 forms - Next greater right 
// Next greater left - only change will be in for loop it will be forward for loop from 0 to n-1
// Next smaller in Right
// Next smaller -while(!s.isEmpty() && arr[s.peek()] >= arr[i])
// Next smaller left --> both the condition of for loop and above mentioned while loop will be added
    public static void main(String args[]){
        int arr[] = {6,8,0,1,3};
        Stack<Integer> s = new Stack<>();
        int nxtGreater[] = new int[arr.length];
        // Starting a backwards loop from RHS
        // To calc next greater element to the right we r using backward loop 
        
        for(int i=arr.length-1; i>=0; i--){
            // while
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            // if else
            if(s.isEmpty()){
                // If stack is initially empty we'll return -1 since no element is present
                nxtGreater[i] = -1;
            } else{
                // ELement at the top of stack will be the next greater element
                nxtGreater[i] = arr[s.peek()];
                // To store the value at that index in the array
            }

            // push in stack
            s.push(i);
        }
        for(int i=0; i<nxtGreater.length;i++){
            System.out.print(nxtGreater[i] + " ");
        }
        System.out.println();
    }
}