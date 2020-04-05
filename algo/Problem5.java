public class Problem5
{
	static int[] noteOrder = {
		1000,
		500,
		100,
		50,
		20,
		10,
		5,
		2,
		1
	};

	public static void main(String[] args)
	{
		printMinimumCoins(43);
	}

	public static void printMinimumCoins(int num)
	{
		for(int i = 0; i < noteOrder.length; i++)
		{
			int denomination = noteOrder[i];
			if(num >= denomination)
			{
				int n = (num / denomination);
				for(int j = 1; j <= n; j++)
				{
					System.out.print(denomination + " ");
				}
				num %= denomination;
				break;
			}
		}
		System.out.println();
	}
}