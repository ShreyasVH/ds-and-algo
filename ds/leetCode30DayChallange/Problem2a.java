public class Problem2a
{
	public int MAX_TRIES = 10;

	public static void main(String[] args)
	{
		Problem2a problem = new Problem2a();
		System.out.println(problem.isHappy(19));
		System.out.println(problem.isHappy(18));

		// for(int i = 1; i <= 1000; i++)
		// {
		// 	problem.cache = new HashMap<>();
		// 	System.out.println(i + " : " + problem.isHappy(i));
		// }
	}

	public boolean isHappy(int n)
	{
		int tryCount = 1;
		while((n != 1) && (tryCount <= MAX_TRIES))
		{
			int newNumber = 0;
			while(n > 0)
			{
				newNumber += ((n % 10) * (n % 10));
				n /= 10;
			}

			if(n == 1)
			{
				break;
			}

			n = newNumber;
			tryCount++;
		}

		return (n == 1);
	}
}