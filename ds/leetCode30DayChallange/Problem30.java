/*
	Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree. 

	We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.

	 

	Example 1:



	Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
	Output: true
	Explanation: 
	The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure). 
	Other valid sequences are: 
	0 -> 1 -> 1 -> 0 
	0 -> 0 -> 0
	Example 2:



	Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
	Output: false 
	Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
	Example 3:



	Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
	Output: false
	Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
	 

	Constraints:

	1 <= arr.length <= 5000
	0 <= arr[i] <= 9
	Each node's value is between [0 - 9].
*/

class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequenceInternal(root, arr, 0);
    }
    
    public boolean isValidSequenceInternal(TreeNode root, int[] arr, int index)
    {
        if((null != root) && (index < arr.length))
        {
            if(root.val == arr[index])
            {
                if((root.left == null) && (null == root.right) && (index == (arr.length - 1)))
                {
                    return true;
                }
                
                boolean isLeft = isValidSequenceInternal(root.left, arr, index + 1);
                boolean isRight = isValidSequenceInternal(root.right, arr, index + 1);
                
                return (isLeft || isRight);
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}