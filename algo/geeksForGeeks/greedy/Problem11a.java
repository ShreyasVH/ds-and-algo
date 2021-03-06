/*
	Given an array of size n that has the following specifications:

	Each element in the array contains either a policeman or a thief.
	Each policeman can catch only one thief.
	A policeman cannot catch a thief who is more than K units away from the policeman.
	We need to find the maximum number of thieves that can be caught.
*/

class Solution
{
	public static void main(String[] args)
	{
		System.out.println(maxThieves(new char[]{'P', 'T', 'T', 'P', 'T'}, 1));
		System.out.println(maxThieves(new char[]{'T', 'T', 'P', 'P', 'T', 'P'}, 2));
		System.out.println(maxThieves(new char[]{'P', 'T', 'P', 'T', 'T', 'P'}, 3));
	}

	public static int maxThieves(char[] array, int k)
	{
		int result = 0;
		
		int[] thiefIndices = new int[array.length];
		int[] policeIndices = new int[array.length];

		int t = 0;
		int p = 0;

		int thiefCount = 0;
		int policeCount = 0;

		for(int i = 0; i < array.length; i++)
		{
			if('P' == array[i])
			{
				policeCount++;
				policeIndices[p++] = i;
			}
			else
			{
				thiefCount++;
				thiefIndices[t++] = i;
			}
		}

		t = 0;
		p = 0;

		while((t < thiefCount) && (p < policeCount))
		{
			if(Math.abs(policeIndices[p] - thiefIndices[t]) <= k)
			{
				result++;
				t++;
				p++;
			}
			else if(policeIndices[p] > thiefIndices[t])
			{
				t++;
			}
			else
			{
				p++;
			}
		}

		return result;
	}
}