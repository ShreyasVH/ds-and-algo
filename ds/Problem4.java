/*
	There are two sorted arrays nums1 and nums2 of size m and n respectively.

	Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

	You may assume nums1 and nums2 cannot be both empty.
*/

public class Problem4
{
	public static void main(String[] args)
	{
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2)
	{
  	int n1 = nums1.length;
  	int n2 = nums2.length;
    	
    int[] finalArray = new int[n1 + n2];

  	int i = 0;
  	int j = 0;
  	int k = 0;


  	while((j < n1) && (k < n2))
  	{
  		if(nums1[j] < nums2[k])
  		{
  			finalArray[i] = nums1[j];
  			j++;
  		}
  		else
  		{
  			finalArray[i] = nums2[k];
  			k++;
  		}

  		i++;
  	}

  	while(j < n1)
  	{
  		finalArray[i] = nums1[j];
  		j++;
  		i++;
  	}

  	while(k < n2)
  	{
  		finalArray[i] = nums2[k];
  		k++;
  		i++;
  	}

  	int finalLength = (n1 + n2);
  	double median = 0.0;
  	if(((n1 + n2) % 2) == 0)
  	{
  		long medianSum = finalArray[(n1 + n2) / 2] + finalArray[(((n1 + n2) / 2) - 1)];
  		median = (medianSum / 2.0);
  	}
  	else
  	{
  		long medianSum = finalArray[(n1 + n2) / 2];
  		median = (medianSum / 1.0);
  	}
  	return median;
  }

  public static void print(int[] arr)
  {
  	for(int i = 0; i < arr.length; i++)
  	{
  		System.out.print(arr[i] + " ");
  	}
  	System.out.println("");
  }
}