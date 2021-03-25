package SWEA;
import java.util.*;
import java.io.*;
public class Solution_D6_1263_사람네트워크2 {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int N=Integer.parseInt(st.nextToken());
			
			int[][] arr=new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i!=j&&arr[i][j]==0) {
						arr[i][j]=INF;
					}
				}
			}
			
		
			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(arr[i][k]!=INF && arr[k][j]!=INF) {
							arr[i][j]=Math.min(arr[i][j],arr[i][k]+arr[k][j]);
						}
					}
				}
			}
			
			int min=INF;
			for(int i=0;i<N;i++) {
				int ret=0;
				for(int j=0;j<N;j++) {
					ret+=arr[i][j];
				}
				min=Math.min(min,ret);
			}
			
			sb.append("#"+t+" "+min+"\n");
			
		}
		
		System.out.println(sb.toString());

	}

}
