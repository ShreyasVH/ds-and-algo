/*
	Water Connection Problem
	Every house in the colony has at most one pipe going into it and at most one pipe going out of it. Tanks and taps are to be installed in a manner such that every house with one outgoing pipe but no incoming pipe gets a tank installed on its roof and every house with only an incoming pipe and no outgoing pipe gets a tap.’
	Given two integers n and p denoting the number of houses and the number of pipes. The connections of pipe among the houses contain three input values: a_i, b_i, d_i denoting the pipe of diameter d_i from house a_i to house b_i, find out the efficient solution for the network.
	The output will contain the number of pairs of tanks and taps t installed in first line and the next t lines contain three integers: house number of tank, house number of tap and the minimum diameter of pipe between them.

	Examples:

	Input : 4 2
	        1 2 60
	        3 4 50
	Output :2
	        1 2 60
	        3 4 50
	Explanation:
	Connected components are: 
	1->2 and 3->4
	Therefore, our answer is 2 followed by
	1 2 60 and 3 4 50.

	Input :9 6
	       7 4 98
	       5 9 72
	       4 6 10
	       2 8 22
	       9 7 17
	       3 1 66
	Output :3
	        2 8 22
	        3 1 66
	        5 6 10
	Explanation:
	Connected components are 3->1, 
	5->9->7->4->6 and 2->8. 
	Therefore, our answer is 3 followed by
	2 8 22, 3 1 66, 5 6 10
*/
import java.util.Scanner;
class Solution
{
	public static class House
	{
		int num;
		Integer from;
		Integer to;
		Integer fromPipeDiameter;
		Integer toPipeDiameter;
	}


	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int houseCount = scanner.nextInt();
		int pipeCount = scanner.nextInt();

		House[] houses = new House[houseCount];

		for(int i = 1; i <= houseCount; i++)
		{
			House house = new House();
			house.num = i;
			houses[i - 1] = house;
		}

		for(int i = 1; i <= pipeCount; i++)
		{
			int fromHouseNum = scanner.nextInt();
			int toHouseNum = scanner.nextInt();
			int pipeDiameter = scanner.nextInt();

			House fromHouse = houses[fromHouseNum - 1];
			House toHouse = houses[toHouseNum - 1];
			fromHouse.to = toHouseNum;
			toHouse.from = fromHouseNum;
			fromHouse.toPipeDiameter = pipeDiameter;
			toHouse.fromPipeDiameter = pipeDiameter;
		}

		House[] housesWithTanks = new House[houseCount / 2];
		int index = 0;

		for(int i = 0; i < houseCount; i++)
		{
			House house = houses[i];
			if((house.from == null) && (null != house.to))
			{
				housesWithTanks[index++] = house;
			}
		}

		System.out.println(index);

		for(int i = 0; i < index; i++)
		{
			House house = housesWithTanks[i];
			System.out.print(house.num);
			House currentHouse = house;

			int minDiameter = currentHouse.toPipeDiameter;

			while(null != currentHouse.to)
			{
				if(currentHouse.toPipeDiameter < minDiameter)
				{
					minDiameter = currentHouse.toPipeDiameter;
				}
				currentHouse = houses[currentHouse.to - 1];
			}

			System.out.println(" " + currentHouse.num + " " + minDiameter);
		}
	}
}

/*
	Time Complexity: O(n)
	Space Complexity: O(n)
*/