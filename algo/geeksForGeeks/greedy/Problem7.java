/*
	Huffman Coding

	Let us understand prefix codes with a counter example. Let there be four characters a, b, c and d, and their corresponding variable length codes be 00, 01, 0 and 1. This coding leads to ambiguity because code assigned to c is the prefix of codes assigned to a and b. If the compressed bit stream is 0001, the de-compressed output may be “cccd” or “ccb” or “acd” or “ab”.
*/
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
class Problem
{
	static class HuffmanNode
	{
		int freq;
		char c;
		String code;
		HuffmanNode left;
		HuffmanNode right;

		HuffmanNode(int freq, char c)
		{
			this.freq = freq;
			this.c = c;
		}

		public String toString()
		{
			return "{freq:" + this.freq + ", c:" + this.c + "}";
		}

	}


	public static void main(String[] args)
	{
		print(getHuffmanCodes(new int[]{5, 9, 12, 13, 16, 45}, new char[]{'a', 'b', 'c', 'd', 'e', 'f'}));
	}

	public static List<HuffmanNode> getHuffmanCodes(int[] freq, char[] c)
	{
		List<HuffmanNode> result = new ArrayList<>(freq.length);
		PriorityQueue<HuffmanNode> q = new PriorityQueue<>(new Comparator<HuffmanNode>(){
			public int compare(HuffmanNode a, HuffmanNode b)
			{
				return a.freq - b.freq;
			}
		});

		for(int i = 0; i < c.length; i++)
		{
			q.add(new HuffmanNode(freq[i], c[i]));
		}

		while(q.size() > 1)
		{
			HuffmanNode first = q.poll();
			HuffmanNode second = q.poll();

			HuffmanNode intermediate = new HuffmanNode(first.freq + second.freq, '-');
			intermediate.left = first;
			intermediate.right = second;
			q.add(intermediate);
		}

		assignCode(q.peek(), "", result);

		return result;
	}

	public static void assignCode(HuffmanNode node, String s, List<HuffmanNode> codes)
	{
		if(null != node)
		{
			if((null == node.left) && (null == node.right) && (Character.isLetter(node.c)))
			{
				node.code = s;
				codes.add(node);
				return;
			}

			assignCode(node.left, s + "0", codes);
			assignCode(node.right, s + "1", codes);
		}
	}

	public static void print(List<HuffmanNode> codes)
	{
		for(HuffmanNode node: codes)
		{
			System.out.println(node.c + " : " + node.code);
		}
	}
}