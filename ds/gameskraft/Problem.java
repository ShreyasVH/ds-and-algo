/*
	Probability Generator

	Input
	1. A file with strings and their probabilities. The probabilities would sum to 1. Each string won't be longer than 1000 characters and there can be a maximum of 100 strings in the file.

	A sample probability input file - probabilities.txt
	This is a sample string,0.56
	This is another string,0.30
	This is yet another string,0.1
	Least occuring string,0.04

	2. Write a code in Java implementing the following interface. The code should read the probabilities file (inputFile) and generate the string according to the probabilities specified in the file when getNextString method is called.

	public abstract ProbabilityGenerator {
	     abstract void String getNextString();
	}

	e.g. for the above probabilities.txt file, if the above method is called 100 times, ideally, "This is a sample string" should be generated 56 times, "This is another string" should be generated 30 times, etc. and written to the outputFile.

	Sample usage of the above

	public static void main() {
	     // init the prob generator
	     ProbabilityGenerator gen = new ProbabilityGeneratorImpl("probabilities.txt");

	     for(int i=0; i<1200; i++) {
	          String nextStr = gen.getNextString();
	          ....

	          // write in the output file
	          ....
	     }
*/


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class Problem
{
	public static void main(String[] args) throws Exception
	{
		ProbabilityGenerator pg = new ProbabilityGeneratorImpl("probabilities.txt");

		try(PrintWriter pw = new PrintWriter("output.txt"))
		{
			for(int i = 1; i <= 100000; i++)
			{
				pw.println(pg.getNextString());
			}
			pw.flush();
		}
	}
}

abstract class ProbabilityGenerator
{
	abstract String getNextString();
}

class ProbabilityGeneratorImpl extends ProbabilityGenerator
{
	TreeMap<Double, List<String>> map = new TreeMap<>();
	Random random = new Random();

	ProbabilityGeneratorImpl(String fileName) throws Exception
	{
		init(fileName);
	}

	public void init(String fileName) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		while(null != line)
		{
			String[] parts = line.split(",");
			if(parts.length == 2)
			{
				Double key = Double.parseDouble(parts[1]);
				List<String> list = new ArrayList<>();
				if(map.containsKey(key))
				{
					list = map.get(key);
				}

				list.add(parts[0]);
				map.put(key, list);
			}
			line = br.readLine();
		}
		// System.out.println(map);
	}

	String getNextString()
	{
		String str = "";
		Double rand = Math.random();
		// System.out.println("Rand: " + rand);

		Double curVal = 0.0;
		Double requiredKey = null;
		for(Double key : map.keySet())
		{
			List<String> values = map.get(key);
			curVal += (key * values.size());

			if(rand <= curVal)
			{
				requiredKey = key;
				break;
			}
		}

		List<String> list = map.get(requiredKey);
		if(list.size() == 1)
		{
			str = list.get(0);
		}
		else
		{
			int index = random.nextInt(list.size());
			str = list.get(index);
		}

		return str;
	}
}