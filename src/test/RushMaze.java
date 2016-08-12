package test;
/**
 * 闯迷宫
描述:	
sun所在学校每年都要举行电脑节，今年电脑节有一个新的趣味比赛项目叫做闯迷宫。
sun的室友在帮电脑节设计迷宫，所以室友就请sun帮忙计算下走出迷宫的最少步数。
知道了最少步数就可以辅助控制比赛难度以及去掉一些没有路径到达终点的map。
比赛规则是：从原点（0,0）开始走到终点（n-1,n-1），只能上下左右4个方向走，只能在给定的矩阵里走。
运行时间限制:	10 Sec
内存限制:	128 MByte
输入:	
输入有多组数据。
﻿
每组数据输入n（0<n<=100），然后输入n*n的0、1矩阵，0代表该格子没有障碍，为1表示有障碍物。
注意：如果输入中的原点和终点为1则这个迷宫是不可达的。
输出:	
对每组输入输出该迷宫的最短步数，若不能到达则输出-1。
样例输入:	
2
0 1
0 0
5
0 0 0 0 0
1 0 1 0 1
0 0 0 0 0
0 1 1 1 0
1 0 1 0 0
样例输出:	
2
8

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


 */
/** 
 * @author  yong.liu.sh 
 * @date 创建时间：2016年8月12日 下午3:00:40 
 * @return  https://www.nowcoder.com/search?type=question&query=%E8%BF%B7%E5%AE%AB
 */
public class RushMaze {

	// write your code here
	import java.util.*;
	import java.util.Scanner;
	import java.util.concurrent.ArrayBlockingQueue;
	 
	public class Main {
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
	        Queue<Point> queue = null;
	        queue = new ArrayBlockingQueue<Point>(100);
	        Point start = new Point(0, 1,0);
	        queue.add(start);
	        visited[0][1] = true;
	        while(!queue.isEmpty()){
	            Point p = queue.poll();
	            int x = p.x;
	            int y = p.y;
	            int step = p.step;
	            if( x == 9 && y == 8)
	                return step;
	            // 不是第一行
	            if (x != 0 && data[x - 1][y] != 1 && !visited[x-1][y]){
	                queue.add(new Point(x - 1, y,step+1));
	                visited[x-1][y] = true;
	            }
	            // 不是第一列
	            if (y != 0 && data[x][y-1] != 1 && !visited[x][y-1]){
	                queue.add(new Point(x, y - 1,step+1));
	                visited[x][y-1] = true;
	            }
	            // 不是最后一行
	            if (x != 9 && data[x +1][y] != 1 && !visited[x+1][y]){
	                queue.add(new Point(x + 1, y,step+1));
	                visited[x+1][y] = true;
	            }
	                 
	            // 不是最后一列
	            if (y != 9 && data[x][y+1] != 1 && !visited[x][y+1]){
	                queue.add(new Point(x, y+1,step+1));
	                visited[x][y+1] = true;
	            }
	        }
	        return 0;
	    }
	}
	 
	class Point {
	    int x;
	    int y;
	    int step;
	    public Point(int x, int y,int step) {
	        this.x = x;
	        this.y = y;
	        this.step = step;
	    }
	}


}
