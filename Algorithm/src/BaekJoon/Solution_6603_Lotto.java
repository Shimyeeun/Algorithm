package BaekJoon;
import java.util.*;
import java.io.*;
public class Solution_6603_Lotto {
	public static int k;
	public static int[] d,a;
	public static boolean[] v;
	public static void comb(int start,int count) {
		if(count==6) {
			for(int i=0;i<6;i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<k;i++) {
			
			if(v[i]==false) {
				v[i]=true;
				a[count]=d[i];
				comb(i,count+1);
				v[i]=false;
			}
		
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		k=1;
		
		while(k!=0) {
			StringTokenizer st=new StringTokenizer(br.readLine());	
			k=Integer.parseInt(st.nextToken());
			
			d=new int[k];
			v=new boolean[k];
			a=new int[6];
			for(int i=0;i<k;i++) {
				d[i]=Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);
			System.out.println();
		}
		
		

	}

}
