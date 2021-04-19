package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_16918_봄버맨 {
	
	static int R,C,N;
	static char[][] arr;
	static int[] dr= {-1,1,0,0}, dc= {0,0,-1,1};
	static Queue<int[]> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		
		arr=new char[R][C];
		q=new LinkedList<>();
		for(int i=0;i<R;i++) {
			String s=br.readLine();
			for(int j=0;j<C;j++) {
				arr[i][j]=s.charAt(j);
			}
		}
		
		for(int i=1;i<=N;i++) {
			if(i<=3) { // 초기상태에서 3초까지
				if(i%3==1) one();
				else if(i%3==2) two();
				else if(i%3==0) three();				
			}
			else { // 그 이후부터는 번갈아가면서 수행
				if(i%2==0) { // 큐에 넣고 바로 폭탄 설치
					one();
					two();
				}
				else { // 폭탄 터짐
					three();
				}
			}
		}
		

		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	// 큐에 이미 설치되어 있는 폭탄 넣기
	public static void one() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j]=='O') {
					q.offer(new int[] {i,j});
				}
			}
		}
		
	}
	
	// 폭탄이 없는 곳에 폭탄 설치
	public static void two() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j]=='.') {
					arr[i][j]='O';
				}
			}
		}

	}
	
	// 폭탄이 터짐
	public static void three() {
		while(!q.isEmpty()) {
			int[] curr=q.poll();
			arr[curr[0]][curr[1]]='.';
			
			for(int i=0;i<4;i++) {
				int nr=curr[0]+dr[i];
				int nc=curr[1]+dc[i];
				
				if(nr>=0 && nr<R && nc>=0 && nc<C) {
					arr[nr][nc]='.'; // 폭탄이 터짐, 연쇄반응이 일어나지 않기 때문에 큐에 넣지 않음
				}
			}
		}

	}

}
