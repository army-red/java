import java.io.*;
import java.util.*;

public class NumberMaze {
    /**
     * Using priority queue's minimum heap and dynamic programming to solve this
     * problem.
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            int height = Integer.parseInt(br.readLine());
            int width = Integer.parseInt(br.readLine());
            int map[][] = new int[height][width];
            int dp[][] = new int[height][width];// dynamic programming

            PriorityQueue<Cell> pq = new PriorityQueue<Cell>();
            Cell start = new Cell(0, 0, dp[0][0]);
            pq.offer(start);
            // input
            for (int i = 0; i < height; i++) {
                String input = br.readLine();
                String[] s = input.split(" ");
                for (int j = 0; j < width; j++) {
                    map[i][j] = Integer.parseInt(s[j]);
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            // start at 0,0
            dp[0][0] = map[0][0];
            // storage the relative cell up(0,1)down(0,-1)left(-1,0)right(1,0)
            int[] cellEdgeX = new int[] { 0, 0, -1, 1 };
            int[] cellEdgeY = new int[] { 1, -1, 0, 0 };

            while (!pq.isEmpty()) {
                Cell c = pq.poll();
                // System.out.println("cell c: " + c.cost);
                // if reached bottom-right break & print
                if (c.row == height - 1 && c.col == width - 1) {
                    System.out.println(dp[height - 1][width - 1]);
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int x = c.row + cellEdgeX[i];
                    int y = c.col + cellEdgeY[i];
                    // if in the edge & hasn't passed yet
                    if (x >= 0 && x < height && y >= 0 && y < width && map[x][y] + dp[c.row][c.col] < dp[x][y]) {

                        dp[x][y] = map[x][y] + dp[c.row][c.col];
                        // System.out.println("x: " + x + " y: " + y + " dp[x][y]: " + dp[x][y]);
                        pq.add(new Cell(x, y, dp[x][y]));
                    }
                }
            }
        }
    }

}

/**
 * match with priority queue
 * 
 * public PriorityQueue(int initialCapacity,
 *   Comparator<? super E> comparator) {
 *      if (initialCapacity < 1)  
 *           throw new IllegalArgumentException();
 *       this.queue = new Object[initialCapacity];
 *       this.comparator = comparator;
 *   }
 */
class Cell implements Comparable<Cell> {
    
    int cost, row, col;
    
    public Cell(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
    
    public int compareTo(Cell o) {
        return cost - o.cost;
    }
}