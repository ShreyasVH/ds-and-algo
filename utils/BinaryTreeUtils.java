package utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import utils.ArrayUtils;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeUtils
{
	public static TreeNode getBst(int[] array)
	{
		TreeNode root = null;

		for (int i = 0; i < array.length; i++)
		{
			int data = array[i];

			TreeNode node = new TreeNode(data);

			if(root == null)
			{
				root = node;
			}
			else
			{
				TreeNode curr = root;
				TreeNode parent = null;

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

		print(root);
		System.out.println();

		return root;
	}

	public static int getNodeCount(TreeNode root)
    {
    	if (root == null)
    	{
    		return 0;
    	}

    	return getNodeCount(root.left) + getNodeCount(root.right) + 1;
    }

    public static void inOrder(TreeNode root, List<Integer> arr, Map<Integer, Map<String, Boolean>> childNodeMap)
    {
    	if (root != null)
    	{
    		if(root.left != null)
    		{
    			childNodeMap.put(root.left.data, new HashMap<String, Boolean>(){
	    			{
	    				put("left", true);
	    			}
	    		});
    		}
    		inOrder(root.left, arr, childNodeMap);
    		arr.add(root.data);
    		if(root.right != null)
    		{
    			childNodeMap.put(root.right.data, new HashMap<String, Boolean>(){
	    			{
	    				put("right", true);
	    			}
	    		});
    		}
    		inOrder(root.right, arr, childNodeMap);
    	}
    }

    public static int getXCoOrdinate(List<Integer> list, int num)
    {
    	return 2 * list.indexOf(num);
    }

    public static void createYCoOrdinateMap(TreeNode root, int parentLevel, Map<Integer, Integer> map)
    {
    	if(root != null)
    	{
    		createYCoOrdinateMap(root.left, parentLevel + 1, map);
    		map.put(root.data, parentLevel);
    		createYCoOrdinateMap(root.right, parentLevel + 1, map);
    	}
    }

    public static int getYCoOrdinate(Map<Integer, Integer> map, int num)
    {
    	return 2 * map.get(num);
    }

    public static int getHeight(TreeNode root)
    {
    	if(root == null)
    	{
    		return 0;
    	}

    	return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static void print(TreeNode root) {
    	if(root != null)
    	{
    		int nodeCount = getNodeCount(root);
	        // System.out.println("Nodecount: " + nodeCount);
	        List<Integer> list = new ArrayList<>(nodeCount);
	        Map<Integer, Map<String, Boolean>> childNodeMap = new HashMap<>();
	        inOrder(root, list, childNodeMap);
	        // System.out.println(list);
	        int height = getHeight(root);
	        // System.out.println("Height: " + height);
	        Map<Integer, Integer> map = new HashMap<>();
	        createYCoOrdinateMap(root, 0, map);
	        // System.out.println(map);

	        int rows = 2 * height - 1;
	        int columns = 2 * nodeCount - 1;
	        // System.out.println();
	        Object[][] matrix = new Object[rows][columns];

	        for(int i = 0; i < rows; i++)
	        {
	        	for(int j = 0; j < columns; j++)
	        	{
	        		matrix[i][j] = " ";
	        	}
	        }

	        // print(matrix, rows, columns);
	        // System.out.println(childNodeMap);

	        for(int i = 0; i < nodeCount; i++)
	        {
	        	int num = list.get(i);
	        	int xCoOrdinate = getXCoOrdinate(list, num);
	        	int yCoOrdinate = getYCoOrdinate(map, num);

	        	// System.out.println(num + " -> " + "(" + xCoOrdinate + ", " + yCoOrdinate + ")");
	        	matrix[yCoOrdinate][xCoOrdinate] = num;

	        	if(childNodeMap.getOrDefault(num, new HashMap<String, Boolean>()).getOrDefault("left", false))
	    		{
	    			matrix[yCoOrdinate - 1][xCoOrdinate + 1] = "/";
	    		}
	    		else if(childNodeMap.getOrDefault(num, new HashMap<String, Boolean>()).getOrDefault("right", false))
	    		{
	    			matrix[yCoOrdinate - 1][xCoOrdinate - 1] = "\\";
	    		}
	        }

	        // System.out.println();

	        // System.out.println()

	        ArrayUtils.print(matrix, rows, columns);
	        System.out.println();


	        // printArray(sortedArray);
    	}
    }

    public static List<Integer> morrisTraversal(TreeNode root)
    {
    	List<Integer> orderedList = new ArrayList<>();
    	TreeNode curr = root;
    	// print(root);
    	while(curr != null)
    	{
    		if(curr.left == null)
    		{
    			// System.out.println("Left: " + curr.data);

    			orderedList.add(curr.data);
    			curr = curr.right;
    		}
    		else
    		{
    			TreeNode prev = curr.left;
    			while(prev.right != null && prev.right != curr)
    			{
    				prev = prev.right;
    			}

    			if(prev.right == null)
    			{
    				prev.right = curr;
    				curr = curr.left;
    				// print(root);
    			}
    			else
    			{
    				prev.right = null;
    				// print(root);
    				// System.out.println("Right: " + curr.data);
    				orderedList.add(curr.data);
    				curr = curr.right;
    			}
    		}
    	}


    	return orderedList;
    }

    public static TreeNode getTree(Integer... nodes)
    {
    	Queue<TreeNode> q = new LinkedList<>();
    	TreeNode root = new TreeNode(nodes[0]);
    	q.add(root);

    	int i = 1;
    	while(i < nodes.length)
    	{
    		TreeNode current = q.poll();

    		if(i < nodes.length && nodes[i] != null)
    		{
    			current.left = new TreeNode(nodes[i]);
    			q.add(current.left);
    		}
    		i++;

    		if(i < nodes.length && nodes[i] != null)
    		{
    			current.right = new TreeNode(nodes[i]);
    			q.add(current.right);
    		}
    		i++;
    	}

    	return root;
    }
}