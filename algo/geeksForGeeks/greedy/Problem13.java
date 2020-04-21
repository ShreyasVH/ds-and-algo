/*
	Given length of wall w and shelves of two lengths m and n, find the number of each type of shelf to be used and the remaining empty space in the optimal solution so that the empty space is minimum. The larger of the two shelves is cheaper so it is preferred. However cost is secondary and first priority is to minimize empty space on wall.

	Examples:

	Input : w = 24 m = 3 n = 5
	Output : 3 3 0
	We use three units of both shelves
	and 0 space is left.
	3 * 3 + 3 * 5 = 24
	So empty space  = 24 - 24 = 0
	Another solution could have been 8 0 0
	but since the larger shelf of length 5
	is cheaper the former will be the answer.

	Input : w = 29 m = 3 n = 9 
	Output : 0 3 2
	0 * 3 + 3 * 9 = 27
	29 - 27 = 2

	Input : w = 24 m = 4 n = 7 
	Output : 6 0 0
	6 * 4 + 0 * 7 = 24
	24 - 24 = 0
*/
class Solution
{
	public static void main(String[] args)
	{
		Solution s = new Solution();
		s.printSolution(24, 3, 5);
		s.printSolution(29, 3, 9);
		s.printSolution(24, 4, 7);
		s.printSolution(7, 3, 5);
		s.printSolution(7, 5, 6);
	}

	public void printSolution(int wallLength, int smallShelfLength, int bigShelfLength)
	{
		int smallShelfCount = 0;
		int bigShelfCount = 0;
		int remainingLength = wallLength;

		if((wallLength % bigShelfLength) == 0)
		{
			bigShelfCount = wallLength / bigShelfLength;
			remainingLength = 0;
		}
		else if((wallLength % (smallShelfLength + bigShelfLength)) == 0)
		{
			smallShelfCount = bigShelfCount = (wallLength / (smallShelfLength + bigShelfLength));
			remainingLength = 0;
		}
		else if((wallLength % smallShelfLength) == 0)
		{
			smallShelfCount = wallLength / smallShelfLength;
			remainingLength = 0;
		}
		else
		{
			if(wallLength < (smallShelfLength + bigShelfLength))
			{
				smallShelfCount = wallLength / smallShelfLength;
				remainingLength = (wallLength - smallShelfLength * smallShelfCount);
			}
			else
			{
				bigShelfCount = remainingLength / bigShelfLength;
				remainingLength = (remainingLength - bigShelfLength * bigShelfCount);

				smallShelfCount = remainingLength / smallShelfLength;
				remainingLength = (remainingLength - smallShelfCount * smallShelfLength);
			}
		}


		System.out.println(smallShelfCount + " " + bigShelfCount + " " + remainingLength);

		minSpacePreferLarge(wallLength, smallShelfLength, bigShelfLength);
	}

	public void minSpacePreferLarge(int wall, int m, int n) 
    { 
        // For simplicity, Assuming m is always smaller than n 
        // initializing output variables 
        int num_m = 0, num_n = 0, min_empty = wall; 
  
        // p and q are no of shelves of length m and n 
        // rem is the empty space 
        int p = 0, q = 0, rem; 
  
        while (wall >= n) { 
            // place as many shelves of length m 
            // in the remaining part 
            p = wall / m; 
            rem = wall % m; 
  
            // update output variablse if curr 
            // min_empty <= overall empty 
            if (rem <= min_empty) { 
                num_m = p; 
                num_n = q; 
                min_empty = rem; 
            } 
  
            // place one more shelf of length n 
            q += 1; 
            wall = wall - n; 
        } 
        System.out.println(num_m + " " + num_n + " " + min_empty); 
    } 
}