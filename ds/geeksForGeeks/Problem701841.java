/*
Word Ladder I

Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find the length of the shortest transformation sequence from startWord to targetWord.
Keep the following conditions in mind:

A word can only consist of lowercase characters.
Only one letter can be changed in each transformation.
Each transformed word must exist in the wordList including the targetWord.
startWord may or may not be part of the wordList
The second part of this problem can be found here.

Note: If no possible way to transform sequence from startWord to targetWord return 0


Example 1:

Input:
wordList = {"des","der","dfr","dgt","dfs"}
startWord = "der", targetWord= "dfs",
Output:
3
Explanation:
The length of the smallest transformation
sequence from "der" to "dfs" is 3
i,e "der" -> "dfr" -> "dfs".

Example 2:

Input:
wordList = {"geek", "gefk"}
startWord = "gedk", targetWord= "geek", 
Output:
2
Explanation:
gedk -> geek

Example 3:

Input: 
wordList = {"poon", "plee", "same", "poie","plea","plie","poin"}
startWord = "toon", targetWord= "plea",
Output: 7 
Explanation:
toon -> poon -> poin -> poie -> plie -> plee -> plea 
 

Your Task:
You don't need to read or print anything, Your task is to complete the function wordLadderLength() which takes startWord, targetWord and wordList as input parameter and returns the length of the shortest transformation sequence from startWord to targetWord. If not possible return 0.


Expected Time Compelxity: O(N2 * M)
Expected Auxiliary Space: O(N * M) where N = length of wordList and M = |wordListi|


Constraints:
1 ≤ N ≤ 100
1 ≤ M ≤ 10

*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem701841
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        String startWord = "der";
        String targetWord = "dfs";
        String[] wordList = {"des","der","dfr","dgt","dfs"};
        System.out.println((int) clazz.getMethod("wordLadderLength", String.class, String.class, String[].class).invoke(problem, startWord, targetWord, wordList));

        System.out.println("---------------------");

        startWord = "gedk";
        targetWord = "geek";
        wordList = new String[]{"geek", "gefk"};
        System.out.println((int) clazz.getMethod("wordLadderLength", String.class, String.class, String[].class).invoke(problem, startWord, targetWord, wordList));

        System.out.println("---------------------");

        startWord = "toon";
        targetWord = "plea";
        wordList = new String[]{"poon", "plee", "same", "poie","plea","plie","poin"};
        System.out.println((int) clazz.getMethod("wordLadderLength", String.class, String.class, String[].class).invoke(problem, startWord, targetWord, wordList));
	}

	public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(wordList));
        if(!wordSet.contains(targetWord))
        {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.offer(startWord);
        visited.add(startWord);

        int level = 1;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                String curr = q.poll();
                char[] chars = curr.toCharArray();

                for(int j = 0; j < chars.length; j++)
                {
                    char originalChar = chars[j];
                    for(char c = 'a'; c <= 'z'; c++)
                    {
                        chars[j] = c;
                        String newWord = new String(chars);

                        if(newWord.equals(targetWord))
                        {
                            return level + 1;
                        }

                        if(wordSet.contains(newWord) && !visited.contains(newWord))
                        {
                            visited.add(newWord);
                            q.offer(newWord);
                        }
                    }

                    chars[j] = originalChar;
                }
            }

            level++;
        }

        return 0;
    }
}


/*
Time complexity: 
Space complexity: 
*/