package SWEA;
import java.io.*;

public class Solution_D3_2805_농작물수확하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N=Integer.parseInt(br.readLine());
			int[][] farm=new int[N][N];
			
			for(int i=0;i<N;i++) {
				String s=br.readLine();
				for(int j=0;j<N;j++) {
					farm[i][j]=s.charAt(j)-'0';
				}
			}
			
			int profit=0;
			if(N==1) {
				profit=farm[0][0];
			}
			else {
				for(int i=0;i<=N/2;i++) {
					for(int j=N/2-i;j<=N/2+i;j++) {
						profit+=farm[i][j];
					}
				}
				for(int i=N/2+1;i<N;i++) {
					for(int j=i-(N/2);j<N-(i-(N/2));j++) {
						profit+=farm[i][j];
					}
				}
			
			}
			
			System.out.println("#"+t+" "+profit);
			
		}

	}

}
