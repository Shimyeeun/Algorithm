import java.util.*;
import java.io.*;
public class Main_1600_말이되고픈원숭이 {

	static int K,W,H,cnt,ans=-1;
	static int[][] arr;
	static boolean[][][] v;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	static int[] hr= {-1,-2,-2,-1,1,2,2,1},hc= {-2,-1,1,2,2,1,-1,-2};

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		K=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		W=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		
		arr=new int[H][W];
		v=new boolean[K+1][H][W];
		for(int i=0;i<H;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		System.out.println(ans);

	}
	

	public static void bfs() {
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {K,0,0});
		v[K][0][0]=true;
		while(!q.isEmpty()) {
			int size=q.size();
			
			for(int k=0;k<size;k++) {
				int[] curr=q.poll();
				
				if(curr[1]==H-1 && curr[2]==W-1) {
					ans=cnt;
					return;
				}
				
				for(int i=0;i<4;i++) {
					int nk=curr[0];
					int nr=curr[1]+dr[i];
					int nc=curr[2]+dc[i];
					if(nr>=0 && nr<H && nc>=0 && nc<W && !v[nk][nr][nc] && arr[nr][nc]==0) {
						q.offer(new int[] {nk,nr,nc});
						v[nk][nr][nc]=true;
					}
				}
				
				if(curr[0]>0) {
					for(int i=0;i<8;i++) {
						int nk=curr[0]-1;
						int nr=curr[1]+hr[i];
						int nc=curr[2]+hc[i];
						
						if(nr>=0 && nr<H && nc>=0 && nc<W && !v[nk][nr][nc] && arr[nr][nc]==0) {
							q.offer(new int[] {nk,nr,nc});
							v[nk][nr][nc]=true;
						}
					}
				}
			}
			cnt++;							
		}
	}

}
