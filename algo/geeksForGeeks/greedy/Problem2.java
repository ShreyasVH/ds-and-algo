/*
	Greedy Algorithm for Egyptian Fraction
*/
import java.util.List;
import java.util.ArrayList;

public class Problem2
{

	static class Fraction
	{
		int nr;
		int dr;

		Fraction(int nr, int dr)
		{
			this.nr = nr;
			this.dr = dr;
		}
	}

	public static void main(String[] args)
	{
		// printFractions(printEgyptianFractions(new Fraction(3, 7)));
		// printFractions(printEgyptianFractions(new Fraction(12, 13)));
		printFractions(printEgyptianFractions(new Fraction(17, 12)));
	}

	public static List<Fraction> printEgyptianFractions(Fraction input)
	{
		List<Fraction> fractions = new ArrayList<>();
		
		int nr = input.nr;
		int dr = input.dr;

		if((nr == 0) || (dr == 0))
		{
			return fractions;
		}

		if((nr % dr) == 0)
		{
			return new ArrayList<Fraction>() {
				{
					add(new Fraction(nr / dr, 1));
				}
			};
		}

		if((dr % nr) == 0)
		{
			return new ArrayList<Fraction>() {
				{
					add(new Fraction(1, (dr / nr)));
				}
			};
		}

		if(nr > dr)
		{
			fractions.add(new Fraction((nr / dr), 1));
			fractions.addAll(printEgyptianFractions(new Fraction((nr % dr), dr)));
			return fractions;
		}

		int n = ((dr / nr) + 1);
		fractions.add(new Fraction(1, n));
		fractions.addAll(printEgyptianFractions(new Fraction((n * nr - dr), (n * dr))));

		return fractions;
	}

	public static void printFractions(List<Fraction> fractions)
	{
		int count = 0;
		for(Fraction fraction: fractions)
		{
			System.out.print(fraction.nr);
			if(fraction.dr != 1)
			{
				System.out.print(" / " + fraction.dr);
			}
			count++;
			if(count != fractions.size())
			{
				System.out.print(" + ");
			}
		}
		System.out.println();
	}
}