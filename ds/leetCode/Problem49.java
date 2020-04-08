/*
	Given an array of strings, group anagrams together.

	Example:

	Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
	Output:
	[
	  ["ate","eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	
	Note:

	All inputs will be in lowercase.
	The order of your output does not matter.
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution
{
	public static void main(String[] args)
	{
		// String[] input = {"ate", "aet"};
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

		Solution problem = new Solution();
		System.out.println(problem.groupAnagrams(input));
	}

	public List<List<String>> groupAnagrams(String[] strs)
	{
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs)
        {
        	char[] charArray = str.toCharArray();
        	getLeastAnagaram(charArray, 0, str.length() - 1);
        	String leastAnagram = new String(charArray);

        	List<String> list;
        	if(map.containsKey(leastAnagram))
        	{
        		list = map.get(leastAnagram);
        	}
        	else
        	{
        		list = new ArrayList<>();
        	}
        	list.add(str);
        	map.put(leastAnagram, list);
        }
        
        for(String key: map.keySet())
        {
        	result.add(map.get(key));
        }

        return result;
    }

    public void getLeastAnagaram(char[] str, int start, int end)
    {
    	if(start < end)
    	{
    		int pi = partition(str, start, end);

    		getLeastAnagaram(str, start, (pi - 1));
    		getLeastAnagaram(str, (pi + 1), end);
    	}
    }

    public int partition(char[] str, int start, int end)
    {
    	int i = start;
    	char pivot = str[end];

    	for(int j = start; j < end; j++)
    	{
    		if(str[j] <= pivot)
    		{
    			char temp = str[j];
    			str[j] = str[i];
    			str[i] = temp;
    			i++;
    		}
    	}

    	char temp = str[end];
    	str[end] = str[i];
    	str[i] = temp;

    	return i;
    }
}

/*
    Time Complexity: O(nmlogm)
    Space Complexity: O(n)
*/