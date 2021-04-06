/*
	Program for array rotation
	Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements. 
*/
class Solution
{
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5, 6};

		rotate(arr, 4);
		print(arr);
	}

	public static void print(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void rotate(int[] arr, int d)
	{
		int n = arr.length;
		int hcf = gcd(n, d);

		for(int i = 0; i < hcf; i++)
		{
			int temp = arr[i];
			int j = i;
			while(true)
			{
				int k = ((j + d) % n);
				if(k == i)
				{
					break;
				}
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
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
			return gcd(b, a % b);
		}
	}
}

/*
	Time Complexity: O(n)
	Space Complexity: O(1)
*/