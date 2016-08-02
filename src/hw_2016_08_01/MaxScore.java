package hw_2016_08_01;

import java.util.Scanner;

/** 
 * @author  yong.liu.sh 
 * @date 创建时间：2016年8月1日 下午5:30:17 
 * @return  
 */

/**
 * [编程题] 最高分是多少
老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩. 
输入描述:
输入包括多组测试数据。
每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
学生ID编号从1编到N。
第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。


输出描述:
对于每一次询问操作，在一行里面输出最高成绩.

输入例子:
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5

输出例子:
5
6
5
9
 *
 */
public class MaxScore {

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		
		while (scan.hasNext()) {
			String nm=scan.nextLine();
			String[] temp=nm.split(" ");
			int N=Integer.parseInt(temp[0]);
			int M=Integer.parseInt(temp[1]);

			String scores=scan.nextLine();
			String[] temp2=scores.split(" ");

			int[] score =new int[N+1];
			int i=1;
			while(i<=N){
				score[i] = Integer.parseInt(temp2[i-1]);
				i++;
			}

			int j=0;
			String[] ops=new String[M];
			while(j<M){
				ops[j]=scan.nextLine();
				j++;
			}

			j=0;
			while(j<M){
				String[] operations=ops[j].split(" ");
				if(operations[0].equals("Q")){
					System.out.println(maxScore(score, Integer.parseInt(operations[1]), Integer.parseInt(operations[2])));
				}else{
					updateScore(score, Integer.parseInt(operations[1]), Integer.parseInt(operations[2]));
				}
				j++;
			}
		}
			
	}
	
	private static void updateScore(int[] scores, int id, int score){
		scores[id]=score;
	}
	
	private static int maxScore(int[] scores, int begin, int end){
		if(begin>end){
			int temp=begin;
			begin=end;
			end=temp;
		}
		int max=scores[begin];
		for(int i=begin;i<=end;i++){
			if(max<scores[i]){
				max=scores[i];
			}
		}
		return max;	
	}

}
