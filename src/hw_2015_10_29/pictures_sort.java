package hw_2015_10_29;

import java.util.List;
import java.util.Scanner;

/**
 * 描述	
Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过C语言解决。
知识点	字符串
运行时间限制	0M
内存限制	0
输入	
Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
输出	
Lily的所有图片按照从小到大的顺序输出
样例输入	Ihave1nose2hands10fingers
样例输出	0112Iaadeeefghhinnnorsssv
 * @author Administrator
 */
public class pictures_sort {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System. in);
		String pictures = scan.nextLine();
		char arr[]=pictures.toCharArray();
		String digital="";
		String words="";
		String words2="";
		for(int i=0;i<arr.length;i++){
			if(arr[i]>='0'&&arr[i]<='9'){
				digital+=arr[i];
			}else if(arr[i]>='A'&&arr[i]<='Z'){
				words2+=arr[i];
			}else{
				words+=arr[i];
			}
		}
		System.out.print(sort(digital)+sort(words2)+sort(words));
	}
	
	private static String sort(String hello){
		char arr[]=hello.toCharArray();
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					char temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
		}
		return String.valueOf(arr);
	}

}
