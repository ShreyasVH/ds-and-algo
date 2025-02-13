/*
	k-th Smallest in BST

	Given a BST and an integer k, the task is to find the kth smallest element in the BST. If there is no kth smallest element present then return -1.

	     2
	    / \
    1   3

    k = 2

    Output: 2


      2
	    / \
    1   3

    k = 5

    Output: -1


      20
    /   \
			8		   22
	/  \  
4    12
				/   \
			10   14

			k = 10

			Output: -1


*/

class Node
{
	int data;
	Node left;
	Node right;

	Node(int data)
	{
		this.data = data;
	}
}

public class Problem1
{
	public static void main(String[] args)
	{
		Node root = getBst(new int[]{2, 1, 3});

		System.out.println(kthSmallest(root, 2));

		System.out.println(kthSmallest(root, 5));

		root = getBst(new int[]{20, 8, 22, 4, 12, 10, 14});
		System.out.println(kthSmallest(root, 10));

		System.out.println(kthSmallest(getBst(new int[]{5, 2, 7, 1, 4, 6, 10, 3, 9, 11}), 3));
	}

	public static Node getBst(int[] array)
	{
		Node root = null;

		for (int i = 0; i < array.length; i++)
		{
			int data = array[i];

			Node node = new Node(data);

			if(root == null)
			{
				root = node;
			}
			else
			{
				Node curr = root;
				Node parent = null;

				while(curr != null)
				{
					parent = curr;
					if(data < curr.data)
					{
						curr = curr.left;
					} else {
						curr = curr.right;
					}
				}

				if(data < parent.data)
				{
					parent.left = node;
				} else {
					parent.right = node;
				}
			}
		}

		return root;
	}

	public static int kthSmallest(Node root, int k) {
		return kthSmallest(root, k, new int[]{0});
 }

	public static int kthSmallest(Node root, int k, int[] count) {
 	if (root == null)
 	{
 		return -1;
 	}

 	int left = kthSmallest(root.left, k, count);

 	if (left != -1)
 	{
 		return left;
 	}

 	count[0]++;

 	if (count[0] == k)
 	{
 		return root.data;
 	}

 	return kthSmallest(root.right, k, count);
 }
}