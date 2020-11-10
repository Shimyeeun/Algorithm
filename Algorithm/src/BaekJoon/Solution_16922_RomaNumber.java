package BaekJoon;
import java.util.*;
import java.io.*;
public class Solution_16922_RomaNumber {
	public static int m,cnt=0;
	public static int[] d= {1,5,10,50},a;
	public static HashSet<Integer> set;
	public static void comb(int start,int count) {
		if(count==m) {
			int sum=0;
			for(int i=0;i<m;i++) {
				sum=sum+a[i];
			}
			set.add(sum);
			return;
		}
		for(int i=start;i<4;i++) {
			a[count]=d[i];
			comb(i,count+1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		m=Integer.parseInt(br.readLine());
		set=new HashSet<>();		
		a=new int[m];		
		comb(0,0);
		System.out.println(set.size());

	}

}
