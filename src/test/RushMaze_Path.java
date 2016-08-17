package test;
/**
 [编程题]迷宫问题
定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示： 

int maze[5][5] = {
        0, 1, 0, 0, 0,
        0, 1, 0, 1, 0,
        0, 0, 0, 0, 0,
        0, 1, 1, 1, 0,
        0, 0, 0, 1, 0,
};

它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。
Input
一个N × M的二维数组，表示一个迷宫。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
Output
左上角到右下角的最短路径，格式如样例所示。
Sample Input
0 1 0 0 0
0 1 0 1 0
0 0 0 0 0
0 1 1 1 0
0 0 0 1 0
Sample Output
(0, 0)
(1, 0)
(2, 0)
(2, 1)
(2, 2)
(2, 3)
(2, 4)
(3, 4)
(4, 4)
 
 输入描述:
输入两个整数，分别表示二位数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。

输出描述:
左上角到右下角的最短路径，格式如样例所示。

输入例子:
5 5
0 1 0 0 0
0 1 0 1 0
0 0 0 0 0
0 1 1 1 0
0 0 0 1 0

输出例子:

(0,0)
(1,0)
(2,0)
(2,1)
(2,2)
(2,3)
(2,4)
(3,4)
(4,4)

/** 
 * @author  yong.liu.sh 
 * @date 创建时间：2016年8月12日 下午3:00:40 
 * @return  https://www.nowcoder.com/search?type=question&query=%E8%BF%B7%E5%AE%AB
 */

// write your code here
import java.util.*;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class RushMaze_Path {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] data = new int[n][m];
		while (sc.hasNext()) {
			for(int i=0;i<n;i++){
				for(int j =0;j<m;j++){
					data[i][j] = sc.nextInt();
				}
			}
			bfs(data,n,m);
		}
	}

	public static void print(Point point){
		if(point == null){
			return;
		}
		print(point.pre);
		System.out.println(point.toString());
	}

	public static void bfs(int[][] data,int n, int m) {
		boolean[][] visited = new boolean[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(data[i][j]==1){
					visited[i][j]=true;
					continue;
				}
				visited[i][j]=false;
			}
		}
		Queue<Point> queue = new ArrayBlockingQueue<>(n*m);
		Point start = new Point(0,0,1,null);
		queue.add(start);
		while(!queue.isEmpty()){
			Point point = queue.poll();
			int x = point.x;
			int y = point.y;
			int step = point.step;
			
			if(x==n-1 && y==m-1){
				print(point);
				return;
			}
			//上
			if(x!=0 && !visited[x-1][y] && data[x-1][y]==0){
				queue.add(new Point(x-1, y, step+1,point));
				visited[x-1][y] = true;
			}
			//下
			if(x!=n-1 && !visited[x+1][y] && data[x+1][y]==0){
				queue.add(new Point(x+1, y, step+1,point));
				visited[x+1][y] = true;
			}
			//左
			if(y!=0 && !visited[x][y-1] && data[x][y-1]==0){
				queue.add(new Point(x, y-1, step+1,point));
				visited[x][y-1] = true;
			}
			//右
			if(y!=m-1 && !visited[x][y+1] && data[x][y+1]==0){
				queue.add(new Point(x, y+1, step+1,point));
				visited[x][y+1] = true;
			}
		}
	}
}

class Point {
	int x;
	int y;
	int step;
	Point pre;
	public Point(int x, int y,int step, Point pre) {
		this.x = x;
		this.y = y;
		this.step = step;
		this.pre = pre;
	}
	@Override
	public String toString() {
		return "("+ x + "," + y + ")";
	}
	
}