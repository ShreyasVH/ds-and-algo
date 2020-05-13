import java.util.*;
import java.util.regex.*;

class Solution
{
	public List<String> reorderLines(int logFileSize, List<String> logLines) 
	{
		// WRITE YOUR CODE HERE
		List<String> result = new ArrayList<>();
		
		ArrayList<String> str = new ArrayList<>();
		ArrayList<String> num = new ArrayList<>();
		
		for(String line: logLines)
		{
		    String[] parts = line.split(" ");
		    
		    if(isNumeric(parts[1]))
		    {
		        num.add(line);
		    }
		    else
		    {
	            str.add(line);
		    }
		}
		
		sort(str, 0, str.size() - 1);
		
		result.addAll(str);
		result.addAll(num);
		
		return result;
	}
	
	public boolean isNumeric(String str)
	{
	    Pattern p = Pattern.compile("\\d+");
	    Matcher m = p.matcher(str);
	    return (m.find() && (str.equals(m.group())));
	}
	
	public void sort(ArrayList<String> str, int start, int end)
	{
	    if(start < end)
	    {
	        int n = str.size();
	        
	        int pi = partition(str, start, end);   
	        
	        sort(str, start, pi - 1);
	        sort(str, pi + 1, end);
	    }
	}
	
	public int partition(ArrayList<String> str, int start, int end)
	{
	    String pivot = str.get(end);
	    int i = start;
	    
	    for(int j = start; j < end; j++)
	    {
	        if(compare(str.get(j), pivot) < 0)
	        {
	            String temp = str.get(i);
	            str.set(i, str.get(j));
	            str.set(j, temp);
	            i++;
	        }
	    }
	    
	    String temp = str.get(i);
	    str.set(i, pivot);
	    str.set(end, temp);
	    
	    return i;
	}
	
	public int compare(String s1, String s2)
	{
	    String[] s1Parts = s1.split(" ");
	    String[] s2Parts = s2.split(" ");
	    
	    int result = 0;
	    
	    if(s1Parts[1].equals(s2Parts[1]))
	    {
	        int i = 2;
    	    while((i < s1Parts.length) && (i < s2Parts.length) && (s1Parts[i].equals(s2Parts[i])))
    	    {
    	        i++;
    	    }
    	    
    	    if((i == s1Parts.length) && (i == s2Parts.length))
    	    {
    	        return s1Parts[0].compareTo(s2Parts[0]);
    	    }
    	    else
    	    {
    	    	if(i == s1Parts.length)
    	    	{
    	    		return 1;
    	    	}
    	    	else
    	    	{
    	    		return -1;
    	    	}
    	    }
	    }
	    else
	    {
	        return s1Parts[1].compareTo(s2Parts[1]);
	    }
	}

	public static void main(String[] args)
	{
		// System.out.println("a1".compareTo("1a"));


		Solution s = new Solution();
		List<String> logLines = new ArrayList<String>(){
			{
				add("a1 9 2 3 1");
				add("g1 acta zoo");
				add("zo4 4 7");
				add("ab1 off key dog");
				add("a8 act zoo car");
			}
		};

		System.out.println(s.reorderLines(5, logLines));
	}
}