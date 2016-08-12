package test;

import java.util.Scanner;

/**
 * 循环移动
描述:	
有10个整数，使前面各数顺序向后移m个位置，最后m个数变成最前面m个数。
计算移动后的整数序列的前m个和后m个数的和。
 
运行时间限制:	无限制
内存限制:	无限制
输入:	
先输入10个整数，以空格分隔；
再输入移动个数（即整数m）。
输出:	
移动后的整数序列。
移动后的整数序列的前m个和后m个数的和。
样例输入:	
1 2 3 4 5 6 7 8 9 10
3
样例输出:	
8 9 10 1 2 3 4 5 6 7
27 18

 */
/** 
 * @author  yong.liu.sh 
 * @date 创建时间：2016年8月12日 上午10:45:54 
 * @return  
 */
public class LoopMove {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int arr[] = new int[10];
			for(int i=0;i<10;i++){
				arr[i] = scan.nextInt();
			}
			int index = 10-scan.nextInt()%10;
			int[] move = new int[10];
			int j=index;
			int x=0;
			while(j<10){
				System.out.print(arr[j]+" ");
				move[x]=arr[j];
				j++;
				x++;
			}
			j=0;
			while(j<index){
				System.out.print(arr[j]+" ");
				move[x]=arr[j];
				j++;
				x++;
			}
			int first = 0,last=0;
			for(int y=0;y<10-index;y++){
				first+=move[y];
				last+=move[9-y];
			}
			System.out.println("\n"+first+" "+last);
		}

	}

}
