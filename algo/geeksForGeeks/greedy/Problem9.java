/*
	Huffman Decoding
*/
import java.util.Map;
import java.util.HashMap;

class Solution
{
	public static void main(String[] args)
	{
		// String input = "100001";
		// Map<Character, String> codes = new HashMap<Character, String>(){
		// 	{
		// 		put('a', "00");
		// 		put('b', "01");
		// 		put('c', "10");
		// 		put('d', "11");
		// 	}
		// };
		// System.out.println(decode(input, codes));


		String input = "01110100011111000101101011101000111";
		Map<Character, String> codes = new HashMap<Character, String>(){
			{
				put('e', "10");
				put('f', "1100");
				put('g', "011");
				put('k', "00");
				put('o', "010");
				put('r', "1101");
				put('s', "111");
			}
		};
		System.out.println(decode(input, codes));
	}

	public static String decode(String input, Map<Character, String> codes)
	{
		Map<String, Character> codeMap = new HashMap<>();
		for(Character letter: codes.keySet())
		{
			codeMap.put(codes.get(letter), letter);
		}
		String result = "";
		String cur = "";
		for(int i = 0; i < input.length(); i++)
		{
			cur = cur + input.charAt(i);
			if(codeMap.containsKey(cur))
			{
				result += codeMap.get(cur);
				cur = "";
			}
		}
		return result;
	}
}