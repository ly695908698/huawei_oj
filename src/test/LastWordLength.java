package test;

/**
 * 题目描述

计算字符串最后一个单词的长度，单词以空格隔开。

输入描述:
一行字符串，非空，长度小于5000。


输出描述:
整数N，最后一个单词的长度。

输入例子:
hello world

输出例子:
5
 */
/** 
 * @author  yong.liu.sh 
 * @date 创建时间：2016年8月10日 下午6:00:46 
 * @return  
 */
import java.util.Scanner;
public class LastWordLength {

	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		while(scan.hasNext()){
			String words = scan.nextLine();
			String[] word = words.split(" ");
			System.out.println(word[word.length-1].length());
		}

	}

}
