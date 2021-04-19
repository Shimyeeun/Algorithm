package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1194_달이차오른다가자 {

	static int N,M,min;
	static char[][] arr;
	static int[][][] v;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new char[N][M];
		v=new int[N][M][64];
		
		int startr=0;
		int startc=0;
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j]=s.charAt(j);
				if(arr[i][j]=='0') {
					startr=i;
					startc=j;
				}
			}
		}
		
		
		bfs(startr,startc);
		if(min==0) min=-1;
		System.out.println(min);

	}
	
	public static void bfs(int r,int c) {
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {r,c,0});
		v[r][c][0]=0;
		
		while(!q.isEmpty()) {
			int[] curr=q.poll();
			if(arr[curr[0]][curr[1]]=='1') {
				min=v[curr[0]][curr[1]][curr[2]];
				return;
			}
			
			
			for(int i=0;i<4;i++) {
				int nr=curr[0]+dr[i];
				int nc=curr[1]+dc[i];
				int key=curr[2];
				
				
				if(nr>=0 && nr<N && nc>=0 && nc<M && arr[nr][nc]!='#' && v[nr][nc][key]==0 ) {					
					
					if('A'<=arr[nr][nc] && arr[nr][nc]<='F') {
						int nk=1<<(arr[nr][nc]-'A');
						if((key&nk)!=0) {;
							q.offer(new int[] {nr,nc,key});
							v[nr][nc][key]=v[curr[0]][curr[1]][curr[2]]+1;						
							
						}
					}
					
					else if('a'<=arr[nr][nc]&&arr[nr][nc]<='f') {
						int nk= key|(1<<(arr[nr][nc]-'a'));
						if(v[nr][nc][nk]==0) {
							q.offer(new int[] {nr,nc,nk});
							v[nr][nc][key]=v[curr[0]][curr[1]][curr[2]]+1;
							v[nr][nc][nk]=v[curr[0]][curr[1]][curr[2]]+1;													
						}
					}
					
					else {
						q.offer(new int[] {nr,nc,key});
						v[nr][nc][key]=v[curr[0]][curr[1]][curr[2]]+1;																			
					}
					
				}
			}
		}
		
		
		
	}

}
