package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D3_9229_한빈이와SpotMart {

	static int N,M,sum,ans;
	static int[] sel=new int[2];
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			arr=new int[N];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			ans=Integer.MIN_VALUE;
			combination(0,0);
			if(ans<0) {
				ans=-1;
			}
			sb.append("#"+t+" "+ans+"\n");
		}
		
		System.out.println(sb.toString());

	}
	
	public static void combination(int cnt,int start) {
		if(cnt==sel.length) {
			sum=0;
			for(int i=0;i<sel.length;i++) {
				sum+=arr[sel[i]];
			}
			
			if(sum<=M) {
				ans=Math.max(ans, sum);
			}
			
			return;
		}
		
		for(int i=start;i<N;i++) {
			sel[cnt]=i;
			combination(cnt+1,i+1);			
		}
	}

}
