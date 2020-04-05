/*
	Write a function rotate(ar[], d, n) that left rotates arr[] of size n by d elements. (Juggling Algorithm)
*/
public class Problem1
{
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5, 6};

		rotate(arr, 4);
		print(arr);
	}

	public static void rotate(int[] nums, int d)
	{
		int n = nums.length;
		int gcd = gcd(n, (d % n));

		for(int m = 0; m < gcd; m++)
		{
			int i = (n - m - 1);
			int temp = nums[i];
			int j = i;

			while(true)
			{
				int k = ((j - d + n) % n);

				if(k == i)
				{
					break;
				}

				nums[j] = nums[k];

				j = k;
			}
			nums[j] = temp;
		}
	}

	public static int gcd(int a, int b)
	{
		if((a % b) == 0)
		{
			return b;
		}
		else
		{
			return gcd(b, (a % b));
		}
	}

	public static void print(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}

/*
	Time Complexity: O(n)
	Space Complexity: O(1)
*/