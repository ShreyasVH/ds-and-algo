/*
	Number of Markers
	In a metro city in Lalaland, there is a long road with markers on it after each 1 meter. There is a big International School whose vehicles are parked on the road in front of the school.

	Let’s say there are N vehicles standing on the road. You are given the starting and the end point of each vehicle standing on the road. (both inclusive.)

	You have to find the number of markers that are covered by at least one vehicle. A vehicle with starting point X and endpoint Y is considered to be present on a marker M if X <= M <= Y.

	Note that this is a parallel parking lot. The markers cover the whole lot. And it is possible for multiple vehicles to overlap. (That supposes a vehicle is parked from starting point X to endpoint Y. It is possible for another vehicle to be parked parallelly from A to B where X<=A<=Y) As mentioned
	the markers cover the whole lot.

	Input:

	The first line of input consists of an integer T (number of test cases). Each test case consists of the following:

	The first line of test case consists of an integer N.
	This is followed by N lines with two space-separated integers X and Y in each line. X represents the starting position and Y the ending position as described above.
	Output:

	For each test case, print a single integer which is the count of the number of markers with at least one vehicle
	in separate lines.

	Constraints:

	0 < T < 1000

	0 < N < 10000

	-32768 < X,Y < 32767

	Sample Input

	2
	3
	4 7
	-1 5
	3 6
	2
	1 4
	8 13
	Sample Output

	9
	10
	Explanation

	For the first test case, we have at least one vehicle standing at
	markers (-1,0,1,2,3,4,5,6,7); so output is 9.
*/
import java.util.Scanner;

public class solution2
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		// System.out.println("T: " + T);

		for(int i = 1; i <= T; i++)
		{
			int n = scanner.nextInt();
			
			int smallestStart = Integer.MAX_VALUE;
			int biggestEnd = Integer.MIN_VALUE;
			int result = 0;

			for(int k = 1; k <= n; k++)
			{
				int start = scanner.nextInt();
				int end = scanner.nextInt();

				int prevResult = result;
				if(k == 1)
				{
					smallestStart = start;
					biggestEnd = end;
					result = (end + 1 - start);
				}
				else
				{
					if(start < smallestStart)
					{
						result += (Integer.min(smallestStart - 1, end) + 1 - start);
						smallestStart = start;
					}

					if(end > biggestEnd)
					{
						result += (end + 1 - Integer.max(start, biggestEnd + 1));
						biggestEnd = end;
					}
				}
				System.out.println(start + " - " + end + " -> " + (result - prevResult));
			}

			System.out.println(result);
		}
	}
}