class MyQueue {

    int front, rear;
	int arr[] = new int[100005];
    int cnt = 0;
    MyQueue(){
		front=0;
		rear=0;
		cnt = 0;
	}
	
	//Function to push an element x in a queue.
	void push(int x){
	    if(cnt < arr.length){
	        arr[(rear++)%arr.length] = x;
	        cnt++;
	    }else{
	        System.out.println("No space");
	    }
	} 

    //Function to pop an element from queue and return that element.
	int pop(){
		if(front == rear) return -1;
		int ans = arr[front++];
		cnt--;
		return ans;
	} 
}
