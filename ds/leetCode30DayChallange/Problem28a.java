/*
	You have a queue of integers, you need to retrieve the first unique integer in the queue.

	Implement the FirstUnique class:

	FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
	int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
	void add(int value) insert value to the queue.
	 

	Example 1:

	Input: 
	["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
	[[[2,3,5]],[],[5],[],[2],[],[3],[]]
	Output: 
	[null,2,null,2,null,3,null,-1]

	Explanation: 
	FirstUnique firstUnique = new FirstUnique([2,3,5]);
	firstUnique.showFirstUnique(); // return 2
	firstUnique.add(5);            // the queue is now [2,3,5,5]
	firstUnique.showFirstUnique(); // return 2
	firstUnique.add(2);            // the queue is now [2,3,5,5,2]
	firstUnique.showFirstUnique(); // return 3
	firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
	firstUnique.showFirstUnique(); // return -1

	Example 2:
	Input: 
	["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
	[[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
	Output: 
	[null,-1,null,null,null,null,null,17]

	Explanation: 
	FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
	firstUnique.showFirstUnique(); // return -1
	firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
	firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
	firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
	firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
	firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
	firstUnique.showFirstUnique(); // return 17

	Example 3:
	Input: 
	["FirstUnique","showFirstUnique","add","showFirstUnique"]
	[[[809]],[],[809],[]]
	Output: 
	[null,809,null,-1]

	Explanation: 
	FirstUnique firstUnique = new FirstUnique([809]);
	firstUnique.showFirstUnique(); // return 809
	firstUnique.add(809);          // the queue is now [809,809]
	firstUnique.showFirstUnique(); // return -1

*/
import java.util.HashMap;
import java.util.LinkedList;
class FirstUnique {
	static class Node
	{
		int val;
		Node prev;
		Node next;

		public Node(int val)
		{
			this.val = val;
		}
	}

	HashMap<Integer, Node> map = new HashMap<>();
	Node head = null;
	Node tail = null;

    public FirstUnique(int[] nums) {
        for(int num: nums)
        {
        	this.add(num);
        }
    }
    
    public int showFirstUnique() {
        if(null == head)
        {
        	return -1;
        }
        else
        {
        	return head.val;
        }
    }
    
    public void add(int value) {
        if(map.containsKey(value))
        {
        	Node n = map.get(value);

        	if(null != n)
        	{
        		if(n == head)
        		{
        			head = head.next;
        		}
        		else
        		{
        			n.prev.next = n.next;
        		}

        		if(n == tail)
        		{
        			tail = tail.prev;
        		}
        		else
        		{
        			n.next.prev = n.prev;
        		}
        	}
        	map.put(value, null);
        }
        else
        {
        	Node n = new Node(value);

        	if(null == head)
        	{
        		head = n;
        		tail = n;
        	}
        	else
        	{
        		tail.next = n;
        		n.prev = tail;
        		tail = n;
        	}
        	map.put(value, n);
        }
    }

    public static void main(String[] args)
    {
    	FirstUnique f = new FirstUnique(new int[]{7, 7, 7, 7, 7, 7});
    	System.out.println(f.showFirstUnique());
    	f.add(7);
    	f.add(3);
    	f.add(3);
    	f.add(7);
    	f.add(17);
    	System.out.println(f.showFirstUnique());

    	// FirstUnique f = new FirstUnique(new int[]{2, 3, 5});
    	// System.out.println(f.showFirstUnique());
    	// f.add(5);
    	// System.out.println(f.showFirstUnique());
    	// f.add(2);
    	// System.out.println(f.showFirstUnique());
    	// f.add(3);
    	// System.out.println(f.showFirstUnique());


    }
}