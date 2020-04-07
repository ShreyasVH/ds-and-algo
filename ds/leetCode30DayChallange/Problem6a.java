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

public class Problem6a
{
	public static void main(String[] args)
	{
		// String[] input = {"ate", "aet"};
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

		Problem6a problem = new Problem6a();
		System.out.println(problem.groupAnagrams(input));
	}

	public List<List<String>> groupAnagrams(String[] strs)
	{
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

        List<List<String>> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for(String str: strs)
        {
            int p = 1;
            for(int i = 0; i < str.length(); i++)
            {
                p *= primes[str.charAt(i) - 'a'];
            }
            List<String> list;
            if(map.containsKey(p))
            {
                list = result.get(map.get(p));
            }
            else
            {
                map.put(p, result.size());
                list = new ArrayList<>();
                result.add(list);
            }
            list.add(str);
        }

        return result;
    }
}

/*
    Time Complexity: O(nm)
    Space Complexity: O(n)
*/