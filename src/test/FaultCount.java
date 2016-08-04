package test;


/** 
 * @author  yong.liu.sh 
 * @date 创建时间：2016年8月3日 下午12:57:07 
 * @return  
 */

/**
 * [编程题]简单错误记录
开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。 
处理:
1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；
(文件所在的目录不同，文件名和行号相同也要合并)
2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
3.输入的文件可能带路径，记录文件名称不能带路径

输入描述:
一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
    文件路径为windows格式
    如：E:\V1R2\product\fpgadrive.c 1325

输出描述:
将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1 
    结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。
    如果超过8条记录，则只输出前8条记录.
    如果文件名的长度超过16个字符，则只输出后16个字符

输入例子:
E:\V1R2\product\fpgadrive.c 1325

输出例子:
fpgadrive.c 1325 1
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
public class FaultCount {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Set<ErrorFile> set =new HashSet<ErrorFile>();
		int j=0;
		while(scan.hasNext()){
			ErrorFile file = new ErrorFile();
			String temp=scan.next();
			if(temp.equals("exit")){
				scan.close();
				break;
			}else{
			
			file.name = temp.substring(temp.lastIndexOf("\\")+1);
			int errorLine=scan.nextInt();
			file.line = errorLine;
			if(set.add(file)){
				file.count++;
				file.order=j;
				j++;
			}
			}
		}
		
		
		Comparator<ErrorFile> com = new Comparator<ErrorFile>() {
			@Override
			public int compare(ErrorFile o1, ErrorFile o2) {
				return o1.count != o2.count ? o2.count - o1.count : o1.order - o2.order;
			}
		};
		
		List<ErrorFile> list = new ArrayList<ErrorFile>(set);
		Collections.sort(list, com);
		
		StringBuffer br = new StringBuffer();
		 for(int i = 0; i < (list.size() > 8 ? 8 : list.size()); i ++){
			 ErrorFile file = list.get(i);
			if(file.name.length() > 16){
				br = new StringBuffer(file.name.substring(file.name.length()-16, file.name.length()));
			}else{
				br = new StringBuffer(file.name);
			}
			br.append(" ").append(file.line).append(" ").append(file.count);
			System.out.println(br);
		}
		
	}
	
	
	static class ErrorFile{
		String name;
		int line;
		int count;
		int order;
		@Override
		public int hashCode() {
			final int prime = 31;
			return line*prime + count*prime + name.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			ErrorFile file = (ErrorFile)obj;
			if(!this.name.equals(file.name)){
				return false;
			}
			if(this.line != file.line){
				return false;
			}
			file.count ++;
			return true;
		}
	}
	
}
