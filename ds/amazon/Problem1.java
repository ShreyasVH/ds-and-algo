import java.util.*;
class Solution
{
	public ArrayList<String> topNCompetitors(int numCompetitors, 
	                                         int topNCompetitors, 
                                             List<String> competitors, 
											 int numReviews, 
											 List<String> reviews)
    {
        // WRITE YOUR CODE HERE
        ArrayList<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
    
        for(String competitor: competitors)
        {
            map.put(competitor, 0);
        }
        
        for(String competitor: competitors)
        {
            for(String review: reviews)
            {
                if(review.indexOf(competitor) != -1)
                {
                    map.put(competitor, (map.get(competitor) + 1));
                }
            }
        }
        
        Set<String> set = new TreeSet<String>(new Comparator<String>(){
            @Override
            public int compare(String a, String b)
            {
                if(map.get(a) > map.get(b))
                {
                    return -1;
                }
                else if(map.get(a) < map.get(b))
                {
                    return 1;
                }
                else
                {
                    return a.compareToIgnoreCase(b);
                }
            }
        });
        
        for(String competitor: map.keySet())
        {
            set.add(competitor);
        }
        
        int i = 0;
        Iterator<String> itr = set.iterator();
        while(itr.hasNext() && i < Integer.min(topNCompetitors, numCompetitors))
        {
            String competitor = itr.next();
            if(map.get(competitor) > 0)
            {
                result.add(competitor);
                i++;
            }
        }
        
        return result;
    }

    public static void main(String[] args)
    {
    	Solution s = new Solution();

    	// List<String> competitors = new ArrayList<String>(){
    	// 	{
    	// 		add("abc");
    	// 		add("bbc");
    	// 		add("cbc");
    	// 	}
    	// };

    	// List<String> reviews = new ArrayList<String>(){
    	// 	{
    	// 		add("bbc");
    	// 		add("bbc abc abc bbc bbc");
    	// 		add("abc");
    	// 	}
    	// };



    	// System.out.println(s.topNCompetitors(3, 2, competitors, 3, reviews));


    	List<String> competitors = new ArrayList<String>(){
    		{
    			add("abc");
    			add("bbc");
    			add("cbc");
    		}
    	};

    	List<String> reviews = new ArrayList<String>(){
    		{
    			add("bbc");
    			add("bbc abc abc bbc bbc");
    			add("abc");
    		}
    	};



    	System.out.println(s.topNCompetitors(3, 2, competitors, 3, reviews));
    }
}