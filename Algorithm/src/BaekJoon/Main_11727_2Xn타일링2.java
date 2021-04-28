package BaekJoon;
import java.io.*;
public class Main_11727_2Xn타일링2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		int[] dp=new int[1001];
		
		dp[1]=1;
		dp[2]=3;
		
		for(int i=3;i<=n;i++) {
			dp[i]= (2*dp[i-2]+dp[i-1])%10007; 
		}			
	
		
		System.out.println(dp[n]);
	}

}
