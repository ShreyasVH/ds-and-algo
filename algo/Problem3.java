/*
	There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is start time of meeting i and F[i] is finish time of meeting i.

	What is the maximum number of meetings that can be accommodated in the meeting room?

	Input:
	The first line of input consists number of the test cases. The description of T test cases is as follows:
	The first line consists of the size of the array, second line has the array containing the starting time of all the meetings each separated by a space, i.e., S [ i ]. And the third line has the array containing the finishing time of all the meetings each separated by a space, i.e., F [ i ].

	Output:
	In each separate line print the order in which the meetings take place separated by a space.

	Constraints:
	1 ≤ T ≤ 70
	1 ≤ N ≤ 100
	1 ≤ S[ i ], F[ i ] ≤ 100000

	Example:
	Input:
	2
	6
	1 3 0 5 8 5
	2 4 6 7 9 9
	8
	75250 50074 43659 8931 11273 27545 50879 77924
	112960 114515 81825 93424 54316 35533 73383 160252  

	Output:
	1 2 4 5
	6 7 1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)
	{
		//code
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();

		for(int i = 1; i <= T; i++)
		{
			int N = scanner.nextInt();
			Meeting[] meetings = new Meeting[N];

			for(int j = 0; j < N; j++)
			{
				Meeting meeting = new Meeting();
				meeting.start = scanner.nextInt();
				meeting.originalIndex = j;
				meetings[j] = meeting;
			}

			for(int j = 0; j < N; j++)
			{
				Meeting meeting = meetings[j];
				meeting.finish = scanner.nextInt();
			}

			printMeetingOrder(meetings);
		}
	}

	public static void printMeetingOrder(Meeting[] meetings)
	{
		sort(meetings, 0, meetings.length - 1);
		// print(meetings);

		System.out.print(meetings[0].originalIndex + 1 + " ");
		int prev = 0;
		for(int current = 1; current < meetings.length; current++)
		{
			if(meetings[current].start >= meetings[prev].finish)
			{
				System.out.print(meetings[current].originalIndex + 1 + " ");
				prev = current;
			}
		}
		System.out.println();
	}

	public static void sort(Meeting[] meetings, int low, int high)
	{
		if(low < high)
		{
			int p = partition(meetings, low, high);

			sort(meetings, low, p - 1);
			sort(meetings, p + 1, high);
		}
	}

	public static int partition(Meeting[] meetings, int low, int high)
	{
		int i = low;
		int pivot = meetings[high].finish;

		for(int j = low; j < high; j++)
		{
			if(meetings[j].finish < pivot)
			{
				Meeting temp = meetings[j];
				meetings[j] = meetings[i];
				meetings[i] = temp;
				i++;
			}
		}

		Meeting temp = meetings[high];
		meetings[high] = meetings[i];
		meetings[i] = temp;
		return i;
	}

	public static void print(Meeting[] meetings)
	{
		for(int i = 0; i < meetings.length; i++)
		{
			System.out.print(meetings[i].start + ":" + meetings[i].finish + " ");
		}
		System.out.println("");
	}
}

class Meeting
{
	int start;
	int finish;
	int originalIndex;
}