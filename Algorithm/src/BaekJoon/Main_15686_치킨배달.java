package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_15686_치킨배달 {

	static int N,M;
	static int[][] arr;
	static int sum=0;
	static int min=Integer.MAX_VALUE;
	static Chicken[] sel;
	static boolean[][] v;
	static Home[] h;
	static int c=0;
	public static class Chicken{
		int r,c;

		public Chicken(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	public static class Home{
		int r,c;

		public Home(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	public static void comb(int cnt,int istart,int jstart) {
		if(cnt==sel.length) {
			sum=0;
			for(int i=0;i<h.length;i++) {
				int hmin=Integer.MAX_VALUE;
				for(int j=0;j<sel.length;j++) {
					hmin=Math.min(hmin,Math.abs(sel[j].r-h[i].r)+Math.abs(sel[j].c-h[i].c));				
				}
				sum+=hmin;
			}
		
			min=Math.min(min,sum);
			
			return;
		}
		for(int i=istart;i<N+1;i++) {
			for(int j=1;j<N+1;j++) {
				if(i==istart&&j<jstart) continue;
				
				if(arr[i][j]==2&&!v[i][j]) {
					v[i][j]=true;
					sel[cnt]=new Chicken(i,j);
					comb(cnt+1,i,j+1);
					v[i][j]=false;
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new int[N+1][N+1];
		sel=new Chicken[M];
		v=new boolean[N+1][N+1];
		int homecnt=0;
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					homecnt++;
				}
			}
		}
		
		h=new Home[homecnt];
		homecnt=0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(arr[i][j]==1) {
					h[homecnt]=new Home(i,j);
					homecnt++;
				}
			}
		}
		comb(0,1,1);
		System.out.println(min);
	}

}
