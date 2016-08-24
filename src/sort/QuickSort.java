package sort;
/** 
 * @author  yong.liu.sh 
 * @date 创建时间：2016年8月24日 下午3:12:49 
 * @return  
 */
public class QuickSort {

	public static void main(String[] args) {

		
	}

	public static void quickSort(int[] aa ,int length){
		if(aa == null || length == 1){
			return;
		}
		quick_sort(aa, 0, length-1);
	}
	
	public static void quick_sort(int[] aa, int start, int end){
		int i=start;
		int j=end;
		boolean flag = true;
		int tmp = aa[i];
		while(i!=j){
			if(flag){
				if(aa[j]<tmp){
					swap(aa,i,j);
					flag = false;
				}else{
					j--;
				}
			}else{
				if(aa[i]>tmp){
					swap(aa,i,j);
					flag = true;
				}else{
					i++;
				}
			}
		}
		snp(aa);
		quick_sort(aa, start, j-1);
		quick_sort(aa, i+1, end);
	}
	
	public static void swap(int[] aa,int i ,int j){
		int temp = aa[i];
		aa[j] = aa[i];
		aa[i] = temp;
	}
	
	public static void snp(int[] arrays) {
		for (int i = 0; i < arrays.length; i++) {
			System.out.print(arrays[i] + " ");
		}
		System.out.println();
	}

}
