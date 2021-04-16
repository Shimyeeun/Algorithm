package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_20057_마법사상어와토네이도 {

	static int N,out;
	static int[][] arr;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N+1][N+1];;
		for(int i=1;i<=N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}			
		}
		
		tornado((N+1)/2,(N+1)/2,2,1);
		System.out.println(out);
		
	}
	
	public static void tornado(int r,int c,int d,int move) {
		 
		 int cnt=0;
		 int nr=r;
		 int nc=c;
		 while(cnt<2) {
			 for(int i=1;i<=move;i++) {
				 
				
				 if(nr==1 && nc==1) return;
				 nr=nr+dr[d];
				 nc=nc+dc[d];
				 
				 sand(nr,nc,d);
				 				 
				 if(i==move) {
					 if(d==2) d=1;
					 else if(d==1) d=3;
					 else if(d==3) d=0;
					 else if(d==0) d=2;
				 }
				 
			 }
			 cnt++;
		 }
		 
		 tornado(nr,nc,d,move+1);
		 if(nr==1 && nc==1) return;
	}
	
	public static void sand(int r,int c,int d) {
		int alpha=arr[r][c];
		arr[r][c]=0;
		int p1=(int)(alpha*0.01);
		int p2=(int)(alpha*0.02);
		int p5=(int)(alpha*0.05);
		int p7=(int)(alpha*0.07);
		int p10=(int)(alpha*0.1);
		
		alpha=alpha-(2*(p1+p2+p7+p10)+p5);
		if(d==2 || d==3) {
			
			// 2%
			if(r-2>0) arr[r-2][c]+=p2;
			else out+=p2;
			
			// 10%,7%,1%
			if(r-1>0) {
				if(c+dc[d]>0 && c+dc[d]<=N) arr[r-1][c+dc[d]]+=p10;
				else out+=p10;
				
				arr[r-1][c-dc[d]]+=p1; // x와 c값이 같기 때문에 항상 범위안에 존재
				arr[r-1][c]+=p7; // y와 c값이 같기 때문에 항상 범위안에 존재
			}
			else out+=(p1+p7+p10);
			
			
			// 5,alpha
			if(c+dc[d]*2>0 && c+dc[d]*2<=N) {
				arr[r][c+dc[d]*2]+=p5; 
				arr[r][c+dc[d]]+=alpha;
			}else if(c+dc[d]>0 && c+dc[d]<=N) {
				out+=p5;
				arr[r][c+dc[d]]+=alpha;
			}else {
				out+=(p5+alpha);
			}
			
			// 10 7 1
			if(r+1<=N) {
				if(c+dc[d]>0 && c+dc[d]<=N) arr[r+1][c+dc[d]]+=p10;
				else out+=p10;
				
				arr[r+1][c-dc[d]]+=p1;
				arr[r+1][c]+=p7;
			}
			else out+=(p7+p10+p1);
			
			// 2
			if(r+2<=N) arr[r+2][c]+=p2;
			else out+=p2;
		}
		else if(d==0 || d==1) {
			// 2%
			if(c-2>0) arr[r][c-2]+=p2;
			else out+=p2;
			
			// 10%,7%,1%
			if(c-1>0) {
				if(r+dr[d]>0 && r+dr[d]<=N) arr[r+dr[d]][c-1]+=p10;
				else out+=p10;
				
				arr[r-dr[d]][c-1]+=p1; // x와 r값이 같기때문에 항상 범위안에 존재
				arr[r][c-1]+=p7; // y와 r값이 같기때문에 항상 범위안에 존재
			}
			else out+=(p1+p7+p10);
			
			
			// 5
			if(r+dr[d]*2>0 && r+dr[d]*2<=N) {
				arr[r+dr[d]*2][c]+=p5; 
				arr[r+dr[d]][c]+=alpha;
			} else if(r+dr[d]>0 && r+dr[d]<=N) {
				out+=p5;
				arr[r+dr[d]][c]+=alpha;
			}
			else out+=(p5+alpha);
			
			// 10 7 1
			if(c+1<=N) {
				if(r+dr[d]>0 && r+dr[d]<=N) arr[r+dr[d]][c+1]+=p10;
				else out+=p10;
				
				arr[r-dr[d]][c+1]+=p1;
				arr[r][c+1]+=p7;
			}
			else out+=(p7+p10+p1);
			
			// 2
			if(c+2<=N) arr[r][c+2]+=p2;
			else out+=p2;
		}
	}

}
