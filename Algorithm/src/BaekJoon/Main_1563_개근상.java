package BaekJoon;
import java.io.*;
public class Main_1563_개근상 {


	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[][][] dp=new int[N+1][2][3]; // 날짜,지각,결석
		int p=1000000;
		dp[1][0][0]=1; // 출석
		dp[1][1][0]=1; // 지각
		dp[1][0][1]=1; // 결석
		
		// i번째 날을 기준으로 올 수 있는 가능한 상항을 더해줌
		for(int i=2;i<=N;i++) {
			dp[i][0][0]=(dp[i-1][0][0]+dp[i-1][0][1]+dp[i-1][0][2])%p; 
			dp[i][0][1]=dp[i-1][0][0]%p; 
			dp[i][0][2]=dp[i-1][0][1]%p; 
			dp[i][1][0]=(dp[i-1][0][0]+dp[i-1][0][1]+dp[i-1][0][2]+dp[i-1][1][0]+dp[i-1][1][1]+dp[i-1][1][2])%p; 
			dp[i][1][1]=dp[i-1][1][0]%p;
			dp[i][1][2]=dp[i-1][1][1]%p;
		}
		
		int ans=0;
		
		for(int i=0;i<2;i++) {
			for(int j=0;j<3;j++) {
				ans+=dp[N][i][j]; // 마지막날의 경우의 수 더해주기
			}
		}
		
		System.out.println(ans%p);

	}
}
	
	