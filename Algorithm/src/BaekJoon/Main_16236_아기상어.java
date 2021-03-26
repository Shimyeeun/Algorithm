package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_16236_아기상어 {

	static int N,ans,time;
	static int[][] arr;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	static boolean[][] v;
	static shark s;
	
	static class fish implements Comparable<fish>{
		int r,c;
		fish(int r,int c){
			this.r=r;
			this.c=c;
		}		
		@Override
		public int compareTo(fish o) {
			if(this.r==o.r) {
				return this.c-o.c;
			}
			return this.r-o.r;
		}
	}
	
	static class shark{
		int r,c,size=2,eat;
		shark(){};
		shark(int r,int c){
			this.r=r;
			this.c=c;
		}
		
		void eatfish(int r,int c) {
			this.r=r;
			this.c=c;
			eat++;
			if(eat==size) {
				eat=0;
				size++;
			}
		}
	}
		
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		v=new boolean[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==9) {
					s=new shark(i,j);
				}
			}
		}
	
		
		 bfs();
		 
		 System.out.println(ans);	
		
		
	}
	
	public static void bfs() {
		Queue<shark> q=new LinkedList<>();
		v[s.r][s.c]=true;
		q.offer(s);
		while(!q.isEmpty()) {
			int size=q.size();

			ArrayList<fish> fish=new ArrayList<>();
			for(int k=0;k<size;k++) {
				shark curr=q.poll();
				for(int i=0;i<4;i++) {
					int nr=curr.r+dr[i];
					int nc=curr.c+dc[i];
					
					if(nr>=0 && nr<N && nc>=0 && nc<N && !v[nr][nc] && arr[nr][nc]<=s.size) {
						v[nr][nc]=true;
						q.offer(new shark(nr,nc));
						if(arr[nr][nc]<s.size && arr[nr][nc]>0) {
							fish.add(new fish(nr,nc));
						}
					}
				}
				
			}
			time++;
			
			
			if(fish.size()!=0) {
				Collections.sort(fish);
				fish f=fish.get(0);
				arr[s.r][s.c]=0;
				s.eatfish(f.r,f.c);
				fish.clear();
				q.clear();
				q.offer(s);
				ans+=time;
				time=0;
				v=new boolean[N][N];
				v[s.r][s.c]=true;
			}
			
			
		}
		
	}
	

		
		
		
}
