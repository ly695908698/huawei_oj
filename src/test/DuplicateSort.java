package test;

/**
 * [编程题] 明明的随机数
明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作。
 
Input Param 
     n               输入随机数的个数     
 inputArray      n个随机整数组成的数组 
     
Return Value
     OutputArray    输出处理后的随机整数
 
注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。

输入描述:
输入多行，先输入随机整数的个数，再输入相应个数的整数


输出描述:
返回多行，处理后的结果

输入例子:
11
10
20
40
32
67
40
20
89
300
400
15

输出例子:
10
15
20
32
40
67
89
300
400
 */
/** 
 * @author  yong.liu.sh 
 * @date 创建时间：2016年8月8日 下午8:09:17 
 * @return  
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
public class DuplicateSort {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int n = scan.nextInt();
			if(n==0){
				break;
			}
			Set<Integer> set=new HashSet<Integer>();
			for(int i=0;i<n;i++){
				set.add(scan.nextInt());
			}
			List<Integer> list = new ArrayList<>(set);
			Collections.sort(list);
			for(Integer j:list){
				System.out.println(j);
			}
		}
		scan.close();
	}

}
