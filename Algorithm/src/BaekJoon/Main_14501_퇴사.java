package BaekJoon;
import java.util.*;
import java.io.*;
public class Main_14501_퇴사 {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[] dp=new int[N+2];
		int[] t=new int[N+1];
		int[] p=new int[N+1];
		for(int i=1;i<=N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			t[i]=Integer.parseInt(st.nextToken());
			p[i]=Integer.parseInt(st.nextToken());
		}
		
		// N번째 배열부터 생각
		for(int i=N;i>0;i--) { 
			if(i+t[i]>N+1) { // 일을 못할 때
				dp[i]=dp[i+1];
			}
			else { // 일을 할 때
				dp[i]=Math.max(dp[i+1], dp[i+t[i]]+p[i]); //t[i]만큼 일을 하고 p[i]의 수익을 i+t[i]번째날 얻는것과 dp[i+1]이랑 비교해서 최대수익을 저장
			}
		}
		
		
		
		
		System.out.println(dp[1]);
		
		
		
		
		
		
	}
	
	

}
