package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_13424_비밀모임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		int INF=Integer.MAX_VALUE;
		for(int t=0;t<T;t++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int min=Integer.MAX_VALUE;
			int ans=0;
			int[][] arr=new int[N+1][N+1];
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(i!=j) {
						arr[i][j]=INF;
					}
				}
			}
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				
				arr[a][b]=c;
				arr[b][a]=c;
			}
			
			for(int k=1;k<=N;k++) {
				for(int i=1;i<=N;i++) {
					for(int j=1;j<=N;j++) {
						if(arr[i][k]!=INF && arr[k][j]!=INF)
							arr[i][j]=Math.min(arr[i][j], arr[i][k]+arr[k][j]);
					}
				}
			}
			
			st=new StringTokenizer(br.readLine());
			int K=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			int[] student=new int[K];
			for(int i=0;i<K;i++) {
				student[i]=Integer.parseInt(st.nextToken());
			}
			
			int[] res=new int[N+1];
			for(int i=0;i<K;i++) {
				for(int j=1;j<=N;j++) {
					res[j]+=arr[j][student[i]];
				}
			}
			
			for(int i=1;i<=N;i++) {
				if(res[i]<min) {
					min=res[i];
					ans=i;
				}
			}
			
			System.out.println(ans);
				
		}
	}

}
