package hw_2015_10_30;

/**
背包衍生的金矿问题
输入	
输入的第 1 行，为两个正整数，用一个空格隔开：N m
（其中 N （ <10000 ）表示总人数， m （ <100 ）为金矿的个数。）
从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的金矿的基本数据，每行有 2 个非负整数
 v p （其中 v 表示该金矿开采所需的人数（ v<10000 ）， p 表示该金矿开采出来的金矿值（ 1 ~ 100 ）
输出	
 输出所能开采到的最大金矿值。
样例输入	
100 5 
77 92  
22 22
29 87
50 46
99 90
样例输出	
133
 * @author Administrator
 *
 */
public class Max_Bags {
	int max_n=100;
	int max_people=10000;
	
	static int n=5;
	static int totalPeople=100;
	int peopleNeed[]={77, 22, 29, 50, 99};
	int gold[]={92, 22, 87, 46, 90};
	int [][]maxGold=new int[max_people][max_n];
	
	//初始化数组
	public void init(){
		for(int i=0;i<max_people;i++){
			for(int j=0;j<n;j++){
				maxGold[i][j]=-1;
			}
		}
	}
	
	//在仅有people个人,num个金矿下所能获得的最大金子数
	public int getMaxValue(int people, int num){
		int max_Gold=0;
		if(maxGold[people][num] != -1){
			max_Gold = maxGold[people][num];
		}else if(num==0){
			if(people>peopleNeed[num]){
				max_Gold=gold[num];
			}else{
				max_Gold=0;
			}
		}else if(people>peopleNeed[num]){
			max_Gold=Math.max(getMaxValue(people-peopleNeed[num], num-1) + gold[num], getMaxValue(people, num-1));
		}else{
			getMaxValue(people, num-1);
		}
		maxGold[people][num] = max_Gold;
		
		return max_Gold;
	}

	public static void main(String[] args) {
		Max_Bags test = new Max_Bags();
		test.init();
		System.out.println("----" + test.getMaxValue(totalPeople, n - 1));

	}
 
}
