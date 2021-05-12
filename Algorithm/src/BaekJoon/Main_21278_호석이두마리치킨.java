package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_21278_호석이두마리치킨 {

	static int N;
	static int[][] arr;
	static int INF=Integer.MAX_VALUE;
	static int[] sel;
	static int min=Integer.MAX_VALUE,m1,m2;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		arr=new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			Arrays.fill(arr[i], INF); // 배열을 제일 큰 값으로 초기화
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			
			//길이 있으면 배열값 1
			arr[start][end]=1; 
			arr[end][start]=1;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j) {
					arr[i][j]=0; // i,j가 같으면 배열값 0
				}
			}
		}
		
		// 플로이드와샬
		for(int k=1;k<=N;k++) { // 경로
			for(int i=1;i<=N;i++) { //출발지점
				for(int j=1;j<=N;j++) { //도착지점
					if(arr[i][k]!=INF && arr[k][j]!=INF) {
						arr[i][j]=Math.min(arr[i][k]+arr[k][j], arr[i][j]);	// 경로를 거쳐온것과 바로간것의 최단거리를 저장				
					}
				}
			}
		}
		sel=new int[2];
		comb(0,1); //치킨집 두개를 뽑기위한 조합
		
		System.out.println(m1+" "+m2+" "+(2*min)); //왕복거리이므로 곱하기2
	}
	
	public static void comb(int cnt,int idx) {
		if(cnt==sel.length) {
			int dist=0;
			for(int i=1;i<=N;i++) {
				// 치킨집에서 모든 정점 거리 비교해서 dist에 작은 값 더해주기
				if(arr[i][sel[0]]<=arr[i][sel[1]]) { 
					dist+=arr[i][sel[0]];
				}
				else if(arr[i][sel[0]]>arr[i][sel[1]]) {
					dist+=arr[i][sel[1]];
				}
			}
			// 치킨집 2개를 골랐을 때 최소비용
			if(dist<min) {
				m1=sel[0];
				m2=sel[1];
				min=dist;
			}
			return;
		}
		
		for(int i=idx;i<=N;i++) {
			sel[cnt]=i;
			comb(cnt+1,i+1);
		}
	}

}
