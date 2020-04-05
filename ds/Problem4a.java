/*
	There are two sorted arrays nums1 and nums2 of size m and n respectively.

	Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

	You may assume nums1 and nums2 cannot be both empty.
*/

public class Problem4a
{
	public static void main(String[] args)
	{
		int[] nums1 = {1, 5};
		int[] nums2 = {3, 6};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2)
	{
		int m = nums1.length;
    int n = nums2.length;

    int i = 0;
    int j = 0;
    if(isEven(m + n))
    {
      int m1 = -1;
      int m2 = -1;
      for(int count = 0; count <= ((m + n) / 2); count++)
      {
        m2 = m1;
        if((i < m) && (j < n))
        {
          m1 = ((nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++]);
        }
        else if(i < m)
        {
          m1 = nums1[i++];
        }
        else
        {
          m1 = nums2[j++];
        }
      }
      return ((m1 + m2) / 2.0); 
    }
    else
    {
      int m1 = -1;
      for(int count = 0; count <= ((m + n) / 2); count++)
      {
        if((i < m) && (j < n))
        {
          m1 = ((nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++]);
        }
        else if(i < m)
        {
          m1 = nums1[i++];
        }
        else
        {
          m1 = nums2[j++];
        }
      }

      return (m1 * 1.0);
    }

  }

  public static void print(int[] arr)
  {
  	for(int i = 0; i < arr.length; i++)
  	{
  		System.out.print(arr[i] + " ");
  	}
  	System.out.println("");
  }

  public static boolean isEven(int num)
  {
    return ((num % 2) == 0);
  }
}