/*
Word Ladder

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.

*/

package ds.leetCode;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem127
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        String startWord = "hit";
        String targetWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println((int) clazz.getMethod("ladderLength", String.class, String.class, List.class).invoke(problem, startWord, targetWord, wordList));

        System.out.println("---------------------");

        startWord = "hit";
        targetWord = "cog";
        wordList = Arrays.asList("hot","dot","dog","lot","log");
        System.out.println((int) clazz.getMethod("ladderLength", String.class, String.class, List.class).invoke(problem, startWord, targetWord, wordList));
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))
        {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(beginWord);
        visited.add(beginWord);

        int level = 1;
        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0; i < size; i++)
            {
                String word = q.poll();
                char[] chars = word.toCharArray();

                for(int j = 0; j < chars.length; j++)
                {
                    char originalChar = chars[j];

                    for(char c = 'a'; c <= 'z'; c++)
                    {
                        chars[j] = c;
                        String newWord = new String(chars);

                        if(newWord.equals(endWord))
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