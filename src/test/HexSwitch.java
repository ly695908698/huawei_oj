package test;


/**
 * [编程题] 进制转换
写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）

输入描述:
输入一个十六进制的数值字符串。

输出描述:
输出该数值的十进制字符串。

输入例子:
0xA

输出例子:
10
 */
/** 
 * @author  yong.liu.sh 
 * @date 创建时间：2016年8月8日 下午8:26:27 
 * @return  
 */
import java.util.Scanner;
public class HexSwitch {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String num = scan.nextLine();
			char[] chars=num.toCharArray();
			int result = 0;
			for(int i=2;i<chars.length;i++){
				result += Math.pow(16, chars.length - i - 1)*count(chars[i]);
			}
			System.out.println(result);
		}
	}
	
	private static int count(char c){
		String hex="ABCDEF";
		return hex.indexOf(c)==-1?Integer.parseInt(c+""):hex.indexOf(c)+10;
	}

}
