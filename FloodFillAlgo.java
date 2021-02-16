/*
	given a color and locatin of 2d arr, go into 4 directions and if cell value == color, replace it with target color
	value of cell represents color value
	This is used in paint brush
	T.C = O(m*n) 
	there would not infinite loop without visited array as if arr[x][y]==color, then only we will replace
	Infinite loop only when color==target color. But then no need to change the matrix

*/
class Pair implements Comparable<Pair> 
{
    int first;
    int second;
 
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
 
    @Override
    public int compareTo(Pair o) {
        return second - o.second;
    }
}

class FloodFillAlgo
{
 
// Dimentions of paint screen
static int M = 8;
static int N = 8;
 

static void floodFillUtil(int screen[][], int x, int y, 
                                    int givenColor, int target)
{
    // Base cases
    if (x < 0 || x >= M || y < 0 || y >= N)
        return;
    
    if (screen[x][y] != givenColor)
        return;
 
    // Replace the color at (x, y)
    screen[x][y] = target;
 
    // Recur for north, east, south and west
    floodFillUtil(screen, x+1, y, givenColor, target);
    floodFillUtil(screen, x-1, y, givenColor, target);
    floodFillUtil(screen, x, y+1, givenColor, target);
    floodFillUtil(screen, x, y-1, givenColor, target);
}
 
//Recursion
static void floodFill(int screen[][], int x, int y, int target)
{
    int givenColor = screen[x][y];
    floodFillUtil(screen, x, y, givenColor, target);
}


//BFS using Queue
public static int validCoord(int x, int y, int n, int m)
{
        if (x < 0 || y < 0) {
            return 0;
        }
        if (x >= n || y >= m) {
            return 0;
        }
        return 1;
}


//BFS approach
public static void bfs(int n, int m, int data[][],int x, int y, int color)
    {
   
        // Visiing array
         int vis[][]=new int[101][101];
         
        // Initialing all as zero
        for(int i=0;i<=100;i++){
            for(int j=0;j<=100;j++){
                vis[i][j]=0;
            }
        }
         
        // Creating queue for bfs
         Queue<Pair> obj = new LinkedList<>();
   
        // Pushing pair of {x, y}
         Pair pq=new Pair(x,y);
         obj.add(pq);
          
        // Marking {x, y} as visited
         vis[x][y] = 1;
   
        // Untill queue is emppty
        while (!obj.isEmpty()) 
        {
            // Extrating front pair
            Pair coord = obj.peek();
            int x1 = coord.first;
            int y1 = coord.second;
            int preColor = data[x1][y1];
             
            data[x1][y1] = color;
     
            // Poping front pair of queue
            obj.remove();
 
            // For Upside Pixel or Cell
            if ((validCoord(x1 + 1, y1, n, m)==1) && vis[x1 + 1][y1] == 0 && data[x1 + 1][y1] == preColor)
            {
                Pair p=new Pair(x1 +1, y1);
                obj.add(p);
                vis[x1 + 1][y1] = 1;
            }
     
            // For Downside Pixel or Cell
            if ((validCoord(x1 - 1, y1, n, m)==1) && vis[x1 - 1][y1] == 0 && data[x1 - 1][y1] == preColor) 
            {
                Pair p=new Pair(x1-1,y1);
                obj.add(p);
                vis[x1- 1][y1] = 1;
            }
     
            // For Right side Pixel or Cell
            if ((validCoord(x1, y1 + 1, n, m)==1) && vis[x1][y1 + 1] == 0 && data[x1][y1 + 1] == preColor) 
            {
                Pair p=new Pair(x1,y1 +1);
                obj.add(p);
                vis[x1][y1 + 1] = 1;
            }
     
            // For Left side Pixel or Cell
            if ((validCoord(x1, y1 - 1, n, m)==1) && vis[x1][y1 - 1] == 0 && data[x1][y1 - 1] == preColor) 
            {
                Pair p=new Pair(x1,y1 -1);
                obj.add(p);
                vis[x1][y1 - 1] = 1;
            }
        }
   
    }
 
public static void main(String[] args) 
{
    int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 0, 0},
                    {1, 0, 0, 1, 1, 0, 1, 1},
                    {1, 2, 2, 2, 2, 0, 1, 0},
                    {1, 1, 1, 2, 2, 0, 1, 0},
                    {1, 1, 1, 2, 2, 2, 2, 0},
                    {1, 1, 1, 1, 1, 2, 1, 1},
                    {1, 1, 1, 1, 1, 2, 2, 1},
                    };
    int x = 4, y = 4, target = 3;
    floodFill(screen, x, y, target);
 
    System.out.println("Updated screen after call to floodFill: ");
    for (int i = 0; i < M; i++)
    {
        for (int j = 0; j < N; j++)
        System.out.print(screen[i][j] + " ");
        System.out.println();
    }
    }
}
 