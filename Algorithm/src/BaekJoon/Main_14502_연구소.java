package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_14502_연구소 {
	
	static int N,M;
	static int[][] arr;
	static Queue<int[]> q;
	static ArrayList<int[]> list;
	static int[][] sel;
	static int[][] cparr;
	static boolean[][] v;
	static int max=0;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	
	public static void bfs(int r,int c) {
		
		while(!q.isEmpty()) {
			int[] curr=q.poll();

			for(int i=0;i<4;i++) {
				int nr=curr[0]+dr[i];
				int nc=curr[1]+dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M && cparr[nr][nc]==0 && !v[nr][nc]) {
					q.offer(new int[] {nr,nc});
					cparr[nr][nc]=2;
					v[nr][nc]=true;
				}
			}
		}
		
	}
	
	public static void wall(int cnt, int idx) {
		int safe=0;
		if(cnt==3) {
			copy(cparr,arr);
			for(int i=0;i<3;i++) {
				cparr[sel[i][0]][sel[i][1]]=1;
			}
			
			v=new boolean[N][M];
			findVirus(cparr);
			bfs(0,0);
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(cparr[i][j]==0) {
						safe++;
					}
				}
			}
			
			max=Math.max(safe, max);
			return;
		}
		
		for(int i=idx;i<list.size();i++) {
			sel[cnt][0]=list.get(i)[0];
			sel[cnt][1]=list.get(i)[1];
			wall(cnt+1,i+1);
		}
	}
	
	public static void copy(int[][] arr1,int[][] arr2) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr1[i][j]=arr2[i][j];
			}
		}
	}
	
	public static void findVirus(int[][] arr) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==2) {
					q.offer(new int[] {i,j});
					v[i][j]=true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		list=new ArrayList<>();
		arr=new int[N][M];
		cparr=new int[N][M];
		sel=new int[3][2];
		
		q=new LinkedList<>();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int a=Integer.parseInt(st.nextToken());
				if(a==0) {
					list.add(new int[] {i,j});
				}
				
				arr[i][j]=a;
			}
		}
				
		wall(0,0);
		
		System.out.println(max);
		
		
		

	}

}
