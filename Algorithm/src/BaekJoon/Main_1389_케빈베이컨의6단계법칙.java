package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_1389_케빈베이컨의6단계법칙 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int INF=Integer.MAX_VALUE;
		int[][] arr=new int[N+1][N+1];
		
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j]=INF;
				if(i==j) {
					arr[i][j]=0;
				}
			}
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			arr[a][b]=1;
			arr[b][a]=1;
		}
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(arr[i][k]!=INF && arr[k][j]!=INF) {
						arr[i][j]=Math.min(arr[i][j], arr[i][k]+arr[k][j]);
					}
				}
			}
		}
		
		int min=Integer.MAX_VALUE;
		int minidx=0;
		for(int i=1;i<=N;i++) {
			int sum=0;
			for(int j=1;j<=N;j++) {
				sum+=arr[i][j];
			}
			if(sum<min) {
				min=sum;
				minidx=i;
			}
		}
		
		System.out.println(minidx);
	}

}
