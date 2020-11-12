package BaekJoon;
import java.util.*;
import java.io.*;
public class Solution_2309_SevenDwarf {

	public static int[] d,a;
	public static boolean[] v;
	public static void comb(int start,int count) {
		if(count==7) {
			int sum=0;
			for(int i=0;i<7;i++) {
				sum=sum+a[i];
			}
			
			if(sum==100) {
				Arrays.sort(a);
				for(int i=0;i<7;i++) {
					System.out.println(a[i]);
				}
				System.exit(0);
			}
			return;
		}
		
		for(int i=start;i<9;i++) {
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
		
		d=new int[9];
		a=new int[7];
		v=new boolean[9];
		
		for(int i=0;i<9;i++) {
			d[i]=Integer.parseInt(br.readLine());
		}
		
		comb(0,0);
		

	}

}
