/*
Flood fill Algorithm

You are given a 2D grid image[][] of size n*m, where each image[i][j] represents the color of a pixel in the image. Also provided a coordinate(sr, sc) representing the starting pixel (row and column) and a new color value newColor.

Your task is to perform a flood fill starting from the pixel (sr, sc), changing its color to newColor and the color of all the connected pixels that have the same original color. Two pixels are considered connected if they are adjacent horizontally or vertically (not diagonally) and have the same original color.

Examples:

Input: image[][] = [[1, 1, 1, 0], [0, 1, 1, 1], [1, 0, 1, 1]], sr = 1, sc = 2, newColor = 2

Output: [[2, 2, 2, 0], [0, 2, 2, 2], [1, 0, 2, 2]]

Explanation: Starting from pixel (1, 2) with value 1, flood fill updates all connected pixels (up, down, left, right) with value 1 to 2, resulting in [[2, 2, 2, 0], [0, 2, 2, 2], [1, 0, 2, 2]].

Input: image[][] = [[1, 1, 1], [1, 1, 0], [1, 0, 1]], sr = 1, sc = 1, newColor = 2
Output: [[2, 2, 2], [2, 2, 0], [2, 0, 1]]
Explanation: From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected by a path of the same color as the starting pixel are colored with the new color.Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

Input: image[][] = [[0, 1, 0], [0, 1, 0]], sr = 0, sc = 1, newColor = 0
Output: [[0, 0, 0], [0, 0, 0]]
Explanation: Starting from pixel (0, 1) with value 1, flood fill changes all 4-directionally connected pixels with value 1 to 0, resulting in [[0, 0, 0], [0, 0, 0]]

Constraints:
1 ≤ n ≤ m ≤ 500
0 ≤ image[i][j] ≤ 10
0 ≤ newColor ≤ 10
0 ≤ sr ≤ (n-1)
0 ≤ sc ≤ (m-1)
*/

package ds.geeksForGeeks;

import java.util.*;
import utils.*;
import java.lang.reflect.Constructor;

public class Problem705720
{
	public static void main(String args[]) throws Exception
	{

		Class<?> clazz = new Object() {}.getClass().getEnclosingClass();

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object problem = constructor.newInstance();

        int[][] image = {{1, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        int sr = 1;
        int sc = 2;
        int newColor = 2;
        ArrayUtils.print(((int[][]) clazz.getMethod("floodFill", int[][].class, int.class, int.class, int.class).invoke(problem, image, sr, sc, newColor)), image.length, image[0].length);

        System.out.println("------------------------------------------");

        image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        sr = 1;
        sc = 1;
        newColor = 2;
        ArrayUtils.print(((int[][]) clazz.getMethod("floodFill", int[][].class, int.class, int.class, int.class).invoke(problem, image, sr, sc, newColor)), image.length, image[0].length);

        System.out.println("------------------------------------------");

        image = new int[][]{{0, 1, 0}, {0, 1, 0}};
        sr = 0;
        sc = 1;
        newColor = 0;
        ArrayUtils.print(((int[][]) clazz.getMethod("floodFill", int[][].class, int.class, int.class, int.class).invoke(problem, image, sr, sc, newColor)), image.length, image[0].length);
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(newColor == oldColor)
        {
            return image;
        }
        dfs(image, sr, sc, newColor, oldColor);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int newColor, int oldColor)
    {
        int rows = image.length;
        int columns = image[0].length;
        if(r >= 0 && r < rows && c >= 0 && c < columns && image[r][c] == oldColor)
        {
            image[r][c] = newColor;

            dfs(image, r + 1, c, newColor, oldColor);
            dfs(image, r - 1, c, newColor, oldColor);
            dfs(image, r, c + 1, newColor, oldColor);
            dfs(image, r, c - 1, newColor, oldColor);
        }
    }
}


/*
Time complexity: 
Space complexity: 
*/