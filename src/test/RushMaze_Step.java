package test;
/**
 [编程题]走迷宫
NowCoder最喜欢游乐场的迷宫游戏，他和小伙伴们比赛谁先走出迷宫。
现在把迷宫的地图给你，你能帮他算出最快走出迷宫需要多少步吗？

输入描述:
输入包含多组数据。
每组数据包含一个10*10，由“#”和“.”组成的迷宫。其中“#”代表墙；“.”代表通路。
入口在第一行第二列；出口在最后一行第九列。
从任意一个“.”点都能一步走到上下左右四个方向的“.”点。

输出描述:
对应每组数据，输出从入口到出口最短需要几步。

输入例子:
#.########
#........#
#........#
#........#
#........#
#........#
#........#
#........#
#........#
########.#
#.########
#........#
########.#
#........#
#.########
#........#
########.#
#........#
#.######.#
########.#

输出例子:
16
30

/** 
 * @author  yong.liu.sh 
 * @date 创建时间：2016年8月12日 下午3:00:40 
 * @return  https://www.nowcoder.com/search?type=question&query=%E8%BF%B7%E5%AE%AB
 */

//write your code here
	import java.util.*;
	import java.util.Scanner;
	import java.util.concurrent.ArrayBlockingQueue;
	 
	public class RushMaze_Step {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        while (sc.hasNext()) {
	            int[][] data = new int[10][10];
	            for (int i = 0; i < 10; i++) {
	                String str = sc.nextLine();
	                for (int j = 0; j < 10; j++) {
	                    //System.out.print(str.charAt(j) + " ");
	                    switch (str.charAt(j)) {
	                    case '.':
	                        // 可通行
	                        data[i][j] = 0;
	                        break;
	                    case '#':
	                        // 不可通行
	                        data[i][j] = 1;
	                        break;
	                    }
	                }
	            }
	            System.out.println(bfs(data));
	        }
	    }
	 
	    public static int bfs(int[][] data) {
	        int n = data.length;
	        boolean[][] visited = new boolean[n][n];
	        for(int i = 0;i<n;i++){
	            for(int j = 0;j<n;j++){
	                if(data[i][j] == 1){
	                    visited[i][j] = true;
	                    continue;
	                }  
	                visited[i][j] = false;
	            }
	        }
	        Queue<Point_2> queue = null;
	        queue = new ArrayBlockingQueue<Point_2>(100);
	        Point_2 start = new Point_2(0, 1,0);
	        queue.add(start);
	        visited[0][1] = true;
	        while(!queue.isEmpty()){
	        	Point_2 p = queue.poll();
	            int x = p.x;
	            int y = p.y;
	            int step = p.step;
	            if( x == 9 && y == 8)
	                return step;
	            // 不是第一行
	            if (x != 0 && data[x - 1][y] != 1 && !visited[x-1][y]){
	                queue.add(new Point_2(x - 1, y,step+1));
	                visited[x-1][y] = true;
	            }
	            // 不是第一列
	            if (y != 0 && data[x][y-1] != 1 && !visited[x][y-1]){
	                queue.add(new Point_2(x, y - 1,step+1));
	                visited[x][y-1] = true;
	            }
	            // 不是最后一行
	            if (x != 9 && data[x +1][y] != 1 && !visited[x+1][y]){
	                queue.add(new Point_2(x + 1, y,step+1));
	                visited[x+1][y] = true;
	            }
	                 
	            // 不是最后一列
	            if (y != 9 && data[x][y+1] != 1 && !visited[x][y+1]){
	                queue.add(new Point_2(x, y+1,step+1));
	                visited[x][y+1] = true;
	            }
	        }
	        return 0;
	    }
	}
	 
	class Point_2 {
	    int x;
	    int y;
	    int step;
	    public Point_2(int x, int y,int step) {
	        this.x = x;
	        this.y = y;
	        this.step = step;
	    }
	}


