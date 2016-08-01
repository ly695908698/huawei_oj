package hw_2015_10_30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * @author  yong.liu.sh 
 * @date 创建时间：2016年4月13日 下午4:16:50 
 * @return  
 */
public class test {
	 static List<aaa> poiDOs = new ArrayList<aaa>();
	 
	public static void main(String[] args) {
		
		 aaa a1=new aaa(45, 515);
		 aaa a2=new aaa(45, 291);
		 aaa a3=new aaa(50, 12);
		 aaa a4=new aaa(45, 0);
		 poiDOs.add(a1);
		 poiDOs.add(a2);
		 poiDOs.add(a3);
		 poiDOs.add(a4);
		 
		 //按订单量降序排列
        Collections.sort(poiDOs, new Comparator<aaa>() {
            @Override
            public int compare(aaa o1, aaa o2) {
                return o2.getNum() - o1.getNum();
            }
        });
        
        //按订星级降序
        Collections.sort(poiDOs, new Comparator<aaa>() {
            @Override
            public int compare(aaa o1, aaa o2) {
                return o2.getStar() - o1.getStar();
            }
        });
		
	}

}

class aaa{
	int star = 0;
	int num = 0;
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public aaa(int star, int num) {
		super();
		this.star = star;
		this.num = num;
	}
	
	
}
