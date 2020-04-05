/*
	You are given n activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.
*/



import java.util.Comparator;
import java.util.Arrays;

public class Problem1
{
	static class Activity
	{
		int originalIndex;
		int finalIndex;
		int startTime;
		int endTime;

		Activity(int startTime, int endTime, int originalIndex)
		{
			this.startTime = startTime;
			this.endTime = endTime;
			this.originalIndex = originalIndex;
		}
	}

	public static void main(String[] args)
	{
		// Activity[] activities = {new Activity(10, 20, 0), new Activity(12, 25, 1), new Activity(20, 30, 2)};
		Activity[] activities = {new Activity(1, 2, 0), new Activity(3, 4, 1), new Activity(0, 6, 2), new Activity(5, 7, 3), new Activity(8, 9, 4), new Activity(5, 9, 5)};
		print(getActivities(activities));
	}

	public static void print(Activity[] activities)
	{
		for(int i = 0; i < activities.length; i++)
		{
			if(null != activities[i])
			{
				System.out.print(activities[i].originalIndex + " ");
			}
		}

		System.out.println();
	}

	public static Activity[] getActivities(Activity[] activities)
	{
		Activity[] result = new Activity[activities.length];

		sort(activities);

		result[0] = activities[0];
		int index = 1;

		Activity prev = activities[0];
		for(int i = 1; i < activities.length; i++)
		{
			if(activities[i].startTime >= prev.endTime)
			{
				result[index] = activities[i];
				prev = activities[i];
				index++;
			}
		}

		return result;
	}

	public static void sort(Activity[] activities)
	{
		Arrays.sort(activities, new Comparator<Activity>(){
			public int compare(Activity a, Activity b)
			{
				return (a.endTime - b.endTime);
			}
		});
	}


}