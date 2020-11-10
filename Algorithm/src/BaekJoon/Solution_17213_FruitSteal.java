package BaekJoon;
import java.util.*;
import java.io.*;
public class Solution_17213_FruitSteal {
	public static int cnt=0,n,m;
	public static int[] d,a;
	public static void comb(int start,int count) {
		if(count==m-n) {
			cnt++;
			return;
		}
		
		for(int i=start;i<n;i++) {
			a[count]=d[i];
			comb(i,count+1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		d=new int[n];
		a=new int[m];
	
		for(int i=0;i<n;i++) {
			d[i]=i;
		}
		
		comb(0,0);
		
		System.out.println(cnt);

	}

}
