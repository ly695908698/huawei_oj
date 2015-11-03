package hw_2015_10_29;

import java.util.Scanner ;

/**
 * 字符串最后一个单词的长度
 * 描述	
计算字符串最后一个单词的长度，单词以空格隔开。
知识点	字符串,循环
运行时间限制	0M
内存限制	0
输入	
一行字符串，长度小于128。
输出	
整数N，最后一个单词的长度。
样例输入	hello world
样例输出	5
 * @author Administrator
 *
 */

public class word_length {

    public static int LastWordLength(String str){
        String[] strs = str.split(" " );
        return strs[strs. length-1 ].length();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System. in);
        System.out.println(LastWordLength (scan.nextLine()));
    }
}
