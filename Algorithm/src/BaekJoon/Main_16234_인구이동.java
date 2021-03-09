package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_16234_인구이동 {
	
	static int N,L,R,area,cnt,areaSum,ans,flag;
	static int[][] map;
	static int[][] check;
	static boolean[][] v;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
			
		while(true) {
			check=new int[N][N];
			v=new boolean[N][N];
			area=0;
			flag=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					cnt=0;
					areaSum=0;
					if(!v[i][j]) {
						area++;
						bfs(i,j);
					}
				}
			}	
			if(flag==0) break;
			ans++;
		}
		
		System.out.println(ans);
	}
	
	public static void bfs(int r,int c) {
		v[r][c]=true;
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int[] curr=q.poll();
			check[curr[0]][curr[1]]=area;
			cnt++;
			areaSum+=map[curr[0]][curr[1]];
			for(int i=0;i<4;i++) {
				int nr=curr[0]+dr[i];
				int nc=curr[1]+dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && !v[nr][nc]) {
					int gap=Math.abs(map[curr[0]][curr[1]]-map[nr][nc]);
					if(gap>=L && gap<=R) {
						flag=1;
						q.offer(new int[] {nr,nc});
						v[nr][nc]=true;						
					}
					
				}
			}
		}
		
		if(cnt>1) {
			int change=areaSum/cnt;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(check[i][j]==area) {
						map[i][j]=change;
					}
				}
			}
		}
		
	}
	
	

}
