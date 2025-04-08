/*
Longest Palindrome in a String

Given a string s, your task is to find the longest palindromic substring within s.

A substring is a contiguous sequence of characters within a string, defined as s[i...j] where 0 ≤ i ≤ j < len(s).

A palindrome is a string that reads the same forward and backward. More formally, s is a palindrome if reverse(s) == s.

Note: If there are multiple palindromic substrings with the same length, return the first occurrence of the longest palindromic substring from left to right.

Examples :

Input: s = “forgeeksskeegfor” 
Output: “geeksskeeg”
Explanation: There are several possible palindromic substrings like “kssk”, “ss”, “eeksskee” etc. But the substring “geeksskeeg” is the longest among all.

Input: s = “Geeks” 
Output: “ee”
Explanation: "ee" is the longest palindromic substring of "Geeks". 

Input: s = “abc” 
Output: “a”
Explanation: "a", "b" and "c" are longest palindromic substrings of same length. So, the first occurrence is returned.

Constraints:
1 ≤ s.size() ≤ 10^3
s consist of only lowercase English letters.

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem703220
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        String s = "forgeeksskeegfor";
        System.out.println((String) clazz.getMethod("longestPalindrome", String.class).invoke(problem, s));

        System.out.println("--------------------------");

        s = "Geeks";
        System.out.println((String) clazz.getMethod("longestPalindrome", String.class).invoke(problem, s));

        System.out.println("--------------------------");

        s = "abc";
        System.out.println((String) clazz.getMethod("longestPalindrome", String.class).invoke(problem, s));
	}

	public String longestPalindrome(String s) {
        int maxLength = 1;
        int startIndex = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int l = i - 1;
            int r = i + 1;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
            {
                int length = r - l + 1;
                if(length > maxLength)
                {
                    maxLength = length;
                    startIndex = l;
                }

                l--;
                r++;
            }

            l = i;
            r = i + 1;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
            {
                int length = r - l + 1;
                if(length > maxLength)
                {
                    maxLength = length;
                    startIndex = l;
                }

                l--;
                r++;
            }
        }
        
        return s.substring(startIndex, startIndex + maxLength);
    }
}


/*
Time complexity: O(n^2)
Space complexity: O(1)
*/