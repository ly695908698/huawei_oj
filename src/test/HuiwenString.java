package test;

import java.util.Scanner;

/** 
 * @author  yong.liu.sh 
 * @date 创建时间：2016年8月1日 下午3:29:11 
 * @return  
 */
public class HuiwenString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan  =new Scanner(System.in);
		while(scan.hasNext()){
			System.out.println(deleteCharNum(scan.nextLine()));
		}
		 scan.close();
	}
	
	private static int deleteCharNum(String words){
		return lengthOfLCS(words, new StringBuffer(words).reverse().toString());
	}
	
	//动态规划求最长公共子序列的长度
	private static int lengthOfLCS(String str1, String str2){
		char[] s1=str1.toCharArray();
		char[] s2=str2.toCharArray();
		int len1=str1.length();
		int len2=str2.length();
				
		int[][] table=new int[len1][len2];
		if(s1[0]==s2[0]){
			table[0][0]=1;
		}
		
		//单独计算s1的首字母与s2的lcs长度
		for(int i=1;i<len1;++i){
			if(s1[0]==s2[i]){
				table[0][i]=1;
			}else{
				table[0][i]=table[0][i-1];
			}
		}
		
		//单独计算s2的首字母与s1的lcs长度
		for(int i=1;i<len1;++i){
			if(s2[0]==s1[i]){
				table[i][0]=1;
			}else{
				table[i][0]=table[i-1][0];
			}
		}
		
		//递推求解各个字符处的LCS
		for(int i=1;i<len1;++i){
			for(int j=1;j<len2;++j){
				if(s1[i]==s2[j]){
					table[i][j]=table[i-1][j-1]+1;
				}else{
					table[i][j]=table[i-1][j]>table[i-1][j]?table[i-1][j]:table[i-1][j];
				}
			}
		}
		return table[len1-1][len2-1];
	}

}
