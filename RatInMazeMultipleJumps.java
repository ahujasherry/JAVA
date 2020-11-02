/*
 * 
 * A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination block 
 * is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach destination. 
 * The rat can move only in two directions: forward and down.
 * In the maze matrix, 0 means the block is dead end and non-zero number means the block can be used in the path from source to destination. 
 * The non-zero value of mat[i][j] indicates number of maximum jumps rat can make from cell mat[i][j].
 * In this variation, Rat is allowed to jump multiple steps at a time instead of 1.
 * 
 */

import java.util.*;
public class RatInMazeMultipleJumps 
{
	//maze size
	static int N = 4; 
  
    static void printSolution(int sol[][])  
    { 
        for (int i = 0; i < N; i++) 
        { 
            for (int j = 0; j < N; j++)  
            { 
                System.out.printf(" %d ", sol[i][j]); 
            } 
            System.out.printf("\n"); 
        } 
    } 
  
    static boolean isSafe(int maze[][], int x, int y)  
    { 
          
        if (x >= 0 && x < N && y >= 0 &&  
             y < N && maze[x][y] != 0) 
        { 
            return true; 
        } 
  
        return false; 
    } 
  
    static boolean solveMaze(int maze[][])  
    { 
        int sol[][] = {{0, 0, 0, 0}, 
                       {0, 0, 0, 0}, 
                       {0, 0, 0, 0}, 
                       {0, 0, 0, 0}}; 
  
        if (solveMazeUtil(maze, 0, 0, sol) == false)  
        { 
            System.out.printf("Solution doesn't exist"); 
            return false; 
        } 
  
        printSolution(sol); 
        return true; 
    } 
  
    /* A recursive utility function to solve Maze problem */
    static boolean solveMazeUtil(int maze[][], int x,  
                                 int y, int sol[][])  
    { 
        // if (x, y is goal) return true  
        if (x == N - 1 && y == N - 1) 
        { 
            sol[x][y] = 1; 
            return true; 
        } 
  
        // Check if cell is valid  
        if (isSafe(maze, x, y) == true)  
        { 
  
            //include this cell in solution
        	sol[x][y] = 1; 
  
            // check right and down for each jump value and boundary condition
            for (int i = 1; i <= maze[x][y] && i < N; i++)  
            { 
  
               //down direction
            	if (solveMazeUtil(maze, x + i, y, sol) == true)  
                { 
                    return true; 
                } 
  
                //right direction in case down doesnt work
            	if (solveMazeUtil(maze, x, y + i, sol) == true)  
                { 
                    return true; 
                } 
            } 
  
            //none of solutions worked if code reache here
            sol[x][y] = 0; 
            return false; 
        }
        else
        	return false; 
    } 

	public static void main(String[] args) {
		int maze[][] = {{2, 1, 0, 0}, 
                {3, 0, 0, 1}, 
                {0, 1, 0, 1}, 
                {0, 0, 0, 1}}; 

			solveMaze(maze); 

	}

}
