package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D3_5215_햄버거다이어트 {
	static int[][] info;
	static int[] sel;
	static int N,L,ans;
	
	public static void combination(int cnt,int idx,int num) {
		if(cnt==sel.length) {
			int calsum=0;
			int tastesum=0;
			for(int i=0;i<sel.length;i++) {
				calsum+=info[sel[i]][1];
				tastesum+=info[sel[i]][0];
			}
			
			if(calsum<=L) {
				ans=Math.max(tastesum, ans);
			}
			return;
		}
		
		for(int i=idx;i<info.length;i++) {
			sel[cnt]=i;
			combination(cnt+1,i+1,num);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		
		for(int t=1;t<=T;t++) {
			ans=0;
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			L=Integer.parseInt(st.nextToken());
			
			info=new int[N][2];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<2;j++) {
					info[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=1;i<=N;i++) {
				sel=new int[i];
				combination(0,0,i);
			}
			
			System.out.println("#"+t+" "+ans);
			
		}
		

	}

}
