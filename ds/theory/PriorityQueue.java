package theory;


public class PriorityQueue
{
	Object[] q;
	int size = 0;
	// Comparator c = null;
	int DEFAULT_CAPACITY = 100;

	public PriorityQueue()
	{
		q = new Object[DEFAULT_CAPACITY];
	}

	public boolean offer(Object a)
	{
		int i = size;
		size++;
		if(i == 0)
		{
			q[0] = a;
		}
		else
		{
			shiftUp(i, a);
		}
		return true;
	}

	public Object poll()
	{
		size--;
		Object last = q[size];
		Object ele = q[0];
		q[size] = null;
		shiftDown(0, last);

		return ele;
	}

	public void shiftUp(int pos, Object e)
	{
		Comparable key = (Comparable) e;
		while(pos > 0)
		{
			int parentIndex = ((pos - 1) >>> 1);
			Comparable parent = (Comparable) q[parentIndex];
			if(key.compareTo(parent) >= 0)
			{
				break;
			}
			q[pos] = parent;
			pos = parentIndex;
		}
		q[pos] = key;
	}

	public void shiftDown(int pos, Object e)
	{
		Comparable key = (Comparable) e;
		int halfIndex = (size >>> 1);

		while(pos < halfIndex)
		{
			int childIndex = ((pos << 1) + 1);
			Comparable child = (Comparable) q[childIndex];

			int rightIndex = childIndex + 1;
			if((rightIndex < size) && child.compareTo((Comparable) q[rightIndex]) > 0)
			{
				childIndex = rightIndex;
				child = (Comparable) q[childIndex];
			}

			if(child.compareTo(key) >= 0)
			{
				break;
			}

			q[pos] = child;
			pos = childIndex;
		}
		q[pos] = key;
	}

	public String toString()
	{
		StringBuilder result = new StringBuilder("[");
		for(int i = 0; i < size; i++)
		{
			result.append(q[i] + " ");
		}
		return result.append("]").toString();
	}

	public static void main(String[] args)
	{
		PriorityQueue q = new PriorityQueue();
		q.offer(5);
		// System.out.println(q);
		q.offer(1);
		// System.out.println(q);
		q.offer(4);
		// System.out.println(q);
		q.offer(2);
		// System.out.println(q);
		q.offer(3);
		// System.out.println(q);

		System.out.println(q.poll());
		System.out.println(q);
		System.out.println(q.poll());
		System.out.println(q);
		System.out.println(q.poll());
		System.out.println(q);
		System.out.println(q.poll());
		System.out.println(q);
		System.out.println(q.poll());
		System.out.println(q);
	}
}