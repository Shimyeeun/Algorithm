package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D5_1247_최적경로 {
	static int N,min,comx,comy,homex,homey;
	static int[] x,y,sel;
	static ArrayList<Integer> dis;
	static boolean[] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			x=new int[N];
			y=new int[N];
			sel=new int[N];
			v=new boolean[N];
			min=Integer.MAX_VALUE;
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			comx=Integer.parseInt(st.nextToken());
			comy=Integer.parseInt(st.nextToken());
			homex=Integer.parseInt(st.nextToken());
			homey=Integer.parseInt(st.nextToken());
			for(int i=0;i<N;i++) {				
				x[i]=Integer.parseInt(st.nextToken());
				y[i]=Integer.parseInt(st.nextToken());
			}
			
			permutation(0);		
			System.out.println("#"+t+" "+min);
		}
	}
	
	public static void permutation(int k) {
		if(k==sel.length) {
			int sum=0;
			for(int i=0;i<sel.length-1;i++) {
				int distance=Math.abs(x[sel[i]]-x[sel[i+1]])+Math.abs(y[sel[i]]-y[sel[i+1]]);
				
				sum+=distance;
			}
			
			sum=sum+Math.abs(comx-x[sel[0]])+Math.abs(comy-y[sel[0]]);
			sum=sum+Math.abs(homex-x[sel[N-1]])+Math.abs(homey-y[sel[N-1]]);
			if(sum<min) {
				min=sum;
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(v[i]==false) {
				sel[k]=i;
				v[i]=true;
				permutation(k+1);
				v[i]=false;
			}
		}
	}
	
	
}
