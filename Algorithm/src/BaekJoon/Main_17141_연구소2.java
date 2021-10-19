package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_17141_연구소2 {

	static int N,M,min=Integer.MAX_VALUE;
	static int[][] arr,cparr,sel,v;
	static Queue<int[]> q;
	static ArrayList<int[]> list;
	static ArrayList<Integer> ans;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new int[N][N];
		cparr=new int[N][N];
		sel=new int[M][2];
		list=new ArrayList<>();
		ans=new ArrayList<>();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) {
					list.add(new int[] {i,j});
				}
			}
		}
		
		virus(0,0);
		if(min==Integer.MAX_VALUE) {
			System.out.println("-1");
		}
		else {
			System.out.println(min);
		}
		
	}
	
	public static void virus(int cnt,int idx) {
		if(cnt==M) {
			copy(cparr,arr);
			q=new LinkedList<>();
			v=new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(cparr[i][j]==1) {
						v[i][j]=-2;
					}
					else {
						v[i][j]=-1;						
					}
				}
			}
			for(int i=0;i<M;i++) {
				cparr[sel[i][0]][sel[i][1]]=2;
				q.offer(new int[] {sel[i][0],sel[i][1]});
				v[sel[i][0]][sel[i][1]]=0;
			}
			bfs();
			int time=check();
			
			if(time!=-1) {
				min=Math.min(time, min);
			}
			return;
		}
		
		for(int i=idx;i<list.size();i++) {
			sel[cnt][0]=list.get(i)[0];
			sel[cnt][1]=list.get(i)[1];
			virus(cnt+1,i+1);
		}
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int[] curr=q.poll();
			for(int i=0;i<4;i++) {
				int nr=curr[0]+dr[i];
				int nc=curr[1]+dc[i];
				
				if(nr>=0 && nc>=0 && nr<N && nc<N && cparr[nr][nc]==0 && v[nr][nc]==-1) {
					q.offer(new int[] {nr,nc});
					v[nr][nc]=v[curr[0]][curr[1]]+1;
				}
			}
		}
	}
	
	public static void copy(int[][] arr1,int[][] arr2) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr1[i][j]=arr2[i][j];
				if(arr1[i][j]==2) {
					arr1[i][j]=0;
				}
			}
		}
	}
	
	public static int check() {
		int max=Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(v[i][j]==-1) {
					return -1;
				}
				else {
					max=Math.max(v[i][j], max);
				}
			}
		}
		return max;
	}

}
