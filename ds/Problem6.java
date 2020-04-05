/*

	Find the lattice points on a circle of radius r
*/

import java.util.Scanner;

public class Problem6
{
	public static void main(String[] args)
	{
		// // printCoOrdinates(getCoOrdinates(5));
		// printCoOrdinates(getCoOrdinates(4));

		Scanner scanner = new Scanner(System.in);
		int r = scanner.nextInt();

		printCoOrdinates(getCoOrdinates(r));
	}

	public static void printCoOrdinates(CoOrdinate[] coOrdinates)
	{
		for(int i = 0; i < coOrdinates.length; i++)
		{
			if(null != coOrdinates[i])
			{
				System.out.println("(" + coOrdinates[i].x + ", " + coOrdinates[i].y + ")");
			}
		}
	}

	public static CoOrdinate[] getCoOrdinates(int r)
	{
		CoOrdinate[] coOrdinates = new CoOrdinate[4 * (r + 1)];

		coOrdinates[0] = new CoOrdinate(0, r);
		coOrdinates[1] = new CoOrdinate(0, (r * -1));
		coOrdinates[2] = new CoOrdinate(r, 0);
		coOrdinates[3] = new CoOrdinate((r * -1), 0);
		int i = 4;

		for(int x = 1; x < r; x++)
		{
			Double y = Math.sqrt(square(r) - square(x));
			if(isInteger(y))
			{
				coOrdinates[i++] = new CoOrdinate(x, y.intValue());
				coOrdinates[i++] = new CoOrdinate(x, (y.intValue() * -1));
				coOrdinates[i++] = new CoOrdinate((x * -1), (y.intValue() * -1));
				coOrdinates[i++] = new CoOrdinate((x * -1), y.intValue());
			}
		}
		return coOrdinates;
	}

	public static int square(int x)
	{
		return (x * x);
	}

	public static boolean isInteger(Double d)
	{
		return (d == d.intValue());
	}
}

class CoOrdinate
{
	int x;
	int y;

	CoOrdinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}