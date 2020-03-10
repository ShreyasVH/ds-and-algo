public class Problem3a
{
	public static void main(String[] args)
	{
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

 	public static int lengthOfLongestSubstring(String s)
 	{
        if(s.length() == 0)
        {
            return 0;
        }


        int curLength = 1;
        int maxLength = 1;
        // String maxString = String.valueOf(s.charAt(0));

        int[] visited = new int[128];

        for(int i = 0; i < 128; i++)
        {
            visited[i] = -1;
        }

        visited[s.charAt(0)] = 0;

        for(int i = 1; i < s.length(); i++)
        {
            int prevIndex = visited[s.charAt(i)];
            if((-1 == prevIndex) || ((prevIndex + curLength) < i))
            {
                curLength++;
            }
            else
            {
                curLength = (i - prevIndex);
            }

            if(curLength > maxLength)
            {
                maxLength = curLength;
                // maxString = s.substring((i + 1 - curLength), (i + 1));
            }
            
            visited[s.charAt(i)] = i;
        }
        // System.out.println(maxString);

        return maxLength;
    }
}