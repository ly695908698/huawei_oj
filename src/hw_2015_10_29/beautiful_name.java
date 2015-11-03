package hw_2015_10_29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 描述	
给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
给出多个名字，计算每个名字最大可能的“漂亮度”。
知识点	字符串
运行时间限制	0M
内存限制	0
输入	
整数N，后续N个名字
N个字符串，每个表示一个名字

输出	
每个名称可能的最大漂亮程度
样例输入	2 zhangsan lisi
样例输出	192 101
 * @author Administrator
 *
 */
public class beautiful_name {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		String arr[]=new String[num];
		for(int i=0;i<num;i++){
			arr[i]=scan.next();
		}
		
		for(int i=0;i<num;i++){
			beautiful_Num(arr[i].trim());
		}
	}
	
	private static void beautiful_Num(String name){
		char arr[]=name.toCharArray();
		Map<Character, Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++){
			char a=arr[i];
			if(map.get(a)!=null){
				int num = (int)map.get(a);
				map.put(a,++num);
			}else{
				map.put(a,1);
			}
		}
		ArrayList<Integer> nums=new ArrayList<>();
		for(Entry<Character, Integer> entry:map.entrySet()){
			nums.add(entry.getValue());
		}
		Integer[] numss=(Integer[]) nums.toArray(new Integer[nums.size()]);
		sort(numss);
		int number=0;
		for(int i=nums.size()-1;i>=0;i--){
			number+=numss[i]*(26-(nums.size()-i)+1);
		}
		System.out.println(number);
	}
	
	private static Integer[] sort(Integer arr[]){
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
		}
		return arr;
	}

}
