/*
	Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

	get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
	put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

	The cache is initialized with a positive capacity.

	Follow up:
	Could you do both operations in O(1) time complexity?

	Example:

	LRUCache cache = new LRUCache(2);

	cache.put(1, 1);
	cache.put(2, 2);
	cache.get(1);       // returns 1
	cache.put(3, 3);    // evicts key 2
	cache.get(2);       // returns -1 (not found)
	cache.put(4, 4);    // evicts key 1
	cache.get(1);       // returns -1 (not found)
	cache.get(3);       // returns 3
	cache.get(4);       // returns 4
*/
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
class LRUCache
{
	Map<Integer, Integer> cache;
	LinkedList<Integer> q;
	int capacity;

    public LRUCache(int capacity)
    {
    	this.capacity = capacity;
        cache = new HashMap<>(capacity);
        q = new LinkedList<>();
    }
    
    public int get(int key)
    {
        int value = -1;

        if(cache.containsKey(key))
        {
        	value = cache.get(key);
        	updateQueue(key);
        }
        // System.out.println(cache);
        // System.out.println(q);

        return value;
    }
    
    public void put(int key, int value)
    {
        if(!cache.containsKey(key))
        {
        	if(q.size() == capacity)
        	{
        		Integer removedKey = q.removeLast();
        		cache.remove(removedKey);
        	}
        }

        updateQueue(key);
        cache.put(key, value);
        // System.out.println(cache);
        // System.out.println(q);
    }

    public void updateQueue(int key)
    {
    	if(cache.containsKey(key))
    	{
    		q.remove((Object) key);
    	}
    	q.addFirst(key);
    }

    public static void main(String[] args)
    {
    	LRUCache cache = new LRUCache(2);
    	cache.put(1, 1);
    	cache.put(2, 2);
    	System.out.println(cache.get(1));
    	cache.put(3, 3);
    	System.out.println(cache.get(2));
    	cache.put(4, 4);
    	System.out.println(cache.get(1));
    	System.out.println(cache.get(3));
    	System.out.println(cache.get(4));
    }
}