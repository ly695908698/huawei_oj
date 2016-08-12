package test;

import java.util.Scanner;

/**
 * 字符串查找
描述:	
输入两个字符串，查找字符串1中与字符串2最先匹配的内容，将匹配的字符串输出。字符串2支持?通配符，?代表任意一个字符。 
已知字符串2不可能出现只有?的情况。 字符串1和字符串2的最大长度为128。
 
运行时间限制:	无限制
内存限制:	无限制
输入:	
待查找字符串,关键字字符串
输出:	
输出字符串
样例输入:	
abcdefabcdeg,a?c??f
样例输出:	
abcdef

 */
/** 
 * @author  yong.liu.sh 
 * @date 创建时间：2016年8月12日 上午11:47:20 
 * @return  
 */
public class StringFind {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String[] ss = scan.nextLine().split(",");
			String s1 = ss[0];
			String s2 = ss[1];
			StringBuffer bf = new StringBuffer();
			int first = 0;
			int i = 0; 
			for(i=0;i<s1.length();i++){
				first = s2.indexOf(s1.charAt(i))>s2.indexOf('?')?s2.indexOf('?'):s2.indexOf(s1.charAt(i));
				if(first!=-1){
					break;
				}
			}
			for(;first<s2.length();first++,i++){
				if(s1.charAt(i)==s2.charAt(first) || s2.charAt(first)=='?'){
					bf.append(s1.charAt(i));
				}else{
					break;
				}
			}
			System.out.println(bf.toString());
		}

	}

}
