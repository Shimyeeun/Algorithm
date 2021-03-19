package BaekJoon;
import java.util.*;
import java.io.*;

public class Main_17144_미세먼지안녕 {
	static int R,C,T;
	static int[][] arr;
	static Queue<int[]> q;
	static int[] dr= {-1,1,0,0},dc= {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		q=new LinkedList<>();
		arr=new int[R][C];
		
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				
				int a=Integer.parseInt(st.nextToken());
				arr[i][j]=a;
				
				if(a!=0 && a!=-1) {
					q.offer(new int[] {i,j,1}); // 동시에 확산하므로 큐에 미리 넣어줌
				} 
			}
		}
		
		bfs();
		
		int sum=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j]>0) {
					sum+=arr[i][j];
				}
			}
		}
		System.out.println(sum);
		
	}
	
	public static void bfs() {
		int[] curr=q.peek();
		int[][] first=new int[R][C];
		int time=1;
		
		copy(arr,first); 
		while(!q.isEmpty()) {
			curr=q.peek();
			int nt=curr[2];
			
			if(time!=nt) { // q에 있는 꼭대기값의 시간이 달라지면 1초가 지났다
				time=nt;
				copy(arr,first); // 초마다 배열 값 copy
				
				for(int i=2;i<R;i++) {
					if(arr[i][0]==-1) {
						cleanerT(i,0); // 공기청정기 위로 작동
						cleanerB(i+1,0); // 공기청정기 아래로 작동
						copy(arr,first); // 공기청정기 작동 후 값 copy
						break;
					}
				}
				
				q.clear(); // 큐 비우고
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++) {
						if(arr[i][j]>0) {
							q.offer(new int[] {i,j,time}); // 새로운 초에 쓰일 값 큐에 넣음
						}
					}
				}
			}
			if(curr[2]>T) {
				break;
			}
			curr=q.poll();
			
			int cnt=0;
			for(int i=0;i<4;i++) {
				int nr=curr[0]+dr[i];
				int nc=curr[1]+dc[i];
				int t=curr[2];
				
				if(nr>=0 && nr<R && nc>=0 && nc<C && first[nr][nc]!=-1) {
					q.offer(new int[] {nr,nc,t+1});
					arr[nr][nc]+=first[curr[0]][curr[1]]/5; // first라는 원래 배열을 가지고 변경,arr은 값이 추가되어서 바뀌기 때문
					cnt++;
				}
			}
			arr[curr[0]][curr[1]]=arr[curr[0]][curr[1]]-first[curr[0]][curr[1]]/5*cnt;
			
		}
	}
	
	
	public static void copy(int[][] arr1, int[][] arr2) {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				arr2[i][j]=arr1[i][j];
			}
		}
	}
	
	// 반시계 방향으로 돌리기
	public static void cleanerT(int r,int c) {
		int[][] first=new int[R][C];
		copy(arr,first);
		right(r,c,first);
		up(r,C-1,first);
		left(0,C-1,first);
		down(0,0,first);
	}
	
	//시계방향으로 돌리기
	public static void cleanerB(int r,int c) {
		int[][] first=new int[R][C];
		copy(arr,first);
		right(r,c,first);
		down(r,C-1,first);
		left(R-1,C-1,first);
		up(R-1,0,first);
	}
	
	public static void right(int r,int c,int[][] first) {
		for(int j=0;j<C-1;j++) {
			if(first[r][j]==-1) arr[r][j+1]=0;
			else arr[r][j+1]=first[r][j];
			
		}
	}
	
	public static void up(int r,int c,int[][] first) {
		for(int i=r;i>0;i--) {
			if(arr[i-1][c]==-1) break;
			arr[i-1][c]=first[i][c];
		}
	}
	
	public static void left(int r,int c,int[][] first) {
		for(int j=c;j>0;j--) {
			arr[r][j-1]=first[r][j];
		}
	}
	
	public static void down(int r,int c,int[][] first) {
		for(int i=r;i<R-1;i++) {
			if(arr[i+1][c]==-1) break;
			arr[i+1][c]=first[i][c];
		}
	}

}
