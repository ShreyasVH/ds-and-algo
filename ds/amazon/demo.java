import java.util.*;
class Test
{
	public static void main(String[] args) throws Exception
	{
		Test t = new Test();
		System.out.println(t.cellCompete(new int[]{1, 1, 1, 0, 1, 1, 1, 1}, 2));
	}

	public List<Integer> cellCompete(int[] states, int days)
    {
    // WRITE YOUR CODE HERE
        List<Integer> result = new ArrayList<>();
        
        for(int i = 1; i <= days; i++)
        {
            int temp = 0;
            for(int j = 0; j < states.length; j++)
            {
            	System.out.println("temp: " + temp);
                int updated = (temp ^ value(states, j + 1));
                temp = states[j];
                states[j] = updated;
            }
            print(states);
        }
        
        for(int i = 0; i < states.length; i++)
        {
            result.add(states[i]);
        }
        
        return result;
    }
    
    public int value(int[] states, int i)
    {
        if((i < 0) || (i >= states.length))
        {
            return 0;
        }
        else
        {
            return states[i];
        }
    }

    public static void print(int[] nums)
    {
    	for(int i = 0; i < nums.length; i++)
    	{
    		System.out.print(nums[i] + " ");
    	}
    	System.out.println();
    }
}